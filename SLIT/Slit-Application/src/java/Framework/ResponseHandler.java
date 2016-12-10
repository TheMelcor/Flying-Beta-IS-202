/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.DeliveryDataModel;
import DataModel.ResponseDataModel;
import Server.ResponseSessionBeanRemote;
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
public class ResponseHandler {
    private ResponseSessionBeanRemote lookupResponseSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (ResponseSessionBeanRemote) c.lookup("java:comp/env/ResponseSessionBean");
            return (ResponseSessionBeanRemote) c.lookup("java:global/SLIT-ejb/ResponseSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public ResponseDataModel getResponseById(int id){
        return this.lookupResponseSessionBeanRemote().getResponseById(id);
    }
    
    public List<ResponseDataModel> getAllResponses(){
        return this.lookupResponseSessionBeanRemote().getAllResponses();
    }
    
    public List<ResponseDataModel> getResponsesByDelivery(DeliveryDataModel delivery){
        return this.lookupResponseSessionBeanRemote().getResponsesByDelivery(delivery);
    }
}
