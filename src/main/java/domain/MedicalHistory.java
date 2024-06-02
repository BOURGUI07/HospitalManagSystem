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
public class MedicalHistory {
    private Map<PreExistingCondition, LocalDate> conditions;  //PreExistingCondition, Diagnosis Date
    private List<Surgery> surgeries;
    private List<Hospitalization> hospitalizations;
    private Map<AllergySubstance, AllergyReaction> allergyMap;
    private Map<PreExistingCondition, ArrayList<FamilyMember>> familyMedicalHistory;
    private List<Medication> medications;
    private List<MedicalVisit> visits;
    
    public MedicalHistory(Map<PreExistingCondition, LocalDate> conditions, List<Surgery> surgeries, List<Hospitalization> hospitalizations, Map<AllergySubstance, AllergyReaction> allergyMap, Map<PreExistingCondition, ArrayList<FamilyMember>> familyMedicalHistory, List<Medication> medications, List<MedicalVisit> visits){
        this.allergyMap=allergyMap;
        this.conditions=conditions;
        this.familyMedicalHistory=familyMedicalHistory;
        this.visits=visits;
        this.medications=medications;
        this.surgeries=surgeries;
        this.hospitalizations=hospitalizations;
    }   
    
    public Map<PreExistingCondition, LocalDate> getConditions() {
        return conditions;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public Map<AllergySubstance, AllergyReaction> getAllergyMap() {
        return allergyMap;
    }

    public Map<PreExistingCondition, ArrayList<FamilyMember>> getFamilyMedicalHistory() {
        return familyMedicalHistory;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public List<MedicalVisit> getVisits() {
        return visits;
    }
}
