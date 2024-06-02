/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum AllergySubstance {
   MEDICATION("Medications") ,
   ENVIRONMENTAL("Environmental"),
   FOODS("Foods"),
   INSECT("Insect Stings"),
   LATEX("Latex");
   
   private final String name;
   
   AllergySubstance(String name){
       this.name=name;
   }
   
   @Override
   public String toString(){
       return this.name;
   }
}
