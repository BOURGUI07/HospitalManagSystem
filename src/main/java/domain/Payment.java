/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum Payment {
    CARD("Debit/ Credit Card"){
        @Override
        public double getProcessingFee(double price){
            return 0.025*price;
        }
    },
    BANK("Bank Transfer"){
        @Override
        public double getProcessingFee(double price){
            return 2.0;
        }
    },
    DIGITALWALLET("Digital Wallet"){
        @Override
        public double getProcessingFee(double price){
            return 0.03*price;
        }
    },
    CASH("Cash"){
        @Override
        public double getProcessingFee(double price){
            return 0.0;
        }
    };
    
    private final String name;
    public abstract double getProcessingFee(double price);
    
    Payment(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
