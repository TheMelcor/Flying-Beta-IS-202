/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;


/**
 *
 * @author Melcor
 */
public class ModuleDataModel implements java.io.Serializable{
    private int moduleNr;
    private String moduleName;
    private String moduleDesc;
    private String moduleGoal;
    private String handinDate;
    
    public ModuleDataModel(int moduleNr, String name, String desc, String goal, String date){
        this.moduleNr = moduleNr;
        this.moduleName = name;
        this.moduleDesc = desc;
        this.moduleGoal = goal;
        this.handinDate = date;
    }
    
    public int getModuleNr(){
        return moduleNr;
    }

    public void setModuleNr(int moduleNr){
        this.moduleNr = moduleNr;
    }
    
    public String getModuleName(){
        return moduleName;
    }
    
    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }
    
    public String getModuleDesc(){
        return moduleDesc;
    }
    
    public void setModuleDesc(String moduleDesc){
        this.moduleDesc = moduleDesc;
    }
    
    public String getModuleGoal(){
        return moduleGoal;
    }
    
    public void setModuleGoal(String moduleGoal){
        this.moduleGoal = moduleGoal;
    }
    
    public String getHandinDate(){
        return handinDate;
    }
    
    public void setHandinDate(String handinDate){
        this.handinDate = handinDate;
    }
    
}
