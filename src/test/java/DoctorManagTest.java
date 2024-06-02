/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.*;
import java.time.*;
import java.util.*;
import logic.DoctorManag;
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
public class DoctorManagTest {

    public DoctorManag getDocman() {
        return docman;
    }

    public Doctor getDoc() {
        return doc;
    }
    private DoctorManag docman = new DoctorManag();
    private final String name = "youness";
    private final LocalDate birth = LocalDate.of(2000, Month.NOVEMBER, 17);
    private final String license = "license";
    private final Gender gender = Gender.MALE;
    private final String phone = "0606";
    private final String email = "email";
    private final String street = "Jnane";
    private final String city = "Fes";
    private final String state = "Ohio";
    private final String zip = "5045";
    private final String country = "usa";
    private final Address address = new Address(street, city, state, zip, country);
    private final Specialization specialty = Specialization.GENERAL;
    private final Qualification qualif = Qualification.MBBS;
    private ArrayList<Qualification> quaList = new ArrayList<>();
    private final int exp = 6;
    private final WorkingHours wh = new WorkingHours(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(17, 30), LocalTime.of(13, 30), LocalTime.of(14,30));
    private final OnCallHours ch = new OnCallHours(DayOfWeek.SATURDAY, LocalTime.of(10, 30), LocalTime.of(12, 30));
    private ArrayList<WorkingHours> whList = new ArrayList<>();
    private ArrayList<OnCallHours> chList = new ArrayList<>();
    private ArrayList<DayOfWeek> offDays = new ArrayList<>();
    private Schedule schedule;
    private Doctor doc;
    private ArrayList<Doctor> list;
    

    @BeforeEach
    public void setUp(){    
        this.list = this.docman.getDoctorsBasedOnSpecialtyDate(specialty, LocalDate.now(), LocalTime.of(9, 30));
    }
    
    @Test
    void test0(){
        assertFalse(this.docman.getMap().isEmpty());
        assertEquals(this.doc, this.docman.getDoctorForLicense(license));
    }
    
    @Test
    void test1(){
        assertFalse(this.list.isEmpty());
        assertTrue(this.docman.getDoctorForName(specialty, LocalDate.now(), LocalTime.of(9, 30), name).equals(this.doc));
    }
    
    
    
    public DoctorManagTest() {
        this.quaList.add(qualif);
        this.chList.add(ch);
        this.whList.add(wh);
        this.offDays.add(DayOfWeek.MONDAY);
        this.schedule=new Schedule(whList, chList, offDays);
        this.doc = new Doctor(name, birth, license, gender, phone, email, address, specialty, quaList, exp, schedule);
        this.docman.addDoctor(name, birth, license, gender, phone, email, address, specialty, quaList, exp, schedule);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
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
