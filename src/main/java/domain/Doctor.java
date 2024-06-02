/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author hp
 */
public class Doctor extends Person{
    private final Specialization specialty;
    private ArrayList<Qualification> qualification;
    private final int yearsOfExperience;
    private Schedule schedule;
    private final String licenseNumber;
    
    public Doctor(String name, LocalDate birth, String license, Gender gender, String phone, String email, Address address, Specialization specialty, ArrayList<Qualification> qualif, int exp, Schedule schedule){
        super(name, birth, gender, phone, email, address);
        this.qualification=qualif;
        this.schedule=schedule;
        this.specialty=specialty;
        this.yearsOfExperience=exp;
        this.licenseNumber=license;
    }
    
    
    public Specialization getSpecialty() {
        return specialty;
    }

    public ArrayList<Qualification> getQualification() {
        return qualification;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Schedule getSchedule() {
        return schedule;
    }
    
    public String getLicense(){
        return this.licenseNumber;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.licenseNumber);
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
        final Doctor other = (Doctor) obj;
        return Objects.equals(this.licenseNumber, other.licenseNumber);
    }
}
