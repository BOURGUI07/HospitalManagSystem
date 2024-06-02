/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author hp
 */
public class OnCallHours extends VarHours {
    public OnCallHours(DayOfWeek day, LocalTime start, LocalTime end){
        super(day, start,end);
    }
    
    @Override
    public int getTotalAvailableDuration(){
        return (int) super.getStart().until(super.getEnd(), ChronoUnit.HOURS);
    }
}
