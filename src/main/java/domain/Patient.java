/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.time.*;
import java.util.*;
import logic.Bill;

/**
 *
 * @author hp
 */
public class Patient extends Person {
    private String emergencyContactName;
    private EmergencyContactRelationship contact;
    private String emergencyContactPhone; 
    private MedicalHistory medHistory;
    private MaritalStatus maritalStatus;
    private final BloodType blood;
    private String ssn;
    private List<Bill> bills;
    
    public Patient(String name, LocalDate birth, Gender gender, String phone, String email, Address address, String ssn, String contactName, EmergencyContactRelationship contact, String contactPhone, BloodType blood, MaritalStatus status, MedicalHistory history){
        super(name, birth, gender, phone, email, address);
        this.blood=blood;
        this.contact=contact;
        this.emergencyContactName=contactName;
        this.maritalStatus=status;
        this.medHistory=history;
        this.ssn=ssn;
        this.bills=new ArrayList<>();
    }
    
    public List<Bill> getBills(){
        return this.bills;
    }
    
    public String getSSN(){
        return this.ssn;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public EmergencyContactRelationship getContact() {
        return contact;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public MedicalHistory getMedHistory() {
        return medHistory;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public BloodType getBlood() {
        return blood;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public void setContact(EmergencyContactRelationship contact) {
        this.contact = contact;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.ssn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        return Objects.equals(this.ssn, other.ssn);
    }
}
