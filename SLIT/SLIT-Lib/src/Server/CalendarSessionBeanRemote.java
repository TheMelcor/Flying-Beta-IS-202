/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.CalendarDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface CalendarSessionBeanRemote {
    boolean addCalendar(CalendarDataModel calendar);
    
    CalendarDataModel getCalendarById(String id);
    
    List<CalendarDataModel> getAllCalendars();
    
    List<CalendarDataModel> getCalendarsByUser(String userId);
}
