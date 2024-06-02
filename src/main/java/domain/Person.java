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
public class Person {
    private String name;
    private LocalDate birth;
    private Gender gender;
    private String phone;
    private String email;
    private Address address;
    private List<Appointment> appointments;
    
    public Person(String name, LocalDate birth, Gender gender, String phone, String email, Address address){
        this.name=name;
        this.birth=birth;
        this.gender=gender;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.appointments=new ArrayList<>();
    }
    
    public List<Appointment> getAppointments(){
        return this.appointments;
    }
    
    public void showAppointments(){
        int size = this.appointments.size();
        var x = new StringBuilder(this.appointments.get(size-1).toString() + "\n");
        for(int i=size-2;i>=0;i--){
            x.append(this.appointments.get(i)).append("\n");
        }
        System.out.println(x);
    }
    
    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }  
}
