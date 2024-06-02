/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.*;
import java.time.*;
import java.util.*;

/**
 *
 * @author hp
 */
public class AppointmentManag {
    private DoctorManag docmanag;
    private Map<Patient, ArrayList<Appointment>> patMap;
    private Map<Doctor, ArrayList<Appointment>> docMap;
    
    public AppointmentManag(DoctorManag doc){
        this.docmanag = doc;
        this.patMap=new HashMap<>();
        this.docMap=new HashMap<>();
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
    
    public void cancelAppointment(Appointment app){
        Doctor d = app.getDoctor();
        Patient p = app.getPatient();
        if(app.canAppointCanceled()){
            d.getAppointments().remove(app);
            p.getAppointments().remove(app);
            this.docMap.get(d).remove(app);
            this.patMap.get(p).remove(app);
        }
    }
    
    public Bill billPatient(Appointment app, Payment pay){
        var bill = new Bill(app,pay);
        app.getPatient().getBills().add(bill);
        return bill;
    }
}
