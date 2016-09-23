/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.gui;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;



/**
 *
 * @author Melcor
 */
public class CModules {
    public SimpleIntegerProperty moduleNr;
    public SimpleStringProperty title;
    public SimpleStringProperty desc;
    public SimpleStringProperty goals;
    
    public CModules(int moduleNr, String title, String desc, String goals){
        this.moduleNr =  new SimpleIntegerProperty(moduleNr);
        this.title = new SimpleStringProperty(title);
        this.desc = new SimpleStringProperty(desc);
        this.goals = new SimpleStringProperty(goals);
    }
    
    public void setModNr(int moduleNr){
        this.moduleNr.set(moduleNr);
    }
    
    public void setTitle(String title){
        this.title.set(title);
    }
    
    public void setDesc(String desc){
        this.desc.set(desc);
    }
    
    public void setGoals(String goals){
        this.goals.set(goals);
    }
    
    public int getModNr(){
        return moduleNr.get();
    }
    
    public String getTitle(){
        return title.get();
    }
    
    public String getDesc(){
        return desc.get();
    }
    
    public String getGoals(){
        return goals.get();
    }
    
}
