/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum Med {
    ASPIRIN("Aspirin"),
    IBUPROFEN("Ibuprofen"),
    AMOXICILLIN("Amoxicillin");
    
    private final String name;
    
    Med(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
