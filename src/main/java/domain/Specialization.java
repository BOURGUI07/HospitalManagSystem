/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum Specialization {
    EMERGENCY("Emergency Medicine"),
    CARDIOLOGY("Cardiology"),
    UROLOGY("Urology"),
    OPHTALMOLOGY("Ophtalmology"),
    DERMATOLOGY("Dermatology"),
    PEDIATRICS("Pediatrics"),
    GENERAL("General Medicine");
    
    private final String name;
    
    Specialization(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
