/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public class Medication {
    private Med medication;
    private String dosage;
    private String frequency;
    
    public Medication(Med medication, String dosage, String frequency){
        this.dosage=dosage;
        this.frequency=frequency;
        this.medication=medication;
    }
}
