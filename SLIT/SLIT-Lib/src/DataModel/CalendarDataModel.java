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
public class CalendarDataModel implements java.io.Serializable{
    private String calendarId;
    private String calendarTitle;
    private String calendarDesc;
    private String createdDate;
    private String endDate;
    private String content;
    private String owner;

    public CalendarDataModel(String calendarId, String calendarTitle, String calendarDesc, String createdDate, String endDate, String content, String owner) {
        this.calendarId = calendarId;
        this.calendarTitle = calendarTitle;
        this.calendarDesc = calendarDesc;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.content = content;
        this.owner = owner;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalendarTitle() {
        return calendarTitle;
    }

    public void setCalendarTitle(String calendarTitle) {
        this.calendarTitle = calendarTitle;
    }

    public String getCalendarDesc() {
        return calendarDesc;
    }

    public void setCalendarDesc(String calendarDesc) {
        this.calendarDesc = calendarDesc;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
}
