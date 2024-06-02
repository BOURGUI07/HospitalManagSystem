/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

import java.time.Duration;

/**
 *
 * @author hp
 */
public enum VisitPurpose {
    ROUTINE("Routine Checkup") {@Override
    public double getBasePrice(){
        return 100;
    }} ,
    FOLLOWUP("Follow-up Visit") {
        @Override
        public double getBasePrice(){
            return 100;
        }
    } ,
    SYMPTOMS("Consultation for Symptoms") {
        @Override
        public double getBasePrice(){
            return 100;
        }
    } ,
    SPECIALIST("Specialist Consultation") {
        @Override
        public double getBasePrice(){
            return 150;
        }
    },
    DIAGNOSTIC("Diagnostic Testing") {
        @Override
        public double getBasePrice(){
            return 200;
        }
    },
    MINOR("Minor Surgery") {
        @Override
        public double getBasePrice(){
            return 2000;
        }
    },
    MAJOR("Major Surgery") {
        @Override
        public double getBasePrice(){
            return 10000;
        }
    };

    
    private final String name;
    public abstract double getBasePrice();
    
    VisitPurpose(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
