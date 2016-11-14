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
public class ModulePlanDataModel {
    private String modulePlanId;
    private String handinDate;
    private int moduleNr;
    private String calendarId;

    public ModulePlanDataModel(String modulePlanId, String handinDate, int moduleNr, String calendarId) {
        this.modulePlanId = modulePlanId;
        this.handinDate = handinDate;
        this.moduleNr = moduleNr;
        this.calendarId = calendarId;
    }

    public String getModulePlanId() {
        return modulePlanId;
    }

    public void setModulePlanId(String modulePlanId) {
        this.modulePlanId = modulePlanId;
    }

    public String getHandinDate() {
        return handinDate;
    }

    public void setHandinDate(String handinDate) {
        this.handinDate = handinDate;
    }

    public int getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(int moduleNr) {
        this.moduleNr = moduleNr;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }
    
    
}
