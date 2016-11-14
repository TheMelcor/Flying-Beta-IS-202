/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ResourceDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface ResourceSessionBeanRemote {
    boolean addResource(ResourceDataModel resource);
    
    ResourceDataModel getResourceById(String id);
    
    List<ResourceDataModel> getResourceByModuleNr(int moduleNr);
    
    List<ResourceDataModel> getAllResources();
}
