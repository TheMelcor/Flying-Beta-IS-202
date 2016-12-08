/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.DeliveryDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface DeliverySessionBeanRemote {
    
    public DeliveryDataModel getDeliveryFromId(String id);
    public List<DeliveryDataModel> getAllDeliveries();
      
}
