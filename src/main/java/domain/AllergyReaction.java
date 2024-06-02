/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum AllergyReaction {
    HIVES("Hives"),
    ANAPHYLAXIS("Anaphylaxis"),
    HAYFEVER("Hay Fever"),
    ASTHMAEXACERBATION("Asthma Exacerbation"),
    DERMATITIS("Contact Dermatitis");
    
    private final String name;
    
    AllergyReaction(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
