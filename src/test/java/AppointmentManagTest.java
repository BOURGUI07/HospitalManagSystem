/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import logic.*;
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
public class AppointmentManagTest {
    private AppointmentManag appmanag;
    private DoctorManag docmanag;
    private PatientManag patmanag;
    private DoctorManagTest doctest = new DoctorManagTest();
    private PatientManagTest pattest = new PatientManagTest();
    private Doctor doc;
    private Patient pat;
    private Appointment app;
    private Bill bill;
    
    public AppointmentManagTest() {
        this.docmanag = this.doctest.getDocman();
        this.patmanag = this.pattest.getPatman();
        this.appmanag = new AppointmentManag(this.docmanag,this.patmanag);
        this.doc = this.doctest.getDoc();
        this.pat = this.pattest.getPat();
        this.app= appmanag.makeAppointment(pat, Specialization.GENERAL, doc, LocalDate.of(2024, Month.MAY, 29), LocalTime.of(9, 30), VisitPurpose.ROUTINE, 30);
        this.bill = this.appmanag.billPatient(app, Payment.CASH);
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
    
    @Test
    void test0(){
        assertNotNull(this.app);
        assertFalse(this.doc.getAppointments().isEmpty());
        assertFalse(this.pat.getAppointments().isEmpty());
    }
    
    @Test
    void test1(){
        var id = this.app.getId().toString();
        this.appmanag.cancelAppointment(id);
        assertFalse(this.doc.getAppointments().isEmpty());
        assertFalse(this.pat.getAppointments().isEmpty());
    }
    
    @Test
    void test2(){
        assertNotNull(this.bill);
        assertFalse(this.pat.getBills().isEmpty());
        assertEquals(250.0, this.bill.getTotalBill());
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
