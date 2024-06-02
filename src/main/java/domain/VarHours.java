/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author hp
 */
public abstract class VarHours {
    private DayOfWeek day;
    private LocalTime start;
    private LocalTime end;
    
    public VarHours(DayOfWeek day, LocalTime start, LocalTime end){
        this.day=day;
        this.end=end;
        this.start=start;
    }
    
    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
    
    public abstract int getTotalAvailableDuration();
}
