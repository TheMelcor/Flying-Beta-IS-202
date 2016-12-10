/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.UserDataModel;
import Server.UserSessionBeanRemote;
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
public class UserHandler {
    
    private static UserDataModel loggedInUser;
    
    public static UserDataModel getLoggedInUser(){
        return UserHandler.loggedInUser;
    }

    private UserSessionBeanRemote lookupUserSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (UserSessionBeanRemote) c.lookup("java:comp/env/UserSessionBean");
            return (UserSessionBeanRemote) c.lookup("java:global/SLIT-ejb/UserSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public UserDataModel getUserById(int id){
        return this.lookupUserSessionBeanRemote().getUserFromId(id);
    }
    
    public UserDataModel loginUser(String email, String password){
        UserDataModel user = this.lookupUserSessionBeanRemote().loginUser(email, password);
        
        UserHandler.loggedInUser = user;
        return user;
    }
    
    public void logOutUser(){
        UserHandler.loggedInUser = null;
    }
    
    public List<UserDataModel> getAllUsers(){
        return this.lookupUserSessionBeanRemote().getAllUsers();
    }
    
    public void saveUser(UserDataModel user){
        this.lookupUserSessionBeanRemote().saveUser(user);
    }
}
