/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public final class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;
    
    public Address(String street, String city, String state, String zip, String country){
        this.city=city;
        this.country=country;
        this.state=state;
        this.street=street;
        this.zipCode=zip;
    }
}
