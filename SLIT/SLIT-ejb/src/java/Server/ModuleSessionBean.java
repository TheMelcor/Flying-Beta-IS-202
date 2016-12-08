/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverter;
import DataModel.ModuleDataModel;
import Database.Module;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Melcor
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote{

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public ModuleDataModel getModuleFromNr(int moduleNr){
        ModuleDataModel module = new ModuleDataModel();
        
        try{
           Module moduleResult = em.find(Module.class, moduleNr);
           
           module = DataModelConverter.convertModuleEntityToModel(moduleResult);
        }
        
        catch (Exception e){
            e.printStackTrace();
        }
        
        return module;
    }
    
    @Override
    public List<ModuleDataModel> getAllModules(){
        List<ModuleDataModel> allModules = new ArrayList<ModuleDataModel>();
        
        try{
            Query query = em.createNamedQuery("Module.findAll", Module.class);
            
            List<Module> moduleEntities = query.getResultList();
            
            for (Module module : moduleEntities){
                allModules.add(DataModelConverter.convertModuleEntityToModel(module));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return allModules;
    }
    
    @Override
    public void saveModule(ModuleDataModel module){
        try{
            Module moduleEntity = DataModelConverter.convertModuleModelToEntity(module);
            
            em.persist(moduleEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
