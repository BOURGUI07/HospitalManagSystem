/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum BillStatus {
    PENDING("Pending"), AUTHORIZED("Authorized"), PAID("Paid");
    
    private final String name;
    
    BillStatus(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
