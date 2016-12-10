/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.DeliveryDataModel;
import DataModel.ModuleDataModel;
import DataModel.UserDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface DeliverySessionBeanRemote {
    
    DeliveryDataModel getDeliveryFromId(int id);
    List<DeliveryDataModel> getAllDeliveries();
    List<DeliveryDataModel> getDeliveriesByUser(UserDataModel user);
    List<DeliveryDataModel> getDeliveriesByModule(ModuleDataModel module);
    void saveDelivery(DeliveryDataModel delivery);
      
}
