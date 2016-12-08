/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import DataModel.UserDataModel;
import DataModel.UsrRoleDataModel;
import Framework.UserHandler;
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
        
        UserDataModel model = handler.getUserById(1);
        
        System.out.println(model.getFullName());
        
        UserDataModel testUser = new UserDataModel();
        
        testUser.setEmail("email@2email.email");
        testUser.setFirstName("Ola");
        testUser.setLastName("Norman");
        testUser.setPassword("password");
        testUser.setUserRole(new UsrRoleDataModel(2,"Student"));
        
        handler.saveUser(testUser);
        
        List<UserDataModel> users = handler.getAllUsers();
        
        if (users.size() > 0){
            for (UserDataModel user : users){
                System.out.println(user.getFullName());
            }
        }
    }
    
    
    
}
