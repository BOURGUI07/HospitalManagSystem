/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.*;
import java.time.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author hp
 */
public class AppointmentManag {
    private DoctorManag docmanag;
    private PatientManag patmanag;
    private Map<Patient, ArrayList<Appointment>> patMap;
    private Map<Doctor, ArrayList<Appointment>> docMap;
    private Map<UUID, Appointment> appMap;
    private Map<UUID, Bill> billMap;
    private Map<Appointment, Bill> billAppMap;
    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);
    
    public AppointmentManag(DoctorManag doc, PatientManag patmanag){
        this.docmanag = doc;
        this.patmanag = patmanag;
        this.patMap=new HashMap<>();
        this.docMap=new HashMap<>();
        this.appMap=new HashMap<>();
        this.billMap=new HashMap<>();
        this.billAppMap = new HashMap<>();
    }    
    
    public Map<Patient, ArrayList<Appointment>> getPatMap() {
        return patMap;
    }

    public Map<Doctor, ArrayList<Appointment>> getDocMap() {
        return docMap;
    }
    
    public Appointment makeAppointment(Patient p, Specialization specialty, Doctor d, LocalDate date, LocalTime time, VisitPurpose purpose, int dur){
        if(p!=null && d!=null){
            if(this.docmanag.getDoctorForName(specialty, date, time, d.getName())!=null){
                Appointment app = new Appointment(p, specialty, d, date, time, purpose, dur);
                this.makeAppointmentChanges(app);
                this.appMap.put(app.getId(), app);
                return app;
            }else{
                throw new IllegalArgumentException("No doctor available for the conditions you have");
            }      
        }else if(p==null){
            throw new IllegalArgumentException("Patient can't be null");
        }else if(d==null){
            throw new IllegalArgumentException("Doctor can't be null");
        }
        return null;
    }
    
    public void makeAppointmentChanges(Appointment app){
        Patient patient = app.getPatient();
        Doctor doctor = app.getDoctor();
        if(this.docMap.containsKey(doctor)){           
            
        }else{
            this.docMap.put(doctor, new ArrayList<>());
            doctor.getAppointments().add(app);
        }
        
        
        if(this.patMap.containsKey(patient)){
            this.patMap.get(patient).add(app);
            
        }else{
            this.patMap.put(patient, new ArrayList<>());
            this.patMap.get(patient).add(app);
        }
        
        doctor.getAppointments().add(app);
        patient.getAppointments().add(app);
    }
    
    public void cancelAppointment(String id){
        var app = this.getAppoint(id);
        var bill = this.billAppMap.get(app);
        if(app!=null){
            Doctor d = app.getDoctor();
            Patient p = app.getPatient();
            if(app.canAppointCanceled()){
                d.getAppointments().remove(app);
                p.getAppointments().remove(app);
                this.docMap.get(d).remove(app);
                this.patMap.get(p).remove(app);
                this.billMap.remove(bill.getId());
                p.getBills().remove(bill);
                this.billAppMap.remove(app);
            }
        }else{
            throw new IllegalArgumentException("No id For Appointment");
        }      
    }
    
    public Bill billPatient(Appointment app, Payment pay){
        var bill = new Bill(app,pay);
        app.getPatient().getBills().add(bill);
        this.billMap.put(bill.getId(), bill);
        this.billAppMap.put(app, bill);
        return bill;
    }
    
    public Bill getBill(String id){
        if(this.isValidUUID(id)){
            var idd = UUID.fromString(id);
            if(this.billMap.containsKey(idd)){
                return this.billMap.get(idd);
            }     
        }
        return null;
    }
    
    public Bill getBillForAppoint(Appointment app){
        if(this.billAppMap.containsKey(app)){
            return billAppMap.get(app);
        }else{
            return null;
        }
    }
    
    public void viewDoctorSchedule(String License){
        var d = this.docmanag.getDoctorForLicense(License);
        if(d!=null){
            var list = d.getSchedule().getWorkingHours();
            var s = new StringBuilder("Day\tStartTime\tBreakStart\tBreakEnd\tEndTime\n");
            for(var wh:list){
                s.append(wh.getDay()).append("\t").append(wh.getStart()).append("\t").append(wh.getBreakStart()).append("\t").append(wh.getBreakEnd()).append("\t").append(wh.getEnd()).append("\n");
            }
            System.out.println(s);
        }else{
            throw new IllegalArgumentException("No Doctor for License");
        }
    }
    
    public void viewPatientAppointments(String ssn){
        var p = this.patmanag.getPatientForSSN(ssn);
        if(p==null){
            throw new IllegalArgumentException("No Patient For SSN");
        }else{
            var list = this.patMap.get(p);
            var s = new StringBuilder("AppointmentID\tDepartment\tDoctor\tDate\tTime\tVisit Purpose\tDuration(in mins)\n");
            for(var a:list){
                s.append(a.getId()).append("\t").append(a.getDepartment()).append("\t").append(a.getDoctor().getName()).append("\t").append(a.getDate()).append("\t").append(a.getTime()).append("\t").append(a.getPurpose()).append("\t").append(a.getDuration()).append("\n");
            }
            System.out.println(s);
        }
    }
    
    public Appointment getAppoint(String id){
        if(this.isValidUUID(id)){
            var idd = UUID.fromString(id);
            if(this.appMap.containsKey(idd)){
                return this.appMap.get(idd);
            }     
        }
        return null;
    }

    public boolean isValidUUID(String uuidString) {
        if (uuidString == null) {
            return false;
        }
        return UUID_PATTERN.matcher(uuidString).matches();
    }
    
    public void viewOutStandingBills(){
        this.billMap.values().stream().filter(b -> b.isBillUnpaid()).forEach(System.out::println);
    }
}
