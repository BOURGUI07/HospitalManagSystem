/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;

/**
 *
 * @author hp
 */
public class Surgery {
    private String type;
    private LocalDate date;
    private String hospital;
    private String surgeon;
    
    public Surgery(String type, LocalDate date, String hospital, String surgeon){
        this.date=date;
        this.hospital=hospital;
        this.surgeon=surgeon;
        this.type=type;
    }
}
