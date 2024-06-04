/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface;

import domain.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import logic.*;

/**
 *
 * @author hp
 */
public class Ui {
    private Scanner scanner;
    private DoctorManag docmanag;
    private PatientManag patmanag;
    private AppointmentManag appmanag;
    
    public Ui(Scanner scanner){
        this.scanner=scanner;
        this.docmanag=new DoctorManag();
        this.patmanag=new PatientManag();
        this.appmanag= new AppointmentManag(this.docmanag, this.patmanag);        
    }
    
    private void adminPage(){
        while(true){
            System.out.println("[P]: Manage Patients");
            System.out.println("[D]: Manage Doctors");
            System.out.println("[A]: Manage Appointments");
            System.out.println("[B]: Manage Billing");
            System.out.println("[R]: View Reports");
            System.out.println("[L]: View Audit Logs");
            System.out.println("[X]: Logout");
            String answer = this.scanner.nextLine().toUpperCase();
            if(answer.equals("X")){
                break;
            }
            if(answer.equals("P")){
                this.patientManagPag();
            }else if(answer.equals("D")){
                this.doctorManagPage();
            }else if(answer.equals("A")){
                this.manageAppointmentsPage();
            }else if(answer.equals("B")){
                this.manageBillingPage();
            }else if(answer.equals("R")){
                this.viewReportsPage();
            }else{
                this.viewAuditLogs();
            }
        }
    }
    
    private void manageBillingPage(){
        
    }
    
    private void viewReportsPage(){
        
    }
    
    private void viewAuditLogs(){
        
    }
    
    private void manageAppointmentsPage(){
        while(true){
            System.out.println("[A]: Schedule New Appointment");
            System.out.println("[C]: Cancel Appointment");
            System.out.println("[D]: View Doctor Schedule");
            System.out.println("[P]: View Patient's Appointments");
            System.out.println("[X]: Quit");
            String a = this.scanner.nextLine().toUpperCase();
            if(a.equals("X")){
                break;
            }
            switch(a){
                case "A" -> this.makeNewAppointmentPage();
                case "C" -> this.cancelAppointmentPage();
                case "D" -> this.viewDocSchedule();
                default -> this.viewPatientAppointments();
            }
        }
    }
    
    private void makeNewAppointmentPage(){
        System.out.println("Enter The Patient SSN");
        var p = this.patmanag.getPatientForSSN(this.scanner.nextLine());
        System.out.println("Enter The Specialization");
        System.out.println("Enter The Doctor Specialization");
        System.out.println("[G]: General Medicine");
        System.out.println("[P]: Pediatrics");
        System.out.println("[D]: Dermatology");
        System.out.println("[E]: Emergency Medicine");
        System.out.println("[U]: Urology");
        System.out.println("[O]: Ophtalmology");
        System.out.println("[C]: Cardiology");
        var specialty = this.specialtyMap().get(this.scanner.nextLine().toUpperCase());
        var date = this.getTheDate();
        var time = this.getTheTime();
        System.out.println("Here Are The Doctor Names With Specialization: " + specialty + " Available On: " + date + " At: " + time);
        this.docmanag.getDoctorsBasedOnSpecialtyDate(specialty, date, time).forEach(d -> System.out.println(d.getName()));
        System.out.println("Enter The Doctor Name You Would Like To Make Appointment With");
        var doctor = this.docmanag.getDoctorForName(specialty, date, time, this.scanner.nextLine());
        System.out.println("Enter the Medical Purpose");
        System.out.println("[MJ]: Major Surgery");
        System.out.println("[MN]: Minor Surgery");
        System.out.println("[D]: Diagnostic Testing");
        System.out.println("[S]: Specialist Consultation");
        System.out.println("[R]: Routine Check-up");
        System.out.println("[F]: Follow-up Visit");
        System.out.println("[T]: Consultation For Symptoms");
        var purpose = this.purposeMap().get(this.scanner.nextLine().toUpperCase());
        System.out.println("Enter The Duration The Duration in Minutes");
        var dur = Integer.parseInt(this.scanner.nextLine());
        var app = this.appmanag.makeAppointment(p, specialty, doctor, date, time, purpose, dur);
        if(app!=null){
            System.out.println("Appointment Successfully Registrated");
            System.out.println("Appointmenet ID: " + app.getId());
        }else{
            System.out.println("Failed To Register Appointment. Try again");
            this.makeNewAppointmentPage();
        }
    }
    
    private LocalDate getTheDate(){
        System.out.println("Enter The Date (dd-mm-yy)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  LocalDate.parse(this.scanner.nextLine(), formatter);
    }
    
    private LocalTime getTheTime(){
        System.out.println("Enter the Time: (HH:MM)");
        return LocalTime.parse(this.scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
    }
    
    private void cancelAppointmentPage(){
        System.out.println("Enter The Appointment id");
        String id = this.scanner.nextLine();
        this.appmanag.cancelAppointment(id);
    }
    
    private void viewDocSchedule(){
        System.out.println("Enter The Doctor License Number");
        String license = this.scanner.nextLine();
        this.appmanag.viewDoctorSchedule(license);
    }
    
    private void viewPatientAppointments(){
        System.out.println("Enter the patient ssn");
        String ssn = this.scanner.nextLine();
        this.appmanag.viewPatientAppointments(ssn);
    }
    
    private void patientManagPag(){
        while(true){
            System.out.println("[A]: Add Patient");
            System.out.println("[D]: Delete Patient");
            System.out.println("[H]: View Patient Medical History");
            System.out.println("[V]: View Patients Records");
            System.out.println("[X]: Quit");
            String answer = this.scanner.nextLine().toUpperCase();
            if(answer.equals("X")){
                break;
            }
            switch (answer) {
                case "A" -> this.addPatientPage();
                case "H" -> this.viewPatientHistoryPage();
                case "D" -> this.deletePatientPage();
                default -> this.viewPatientsRecords();
            }
        }
    }
    
    private void deletePatientPage(){
        System.out.println("Enter the Patient SSN");
        String ssn = this.scanner.nextLine();
        this.patmanag.deletePatient(ssn);
    }
    
    private void viewPatientHistoryPage(){
        System.out.println("Enter the Patient SSN");
        String ssn = this.scanner.nextLine();
        this.patmanag.viewPatientMedicalHistory(ssn);
    }
    
    private void viewPatientsRecords(){
        this.patmanag.viewPatients();
    }
    
    private void addPatientPage(){
        System.out.println("Enter the patient name");
        String name = this.scanner.nextLine();
        System.out.println("Enter the birth Year");
        int year = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Enter the birth Month (from 1 to 12)");
        int month = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Enter the Day of Birth (from 1 to 31)");
        int day = Integer.parseInt(this.scanner.nextLine());
        LocalDate birth = LocalDate.of(year, month, day);
        System.out.println("Enter the Patient Gender");
        System.out.println("[M]: Male");
        System.out.println("[F]: Female");
        String ans = this.scanner.nextLine().toUpperCase();
        Gender gender;
        if(ans.equals("M")){
            gender = Gender.MALE;
        }else{
            gender=Gender.FEMALE;
        }
        System.out.println("Enter the patient phone");
        String phone = this.scanner.nextLine();
        System.out.println("Enter the patient email");
        String email = this.scanner.nextLine();
        System.out.println("Enter the patient street");
        String street = this.scanner.nextLine();
        System.out.println("Enter the patient city");
        String city = this.scanner.nextLine();
        System.out.println("Enter the patient state");
        String state = this.scanner.nextLine();
        System.out.println("Enter the patient zip code");
        String zip = this.scanner.nextLine();
        System.out.println("Enter the patient country");
        String country = this.scanner.nextLine();
        var address = new Address(street, city, state, zip, country);
        System.out.println("Enter the patient ssn");
        String ssn = this.scanner.nextLine();
        System.out.println("Enter the patient emergency contact name");
        String contactName = this.scanner.nextLine();
        System.out.println("Enter the patient emergency contact relatioship");
        System.out.println("[S]: Spouse");
        System.out.println("[F]: Friend");
        System.out.println("[P]: Parent");
        String answer = this.scanner.nextLine().toUpperCase();
        var contact = this.emergencyPage(answer);
        System.out.println("Enter " + contactName + "'s Phone");
        String contactPhone = this.scanner.nextLine();
        System.out.println("Enter the patient boodtype");
        String b = this.scanner.nextLine().toUpperCase();
        BloodType blood = this.bloodPage(b);
        System.out.println("Enter the patient marital status");
        System.out.println("[S]: Single");
        System.out.println("[M]: Married");
        System.out.println("[D]: Divorced");
        System.out.println("[W]: Widowed");
        String s = this.scanner.nextLine().toUpperCase();
        MaritalStatus status = this.maritalPage(s);
        var history = this.medicalHistoryPage();
        this.patmanag.addPatient(name, birth, gender, phone, email, address, ssn, contactName, contact, contactPhone, blood, status, history);
        if(this.patmanag.getPatientForSSN(ssn)!=null){
            System.out.println("The Patient: " + name + " with ssn: " + ssn + " is Successfuly Registrated in The System");
        }else{
            System.out.println("Couldn't Add The Patient. Try again");
            this.addPatientPage();
        }
    }
    
    private BloodType bloodPage(String b){      
        if(b.equals("AB")){
            return BloodType.AB;
        }else if(b.equals("A")){
            return BloodType.A;
        }else if(b.equals("B")){
            return BloodType.B;
        }else{
            return BloodType.O;
        } 
    }
    
    private MaritalStatus maritalPage(String s){
        if(s.equals("M")){
            return MaritalStatus.MARRIED;
        }else if(s.equals("S")){
            return MaritalStatus.SINGLE;
        }else if(s.equals("D")){
            return MaritalStatus.DIVORCED;
        }else{
            return MaritalStatus.WIDOWED;
        }
    }
    
    private EmergencyContactRelationship emergencyPage(String b){
        if(b.equals("F")){
            return EmergencyContactRelationship.FRIEND;
        }else if(b.equals("P")){
            return EmergencyContactRelationship.PARENT;
        }else{
            return EmergencyContactRelationship.SPOUSE;
        }
    }
    
    private MedicalHistory medicalHistoryPage(){
        return new MedicalHistory(this.conditionsMap(), this.surgeriesList(), this.hospitalizationList(), this.allergyMap(), this.familyMap(), this.medicationList(), this.medicalVisitMap());
    }
    
    private Map<PreExistingCondition, LocalDate> conditionsMap(){
        var map = new HashMap<PreExistingCondition, LocalDate>();
        while(true){
            System.out.println("Enter the patient pre-existing condition (empty will stop)");
            System.out.println("[H]: Hypertension");
            System.out.println("[D]: Diabetes Type2");
            System.out.println("[A]: Asthma");
            System.out.println("[CO]: Chronic Obstructive Pulmonary Disease");
            System.out.println("[CA]: Coronary Artery Disease");
            System.out.println("[R]: Rheumatoid Arthritis");
            String ans = this.scanner.nextLine().toUpperCase();
            if(ans.isBlank()){
                break;
            }
            PreExistingCondition cond = null;
            switch(ans){
                case "H" -> cond=PreExistingCondition.HYPERTENSION;
                case "R" -> cond=PreExistingCondition.RHEUMATOID;
                case "CO" -> cond=PreExistingCondition.COPD;
                case "CA" -> cond=PreExistingCondition.CAD;
                case "A" -> cond=PreExistingCondition.ASTHMA;
                case "D" -> cond=PreExistingCondition.DIABETES;
            }
            System.out.println("Enter the Diagnosis Date (dd-mm-yyyy)");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String d = this.scanner.nextLine();
            LocalDate date = LocalDate.parse(d, formatter);
            map.put(cond, date);
        }
        return map;
    }
    
    private List<Surgery> surgeriesList(){
        var list =new ArrayList<Surgery>();
        System.out.println("Enter the surgery type (empty will stop)");
        String type = this.scanner.nextLine();
        while(!type.isEmpty()){
            System.out.println("Enter the surgery date(dd-mm-yyyy)");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String d = this.scanner.nextLine();
            LocalDate date = LocalDate.parse(d, formatter); 
            System.out.println("Enter the surgery hospital name");
            String hospital = this.scanner.nextLine();
            System.out.println("Enter the surgeon name");
            String surgeon = this.scanner.nextLine();
            list.add(new Surgery(type, date, hospital, surgeon));
            System.out.println("Enter the surgery type (empty will stop)");
            type = this.scanner.nextLine();
        }
        return list;
    }
    
    private List<Hospitalization> hospitalizationList(){
        var list = new ArrayList<Hospitalization>();
        System.out.println("Enter the hospitalization reason");
        String reason = this.scanner.nextLine();
        while(!reason.isEmpty()){
            System.out.println("Enter the hospitalization date(dd-mm-yyyy)");
            String d = this.scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(d, formatter);
            System.out.println("Enter the hospital namae");
            String hos = this.scanner.nextLine();
            list.add(new Hospitalization(reason, date, hos));
            System.out.println("Enter the hospitalization reason");
            reason = this.scanner.nextLine();
        }
        return list;
    }
    
    private Map<AllergySubstance, AllergyReaction> allergyMap(){
        var map = new HashMap<AllergySubstance, AllergyReaction>();
        System.out.println("Enter the Allergy Substance(Empty will stop)");
        System.out.println("[L]: Latex");
        System.out.println("[M]: Medications");
        System.out.println("[E]: Envirmental");
        System.out.println("[F]: Foods");
        System.out.println("[I]: insect");
        String ans = this.scanner.nextLine();
        while(!ans.isEmpty()){
            var sub = this.substanceMap().get(ans);
            System.out.println("Enter the Allergy Reaction");
            System.out.println("[V]: Hives");
            System.out.println("[F]: Hay Fever");
            System.out.println("[D]: DERMATITIS");
            System.out.println("[E]: ASTHMAEXACERBATION");
            System.out.println("[A]: ANAPHYLAXIS");
            String ans1 = this.scanner.nextLine();
            var reac = this.reactionMap().get(ans1);
            map.put(sub, reac);
            System.out.println("Enter the Allergy Substance(Empty will stop)");
            System.out.println("[L]: Latex");
            System.out.println("[M]: Medications");
            System.out.println("[E]: Envirmental");
            System.out.println("[F]: Foods");
            System.out.println("[I]: insect");
            ans = this.scanner.nextLine();
        }
        return map;
    }
    
    private Map<String, AllergySubstance> substanceMap(){
        var map = new HashMap<String, AllergySubstance>();
        map.put("L", AllergySubstance.LATEX);
        map.put("E", AllergySubstance.ENVIRONMENTAL);
        map.put("F", AllergySubstance.FOODS);
        map.put("M", AllergySubstance.MEDICATION);
        map.put("I", AllergySubstance.INSECT);
        return map;
    }
    
    private Map<String, AllergyReaction> reactionMap(){
        var map = new HashMap<String, AllergyReaction>();
        map.put("V", AllergyReaction.HIVES);
        map.put("A", AllergyReaction.ANAPHYLAXIS);
        map.put("D", AllergyReaction.DERMATITIS);
        map.put("H", AllergyReaction.HAYFEVER);
        map.put("E", AllergyReaction.ASTHMAEXACERBATION);
        return map;
    }
    
    private Map<String, PreExistingCondition> conditionMap(){
        Map<String, PreExistingCondition> map=new HashMap<>();
        map.put("CA", PreExistingCondition.CAD);
        map.put("A", PreExistingCondition.ASTHMA);
        map.put("D", PreExistingCondition.DIABETES);
        map.put("CO", PreExistingCondition.COPD);
        map.put("R", PreExistingCondition.RHEUMATOID);
        map.put("H", PreExistingCondition.HYPERTENSION);
        return map;
    }
    
    private Map<String, FamilyMember> memberMap(){
        Map<String, FamilyMember> map = new HashMap<>();
        map.put("F", FamilyMember.FATHER);
        map.put("A", FamilyMember.AUNT);
        map.put("B", FamilyMember.BROTHER);
        map.put("C", FamilyMember.COUSIN);
        map.put("D", FamilyMember.DAUGHTER);
        map.put("GF", FamilyMember.GRANDFATHER);
        map.put("GM", FamilyMember.GRANDMOTHER);
        map.put("M", FamilyMember.MOTHER);
        map.put("NE", FamilyMember.NEPHEW);
        map.put("NI", FamilyMember.NIECE);
        map.put("S", FamilyMember.SON);
        map.put("U", FamilyMember.UNCLE);
        map.put("T", FamilyMember.SISTER);
        return map;
    }
    
    private Map<PreExistingCondition, ArrayList<FamilyMember>> familyMap(){
        Map<PreExistingCondition, ArrayList<FamilyMember>> map = new HashMap<>();
        System.out.println("Enter the pre-existing condition (empty will stop)");
        System.out.println("[H]: Hypertension");
        System.out.println("[D]: Diabetes Type2");
        System.out.println("[A]: Asthma");
        System.out.println("[CO]: Chronic Obstructive Pulmonary Disease");
        System.out.println("[CA]: Coronary Artery Disease");
        System.out.println("[R]: Rheumatoid Arthritis");
        String ans = this.scanner.nextLine().toUpperCase();
        while(!ans.isEmpty()){
            var cond = this.conditionMap().get(ans);
            var list = new ArrayList<FamilyMember>();
            System.out.println("Enter the family mmeber with the condition(empty will stop)");
            System.out.println("[GF]: Grand Father");
            System.out.println("[GM]: Grand Mother");
            System.out.println("[F]: Father");
            System.out.println("[T]: Sister");
            System.out.println("[B]: Brother");
            System.out.println("[S]: Son");
            System.out.println("[D]: Daughter");
            System.out.println("[U]: Uncle");
            System.out.println("[A]: Aunt");
            System.out.println("[NE]: Nephew");
            System.out.println("[NI]: Niece");
            System.out.println("[M]: Mother");
            String a = this.scanner.nextLine().toUpperCase();
            while(!a.isEmpty()){
                list.add(this.memberMap().get(a));
                System.out.println("Enter the family mmeber with the condition(empty will stop)");
                System.out.println("[GF]: Grand Father");
                System.out.println("[GM]: Grand Mother");
                System.out.println("[F]: Father");
                System.out.println("[T]: Sister");
                System.out.println("[B]: Brother");
                System.out.println("[S]: Son");
                System.out.println("[D]: Daughter");
                System.out.println("[U]: Uncle");
                System.out.println("[A]: Aunt");
                System.out.println("[NE]: Nephew");
                System.out.println("[NI]: Niece");
                System.out.println("[M]: Mother");
                a = this.scanner.nextLine().toUpperCase();
            }
            map.put(cond, list);
            System.out.println("Enter the pre-existing condition (empty will stop)");
            System.out.println("[H]: Hypertension");
            System.out.println("[D]: Diabetes Type2");
            System.out.println("[A]: Asthma");
            System.out.println("[CO]: Chronic Obstructive Pulmonary Disease");
            System.out.println("[CA]: Coronary Artery Disease");
            System.out.println("[R]: Rheumatoid Arthritis");
            ans = this.scanner.nextLine().toUpperCase();
        }
        return map;
    }
    
    private Map<String, Med> medMap(){
        Map<String, Med> map = new HashMap<>();
        map.put("A", Med.ASPIRIN);
        map.put("X", Med.AMOXICILLIN);
        map.put("I", Med.IBUPROFEN);
        return map;
    }
    
    private List<Medication> medicationList(){
        List<Medication> list= new ArrayList<>();
        System.out.println("Enter the The Medication Taken By Patient(Empty will stop)");
        System.out.println("[I]: Ibuprofen");
        System.out.println("[A]: Aspirin");
        System.out.println("[X]: Amoxillicin");
        String m = this.scanner.nextLine().toUpperCase();
        while(!m.isEmpty()){
            Med med = this.medMap().get(m);
            System.out.println("Enter the dosage");
            String dosage = this.scanner.nextLine();
            System.out.println("Enter the frequency");
            String frequency = this.scanner.nextLine();
            list.add(new Medication(med, dosage, frequency));
            System.out.println("Enter the The Medication Taken By Patient(Empty will stop)");
            System.out.println("[I]: Ibuprofen");
            System.out.println("[A]: Aspirin");
            System.out.println("[X]: Amoxillicin");
            m = this.scanner.nextLine().toUpperCase();
        }
        return list;
    }
    
    private Map<String, VisitPurpose> purposeMap(){
        Map<String, VisitPurpose> map = new HashMap<>();
        map.put("MJ", VisitPurpose.MAJOR);
        map.put("MN", VisitPurpose.MINOR);
        map.put("D", VisitPurpose.DIAGNOSTIC);
        map.put("F", VisitPurpose.FOLLOWUP);
        map.put("R", VisitPurpose.ROUTINE);
        map.put("S", VisitPurpose.SPECIALIST);
        map.put("T", VisitPurpose.SYMPTOMS);
        return map;
    }
    
    private List<MedicalVisit> medicalVisitMap(){
        List<MedicalVisit> list = new ArrayList<>();
        System.out.println("Enter the Medical Purpose (Empty Will Stop)");
        System.out.println("[MJ]: Major Surgery");
        System.out.println("[MN]: Minor Surgery");
        System.out.println("[D]: Diagnostic Testing");
        System.out.println("[S]: Specialist Consultation");
        System.out.println("[R]: Routine Check-up");
        System.out.println("[F]: Follow-up Visit");
        System.out.println("[T]: Consultation For Symptoms");
        String m = this.scanner.nextLine().toUpperCase();
        while(!m.isEmpty()){
            var purpose = this.purposeMap().get(m);
            System.out.println("Enter the visit date(dd-mm-yyyy)");
            String d = this.scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(d, formatter);
            list.add(new MedicalVisit(purpose, date));
            System.out.println("Enter the Medical Purpose (Empty Will Stop)");
            System.out.println("[MJ]: Major Surgery");
            System.out.println("[MN]: Minor Surgery");
            System.out.println("[D]: Diagnostic Testing");
            System.out.println("[S]: Specialist Consultation");
            System.out.println("[R]: Routine Check-up");
            System.out.println("[F]: Follow-up Visit");
            System.out.println("[T]: Consultation For Symptoms");
            m = this.scanner.nextLine().toUpperCase();
        }
        return list;
    }
    
    private void doctorManagPage(){
        while(true){
            System.out.println("[A]: Add New Doctor");
            System.out.println("[D]: Delete Doctor");
            System.out.println("[S]: search For Doctor");
            System.out.println("[U]: Update Doctor Schedule");
            System.out.println("[V]: View Doctors");
            System.out.println("[X]: Quit");
            String answer = this.scanner.nextLine().toUpperCase();
            if(answer.equals("X")){
                break;
            }
            if(answer.equals("A")){
                this.addDoctorPage();
            }else if(answer.equals("S")){
                this.searchDoctorPage();
            }else if(answer.equals("V")){
                this.docmanag.viewDoctors();
            }else if(answer.equals("U")){
                this.updateDocSchedule();
            }else{
                this.deleteDocPage();
            }
        }
    }
    
    private void deleteDocPage(){
        System.out.println("Enter The Doctor License Number");
        String license = this.scanner.nextLine();
        this.docmanag.deleteDoctor(license);
    }
    
    private void updateDocSchedule(){
        System.out.println("Enter The Doctor License Number");
        Doctor doc = this.docmanag.getDoctorForLicense(this.scanner.nextLine());
        while(true){
            System.out.println("[A]: Add Days Off");
            System.out.println("[R]: Remove Days Off");
            System.out.println("[X]: Quit");
            String a = this.scanner.nextLine().toUpperCase();
            if(a.equals("X")){
                break;
            }
            if(a.equals("A")){
                System.out.println("Enter The Day");
                System.out.println("[TU]: Tuesday");
                System.out.println("[W]: Wednesday");
                System.out.println("[T]: Thursday");
                System.out.println("[F]: Friday");
                System.out.println("[S]: Saturday");
                System.out.println("[N]: Sunday");
                String d = this.scanner.nextLine();
                var day = this.dayMap().get(d);
                doc.getSchedule().addDayOff(day);
            }else{
                System.out.println("Enter The Day");
                System.out.println("[TU]: Tuesday");
                System.out.println("[W]: Wednesday");
                System.out.println("[T]: Thursday");
                System.out.println("[F]: Friday");
                System.out.println("[S]: Saturday");
                System.out.println("[N]: Sunday");
                String d = this.scanner.nextLine();
                var day = this.dayMap().get(d);
                doc.getSchedule().removeDayOff(day);
            }
        }
    }
    
    private void addDoctorPage(){
        System.out.println("Enter the Doctor Name");
        String name = this.scanner.nextLine();
        System.out.println("Enter the Doctor Birth Date(dd-mm-yyyy)");
        String d = this.scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(d, formatter);
        System.out.println("Enter The Doctor License");
        String license = this.scanner.nextLine();
        System.out.println("Enter the Doctor Gender (M for Male, F for Female)");
        String g = this.scanner.nextLine().toUpperCase();
        Gender gender;
        switch(g){
            case "M" -> gender = Gender.MALE;
            default -> gender = Gender.FEMALE;
        }
        System.out.println("Enter the Doctor phone");
        String phone = this.scanner.nextLine();
        System.out.println("Enter the Doctor email");
        String email = this.scanner.nextLine();
        System.out.println("Enter the Doctor street");
        String street = this.scanner.nextLine();
        System.out.println("Enter the Doctor city");
        String city = this.scanner.nextLine();
        System.out.println("Enter the Doctor state");
        String state = this.scanner.nextLine();
        System.out.println("Enter the Doctor zip code");
        String zip = this.scanner.nextLine();
        System.out.println("Enter the Doctor country");
        String country = this.scanner.nextLine();
        var address = new Address(street, city, state, zip, country);
        System.out.println("Enter The Doctor Specialization");
        System.out.println("[G]: General Medicine");
        System.out.println("[P]: Pediatrics");
        System.out.println("[D]: Dermatology");
        System.out.println("[E]: Emergency Medicine");
        System.out.println("[U]: Urology");
        System.out.println("[O]: Ophtalmology");
        System.out.println("[C]: Cardiology");
        var specialty = this.specialtyMap().get(this.scanner.nextLine().toUpperCase());
        var qualif = this.getQualif();
        System.out.println("Enter The Number of Experience Years");
        int exp = Integer.parseInt(this.scanner.nextLine());
        var schedule = this.getSchedule();
        this.docmanag.addDoctor(name, date, license, gender, phone, email, address, specialty, qualif, exp, schedule);
        if(this.docmanag.getDoctorForLicense(license)!=null){
            System.out.println("Doctor Successfully Added");
        }else{
            System.out.println("Couldn't Add Doctor. Try Again");
            this.addDoctorPage();
        }
    }
    
    private Schedule getSchedule(){
        return new Schedule(this.getWorkingHours(),this.getOnCallHours(),this.getDaysOff());
    }
    
    private ArrayList<WorkingHours> getWorkingHours(){
        var list = new ArrayList<WorkingHours>();
        System.out.println("Enter The Working Day(empty will stop)");
        System.out.println("[M]: Monday");
        System.out.println("[TU]: Tuesday");
        System.out.println("[W]: Wednesday");
        System.out.println("[T]: Thursday");
        System.out.println("[F]: Friday");
        System.out.println("[S]: Saturday");
        System.out.println("[N]: Sunday");
        String a = this.scanner.nextLine();
        while(!a.isEmpty()){
            var day = this.dayMap().get(a);
            System.out.println("Enter The Start Time(hh:mm)");
            String t1 = this.scanner.nextLine();
            LocalTime startTime = LocalTime.parse(t1, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Enter The End Time(hh:mm)");
            String t2 = this.scanner.nextLine();
            LocalTime endTime = LocalTime.parse(t2, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Enter The Start Break Time(hh:mm)");
            String t3 = this.scanner.nextLine();
            LocalTime breakStart = LocalTime.parse(t3, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Enter The End Break Time(hh:mm)");
            String t4 = this.scanner.nextLine();
            LocalTime breakEnd = LocalTime.parse(t4, DateTimeFormatter.ofPattern("HH:mm"));
            list.add(new WorkingHours(day,startTime, endTime, breakStart, breakEnd));
            System.out.println("Enter The Working Day(empty will stop)");
            System.out.println("[M]: Monday");
            System.out.println("[TU]: Tuesday");
            System.out.println("[W]: Wednesday");
            System.out.println("[T]: Thursday");
            System.out.println("[F]: Friday");
            System.out.println("[S]: Saturday");
            System.out.println("[N]: Sunday");
            a = this.scanner.nextLine();
        }
        return list;
    }
    
    private ArrayList<OnCallHours> getOnCallHours(){
        var list = new ArrayList<OnCallHours>();
        System.out.println("Enter The On Call Day(empty will stop)");
        System.out.println("[M]: Monday");
        System.out.println("[TU]: Tuesday");
        System.out.println("[W]: Wednesday");
        System.out.println("[T]: Thursday");
        System.out.println("[F]: Friday");
        System.out.println("[S]: Saturday");
        System.out.println("[N]: Sunday");
        String a = this.scanner.nextLine();
        while(!a.isEmpty()){
            var day = this.dayMap().get(a);
            System.out.println("Enter The Start Time(hh:mm)");
            String t1 = this.scanner.nextLine();
            LocalTime startTime = LocalTime.parse(t1, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Enter The End Time(hh:mm)");
            String t2 = this.scanner.nextLine();
            LocalTime endTime = LocalTime.parse(t2, DateTimeFormatter.ofPattern("HH:mm"));
            list.add(new OnCallHours(day,startTime, endTime));
            System.out.println("Enter The On Call Day(empty will stop)");
            System.out.println("[M]: Monday");
            System.out.println("[TU]: Tuesday");
            System.out.println("[W]: Wednesday");
            System.out.println("[T]: Thursday");
            System.out.println("[F]: Friday");
            System.out.println("[S]: Saturday");
            System.out.println("[N]: Sunday");
            a = this.scanner.nextLine();
        }
        return list;
    }
    
    private ArrayList<DayOfWeek> getDaysOff(){
        var list = new ArrayList<DayOfWeek>();
        System.out.println("Enter The Days Off(empty will stop)");
        System.out.println("[M]: Monday");
        System.out.println("[TU]: Tuesday");
        System.out.println("[W]: Wednesday");
        System.out.println("[T]: Thursday");
        System.out.println("[F]: Friday");
        System.out.println("[S]: Saturday");
        System.out.println("[N]: Sunday");
        String a = this.scanner.nextLine();
        while(!a.isEmpty()){
            list.add(this.dayMap().get(a));
            a = this.scanner.nextLine();
        }
        return list;
    }
    
    private Map<String, DayOfWeek> dayMap(){
        return Map.ofEntries(
                Map.entry("F", DayOfWeek.FRIDAY),
                Map.entry("M", DayOfWeek.MONDAY),
                Map.entry("N", DayOfWeek.SUNDAY),
                Map.entry("T", DayOfWeek.THURSDAY),
                Map.entry("W", DayOfWeek.WEDNESDAY),
                Map.entry("TU", DayOfWeek.TUESDAY),
                Map.entry("S", DayOfWeek.SATURDAY)
        );
    }
    
    private Map<String, Specialization> specialtyMap(){
        return Map.ofEntries(
                
                Map.entry("E", Specialization.EMERGENCY),
                Map.entry("C", Specialization.CARDIOLOGY),
                Map.entry("D", Specialization.DERMATOLOGY),
                Map.entry("G", Specialization.GENERAL),
                Map.entry("O", Specialization.OPHTALMOLOGY),
                Map.entry("P", Specialization.PEDIATRICS),
                Map.entry("U", Specialization.UROLOGY)
                );
    }
    
    private Map<String, Qualification> qualifMap(){
        return Map.ofEntries(
                Map.entry("O", Qualification.DO),
                Map.entry("M", Qualification.MBBS),
                Map.entry("D", Qualification.MD)
        );
    }
    
    private ArrayList<Qualification> getQualif(){
        var list = new ArrayList<Qualification>();
        System.out.println("Enter the Doctor Qualifications(Empty Will Stop)");
        System.out.println("[O]: DO");
        System.out.println("[M]: MBBS");
        System.out.println("[D]: MD");
        String a = this.scanner.nextLine().toUpperCase();
        while(!a.isEmpty()){
            list.add(this.qualifMap().get(a));
            a = this.scanner.nextLine().toUpperCase();
        }
        return list;
    }
    
    private void searchDoctorPage(){
        System.out.println("Enter the doctor license number");
        String a = this.scanner.nextLine();
        Doctor doc = this.docmanag.getDoctorForLicense(a);
        if(doc != null){
            System.out.println(doc);
        }else{
            System.out.println("No Doctor Was Found for the license number");
        }
    }
    
    
}
