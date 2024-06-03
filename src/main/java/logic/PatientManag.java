/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author hp
 */
public class PatientManag {
    private Map<String, Patient> map;
    
    public PatientManag(){
        this.map=new HashMap<>();
    }
    
    public Map<String, Patient> getMap(){
        return this.map;
    }
    
    public void addPatient(String name, LocalDate birth, Gender gender, String phone, String email, Address address, String ssn, String contactName, EmergencyContactRelationship contact, String contactPhone, BloodType blood, MaritalStatus status, MedicalHistory history){
        Patient p = new Patient(name, birth, gender, phone, email, address, ssn, contactName,  contact,  contactPhone,  blood,  status,  history);
        if(this.map.containsValue(p)){
            throw new IllegalArgumentException("Patient Already in The list");
        }else{
            this.map.put(p.getSSN(),p);
        }
    }
    
    public Patient getPatientForSSN(String ssn){
        if(this.map.containsKey(ssn)){
            return this.map.get(ssn);
        }
        return null;
    }
    
    public void viewPatientMedicalHistory(String ssn){
        var p = this.getPatientForSSN(ssn);
        if(p!=null){
            System.out.println(p.getMedHistory());
        }else{
            throw new IllegalArgumentException("No Patient Found for The SSN");
        }
    }
    
    public void viewPatients(){
        if(!this.map.isEmpty()){
            this.map.values().forEach(System.out::println);
        }else{
            System.out.println("No Patient is Registrated");
        }
    }
    
    public void deletePatient(String ssn){
        var p =this.getPatientForSSN(ssn);
        if(p!=null){
            this.getMap().remove(ssn);
        }else{
            throw new IllegalArgumentException("No Patient For SSN");
        }
    }
}
