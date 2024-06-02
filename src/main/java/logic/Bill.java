/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.*;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class Bill {
    private Appointment app;
    private Payment method;
    private UUID id;
    
    public Bill(Appointment app, Payment method){
        this.app=app;
        this.method = method;
        this.id=UUID.randomUUID();
    }
    
    public UUID getId(){
        return this.id;
    }
    
    public Payment getPayment(){
        return this.method;
    }
    
    public Appointment getAppointment(){
        return this.app;
    }
    
    public double getPriceForDuration(int dur){
        switch(dur){
            case 30 -> {            
                return 50.0;
            }
            case 60 -> {return 100.0;}
            case 90 -> {return 150.0;}
            default -> {return 100;}
        }
    }
    
    public double getPriceForExperience(int exp){
        if(exp<=0){
            throw new IllegalArgumentException("Years of exp can't be below 0");
        }
        if(exp>0 && exp<=2){
            return 0.0;
        }else if(exp>=3 && exp<=5){
            return 50.0;
        }else if(exp>=6 && exp<=10){
            return 100.0;
        }else if(exp>=11 && exp<=15){
            return 200.0;
        }else{
            return 300.0;
        }
    }
    
    public double getTotalBill(){
        var purpose = this.app.getPurpose();
        var exp = this.app.getDoctor().getYearsOfExperience();
        var dur = this.app.getDuration();
        var price = this.getPriceForDuration(dur) + this.getPriceForExperience(exp) + purpose.getBasePrice();
        var fee = this.method.getProcessingFee(price);
        return price + fee;
    }
    
    @Override
    public String toString(){
        return "Base Pay for " + this.app.getPurpose() + ": $" + this.getAppointment().getPurpose().getBasePrice() + "\n" + 
                "Price for the " + this.app.getDuration() + " mins : $" + this.getPriceForDuration(this.app.getDuration()) + "\n" + 
                "Price for the " + this.app.getDoctor().getYearsOfExperience() + "-year experience: $" + this.getPriceForExperience(this.app.getDoctor().getYearsOfExperience()) + "\n" + 
                "Processing Fee for the " + this.method + " Payment Method: $" + this.method.getProcessingFee(this.getPriceForDuration(this.app.getDuration()) + this.getPriceForExperience(this.app.getDoctor().getYearsOfExperience()) + this.app.getPurpose().getBasePrice()) + "\n" + 
                "Total Bill Price: $" + this.getTotalBill();
    }
}
