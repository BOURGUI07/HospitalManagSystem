/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum Treatment {
   INSULIN("Insulin Therapy"),
   METROFORMIN("MetroFormin"),
   ACE("ACE Inhibitors"),
   INHALER("Albuterol inhaler");
   
   private final String name;
   Treatment(String name){
       this.name=name;
   }
   
   @Override
   public String toString(){
       return this.name;
   }
}
