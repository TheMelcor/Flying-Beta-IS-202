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
    
    
    public ModuleDataModel getModuleFromNr(int moduleNr);
    
    public List<ModuleDataModel> getAllModules();
    
    public void saveModule(ModuleDataModel module);

}
