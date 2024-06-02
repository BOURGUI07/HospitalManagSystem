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
public class Hospitalization {
    private String reason;
    private LocalDate date;
    private String hospital;
    
    public Hospitalization(String reason, LocalDate date, String hospital){
        this.date=date;
        this.hospital=hospital;
        this.reason=reason;
    }
}
