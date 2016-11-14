/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModuleDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface ModuleSessionBeanRemote {
    
    ModuleDataModel getModuleById(int id);
    
    List<ModuleDataModel> getModules();
    
    List<String> getModuleNames();
    
    String getModuleNameFromId(int id);
    
    ModuleDataModel getModuleByName(String moduleName);
    
    boolean storeModule(ModuleDataModel module);
}
