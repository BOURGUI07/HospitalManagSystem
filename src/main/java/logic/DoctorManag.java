/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.*;
import java.time.*;
import java.util.*;

/**
 *
 * @author hp
 */
public class DoctorManag {
    private Map<String,Doctor> map;
    
    public DoctorManag(){
        this.map=new HashMap<>();
    }
    
    public void addDoctor(String name, LocalDate birth, String license, Gender gender, String phone, String email, Address address, Specialization specialty, ArrayList<Qualification> qualif, int exp, Schedule schedule){
        Doctor doctor = new Doctor( name,  birth, license,  gender,  phone,  email,  address,  specialty,  qualif,  exp,  schedule);
        if(this.map.containsValue(doctor)){
            throw new IllegalArgumentException("The doctor is already in the list");
        }else{
            this.map.put(doctor.getLicense(), doctor);
        }
    }
    
    public Map<String, Doctor> getMap(){
        return this.map;
    }
    
    public Doctor getDoctorForLicense(String license){
        if(this.map.containsKey(license)){
            return this.map.get(license);
        }else{
            return null;
        }
    }
    
    public ArrayList<Doctor> getDoctorsBasedOnSpecialtyDate(Specialization x, LocalDate date, LocalTime time){
        DayOfWeek day = DayOfWeek.from(date);
        ArrayList<Doctor> list = new ArrayList<>();
        for(Doctor d:this.map.values()){
            WorkingHours wh = d.getSchedule().getWorkingDayForDay(day);
            if(wh!=null){
                if(d.getSpecialty()==x && d.getSchedule().getWorkingDays().contains(day) && wh.isTimeSuitable(time)){
                    list.add(d);
                }
            }else{
                throw new IllegalArgumentException("No working day for the date you chose");
            }
            
        }
        return list;
    }
    
    public Doctor getDoctorForName(Specialization x, LocalDate date, LocalTime time, String name){
        List<Doctor> list = this.getDoctorsBasedOnSpecialtyDate(x, date, time);
        for(Doctor d:list){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }
    
    public void printAppointChoices(ArrayList<Doctor> list){
        var a = new StringBuilder("[0]: " + list.get(0).getName() + "\n");
        for(int i=1; i<list.size();i++){
            a.append("[").append(i).append("] ").append(list.get(i).getName()).append("\n");
        }
        System.out.println(a);
    }
    
    public void viewDoctors(){
        if(this.map.isEmpty()){
            System.out.println("No Doctor is Registrated");
        }else{
            this.map.values().forEach(System.out::println);
        }
    }
}
