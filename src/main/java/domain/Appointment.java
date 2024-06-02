/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class Appointment {

    private Patient patient;
    private Specialization department;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private VisitPurpose purpose;
    private UUID id;
    private int duration;
    
    public Appointment(Patient patient, Specialization department, Doctor doctor, LocalDate date, LocalTime time, VisitPurpose purpose, int dur) {
        this.patient = patient;
        this.department = department;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.purpose = purpose;
        this.id = UUID.randomUUID();
        this.duration = dur;
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public Specialization getDepartment() {
        return department;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public VisitPurpose getPurpose() {
        return purpose;
    }

    public UUID getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return "Doctor: " + this.doctor.getName() + "\n" + 
                "Date: " + this.date + "\n" + 
                "Time: " + this.time + "\n" + 
                "Purpose: " + this.purpose;
    }
    
    public boolean canAppointCanceled(){
        LocalDate d = LocalDate.now();
        return d.isBefore(this.date.minusDays(1));
    }
}
