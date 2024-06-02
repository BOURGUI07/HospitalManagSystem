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
public class WorkingHours extends VarHours {
    private LocalTime breakStart;
    private LocalTime breakEnd;
    
    public WorkingHours(DayOfWeek day, LocalTime start, LocalTime end, LocalTime breakstart, LocalTime breakEnd){
        super(day, start,end);
        this.breakStart=breakstart;
        this.breakEnd=breakEnd;
    }
    
    
    @Override
    public int getTotalAvailableDuration(){
        int a = (int) super.getStart().until(super.getEnd(), ChronoUnit.MINUTES);
        return  a - this.getTotalBreakTime();
    }
    
    public int getTotalBreakTime(){
        return (int) this.breakStart.until(breakEnd, ChronoUnit.HOURS);
    }
    
    public LocalTime getBreakStart(){
        return this.breakStart;
    }
    
    public LocalTime getBreakEnd(){
        return this.breakEnd;
    }
    
    public boolean isTimeSuitable(LocalTime time){
        return (time.isAfter(super.getStart()) && time.isBefore(this.breakStart)) || (time.isAfter(this.breakEnd) && time.isBefore(super.getEnd()));
    }
}
