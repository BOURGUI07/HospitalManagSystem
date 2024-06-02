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
public class MedicalVisit {
    private VisitPurpose purpose;
    private LocalDate date;
    
    public MedicalVisit(VisitPurpose reason, LocalDate date){
        this.date=date;
        this.purpose=reason;
    }
}
