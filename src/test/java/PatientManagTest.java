/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.*;
import java.time.*;
import java.util.*;
import logic.PatientManag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class PatientManagTest {

    public PatientManag getPatman() {
        return patman;
    }

    public Patient getPat() {
        return pat;
    }
    private PatientManag patman = new PatientManag();
    private final String name = "youness";
    private final LocalDate birth = LocalDate.of(2000, Month.NOVEMBER, 17);
    private final Gender gender = Gender.MALE;
    private final String phone = "0606";
    private final String email = "email";
    private final String street = "Jnane";
    private final String city = "Fes";
    private final String state = "Ohio";
    private final String zip = "5045";
    private final String country = "usa";
    private final Address address = new Address(street, city, state, zip, country);
    private final String ssn = "ssn";
    private final String contactName = "yassine";
    private final EmergencyContactRelationship relation = EmergencyContactRelationship.FRIEND;
    private final String contactPhone = "0752";
    private final BloodType blood = BloodType.AB;
    private final MaritalStatus status = MaritalStatus.SINGLE;
    private final Map<PreExistingCondition, LocalDate> conditions = new HashMap<>();
    private final List<Surgery> surgeries = new ArrayList<>();
    private final List<Hospitalization> hospitalizations = new ArrayList<>();
    private final Map<AllergySubstance, AllergyReaction> allergyMap = new HashMap<>();
    private final Map<PreExistingCondition, ArrayList<FamilyMember>> familyMedicalHistory = new HashMap<>();
    private final  List<Medication> medications = new ArrayList<>();
    private final List<MedicalVisit> visits = new ArrayList<>();
    private MedicalHistory history = new MedicalHistory(conditions,surgeries, hospitalizations,allergyMap,familyMedicalHistory,medications,visits );
    private Patient pat = new Patient(name, birth, gender, phone, email, address, ssn, contactName, relation, contactPhone, blood, status, history);
    
    public PatientManagTest() {
        this.patman.addPatient(name, birth, gender, phone, email, address, ssn, contactName, relation, contactPhone, blood, status, history);
    }
    
    @Test 
    void test0(){
        assertTrue(this.pat.equals(this.patman.getPatientForSSN(ssn)));
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
