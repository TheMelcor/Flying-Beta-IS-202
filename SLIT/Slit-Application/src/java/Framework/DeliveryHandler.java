/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.DeliveryDataModel;
import DataModel.ModuleDataModel;
import DataModel.UserDataModel;
import Server.DeliverySessionBeanRemote;
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
public class DeliveryHandler {
    
    private static DeliveryDataModel selectedDelivery;
    
    public static DeliveryDataModel getSelectedDelivery(){
        return DeliveryHandler.selectedDelivery;
    }
    
    public static void setSelectedDelivery(DeliveryDataModel delivery){
        DeliveryHandler.selectedDelivery = delivery;
    }
    
    public static void clearSelectedDelivery(){
        DeliveryHandler.selectedDelivery = null;
    }
    
    private DeliverySessionBeanRemote lookupDeliverySessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (DeliverySessionBeanRemote) c.lookup("java:comp/env/DeliverySessionBean");
            return (DeliverySessionBeanRemote) c.lookup("java:global/SLIT-ejb/DeliverySessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public DeliveryDataModel getDeliveryFromId(int id){
        return this.lookupDeliverySessionBeanRemote().getDeliveryFromId(id);
    }
    
    public List<DeliveryDataModel> getAllDeliveries(){
        return this.lookupDeliverySessionBeanRemote().getAllDeliveries();
    }
    
    public List<DeliveryDataModel> getDeliveriesByUser(UserDataModel user){
        return this.lookupDeliverySessionBeanRemote().getDeliveriesByUser(user);
    }
    
    public List<DeliveryDataModel> getDeliveriesByModule(ModuleDataModel module){
        return this.lookupDeliverySessionBeanRemote().getDeliveriesByModule(module);
    }
    
    public void saveDelivery(DeliveryDataModel delivery){
        this.lookupDeliverySessionBeanRemote().saveDelivery(delivery);
    }
    
    public void updateDeliveryStatus(DeliveryDataModel delivery){
        this.lookupDeliverySessionBeanRemote().updateDeliveryStatus(delivery);
    }
}
