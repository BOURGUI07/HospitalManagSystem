/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    
    private final String name;
    
    Gender(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
