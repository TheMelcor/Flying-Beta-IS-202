/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModulePlanDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface ModulePlanSessionBeanRemote {
    boolean addModulePlan(ModulePlanDataModel modulePlan);
    
    ModulePlanDataModel getModulePlanById(String id);
    
    List<ModulePlanDataModel> getModulePlanByUser(String userId);
    
    List<ModulePlanDataModel> getAllModulePlans();
    
    List<ModulePlanDataModel> getModulePlanByModule(int moduleNr);
}
