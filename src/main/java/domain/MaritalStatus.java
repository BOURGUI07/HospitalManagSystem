/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum MaritalStatus {
    SINGLE("Single"),
    MARRIED("Married"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed");
    private final String name;
    MaritalStatus(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
