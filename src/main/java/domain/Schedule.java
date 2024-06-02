/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.DayOfWeek;
import java.util.*;

/**
 *
 * @author hp
 */
public class Schedule {
    
    private ArrayList<WorkingHours> workingHours;
    private ArrayList<OnCallHours> onCallHours;
    private ArrayList<DayOfWeek> daysOff;
    
    public Schedule(ArrayList<WorkingHours> workingHours, ArrayList<OnCallHours> onCallHours, ArrayList<DayOfWeek> daysOff) {
        this.workingHours = workingHours;
        this.onCallHours = onCallHours;
        this.daysOff = daysOff;
    }

    public List<DayOfWeek> getWorkingDays(){
        List<DayOfWeek> list = new ArrayList<>();
        for(VarHours h:this.workingHours){
            list.add(h.getDay());
        }
        return list;
    }
    
    public WorkingHours getWorkingDayForDay(DayOfWeek day){
        for(VarHours wh:this.workingHours){
            wh = (WorkingHours) wh;
            if(wh.getDay().equals(day)){
                return (WorkingHours) wh;
            }
        }
        return null;
    }
   
   
   public void addDayOff(DayOfWeek day){
      if(!this.daysOff.contains(day)){
           this.daysOff.add(day);
       }else{
           throw new IllegalArgumentException("Day Alreay a Resting Day");
       }
   }
   
   public void removeDayOff(DayOfWeek day){
       this.daysOff.remove(day);
   }
   
    public ArrayList<WorkingHours> getWorkingHours() {
        return workingHours;
    }


    public ArrayList<OnCallHours> getOnCallHours() {
        return onCallHours;
    }

    public ArrayList<DayOfWeek> getDaysOff() {
        return daysOff;
    }
}
