/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import DataModel.DeliveryDataModel;
import DataModel.UserDataModel;
import DataModel.UsrRoleDataModel;
import Framework.DeliveryHandler;
import Framework.ModuleHandler;
import Framework.UserHandler;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Melcor
 */
public class Main {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserHandler handler = new UserHandler();
        DeliveryHandler deliveryHandler = new DeliveryHandler();
        ModuleHandler moduleHandler = new ModuleHandler();
        
        UserDataModel model = handler.getUserById(1);
        
        System.out.println(model.getFullName());
        
        UserDataModel testUser = new UserDataModel();
        
        testUser.setEmail("email@4558email.email");
        testUser.setFirstName("Lasse");
        testUser.setLastName("Norman");
        testUser.setPassword("password");
        testUser.setUserRole(new UsrRoleDataModel(2,"Student"));
        
        handler.saveUser(testUser);
        
        List<UserDataModel> users = handler.getAllUsers();
        
        DeliveryDataModel testDelivery = new DeliveryDataModel();
        
        testDelivery.setDeliveredBy(handler.getUserById(3));
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        testDelivery.setDeliveryDate(strDate);
        testDelivery.setDeliveryStatus("Under Evaluation");
        testDelivery.setContent("some content");
        testDelivery.setModuleNr(moduleHandler.getModuleFromNr(1));
        
        deliveryHandler.saveDelivery(testDelivery);
        
        List<DeliveryDataModel> deliveries = deliveryHandler.getAllDeliveries();
        
        if (users.size() > 0){
            for (UserDataModel user : users){
                System.out.println(user.getFullName());
            }
        }
        if (deliveries.size() > 0){
            for (DeliveryDataModel delivery : deliveries){
                System.out.println(delivery.getContent());
            }
        }
    }
    
    
    
}
