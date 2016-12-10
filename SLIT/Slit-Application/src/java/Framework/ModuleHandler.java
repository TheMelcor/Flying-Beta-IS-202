/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.ModuleDataModel;
import Server.ModuleSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Melcor
 */
public class ModuleHandler {
    
    private static ModuleDataModel selectedModule;
    
    public static ModuleDataModel getSelectedModule(){
        return ModuleHandler.selectedModule;
    }
    
    public static void setSelectedModule(ModuleDataModel module){
        ModuleHandler.selectedModule = module;
    }
    
    public static void clearSelectedModule(){
        ModuleHandler.selectedModule = null;
    }

    private ModuleSessionBeanRemote lookupModuleSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (ModuleSessionBeanRemote) c.lookup("java:comp/env/ModuleSessionBean");
            return (ModuleSessionBeanRemote) c.lookup("java:global/SLIT-ejb/ModuleSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public ModuleDataModel getModuleFromNr(int moduleNr){
        return this.lookupModuleSessionBeanRemote().getModuleFromNr(moduleNr);
    }
    
    public List<ModuleDataModel> getAllModules(){
        return this.lookupModuleSessionBeanRemote().getAllModules();
    }
    
    public void saveModule(ModuleDataModel module){
        this.lookupModuleSessionBeanRemote().saveModule(module);
    }
    
}
