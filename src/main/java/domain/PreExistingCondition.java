/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author hp
 */
public enum PreExistingCondition {
    HYPERTENSION("Hypertension"),
    DIABETES("Diabetes Type2"),
    ASTHMA("Asthma"),
    COPD("Chronic Obstructive Pulmonary Disease"),
    CAD("Coronary Artery Disease"),
    RHEUMATOID("Rheumatoid Arthritis");
    
    private final String name;
    
    PreExistingCondition(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
