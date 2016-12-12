/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.UserDataModel;
import DataModel.UsrRoleDataModel;
import Server.UserSessionBeanRemote;
import java.util.ArrayList;
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
    private static UserDataModel selectedUser;
    
    public static UserDataModel getLoggedInUser(){
        return UserHandler.loggedInUser;
    }
    
    public static UserDataModel getSelectedUser(){
        return UserHandler.selectedUser;
    }
    
    public static void setSelectedUser(UserDataModel user){
        UserHandler.selectedUser = user;
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
    
    public static void logOutUser(){
        UserHandler.loggedInUser = null;
    }
    
    public List<UserDataModel> getAllUsers(){
        return this.lookupUserSessionBeanRemote().getAllUsers();
    }
    
    public List<UserDataModel> getAllStudents(){
        List<UserDataModel> students = new ArrayList<UserDataModel>();
        for(UserDataModel user : this.getAllUsers()){
            if (user.getUserRole().getRoleName().equals("Student")){
                students.add(user);
            }
        }
        return students;
    }
    
    public void saveUser(UserDataModel user){
        this.lookupUserSessionBeanRemote().saveUser(user);
    }
    
    public List<UsrRoleDataModel> getAllUserRoles(){
        return this.lookupUserSessionBeanRemote().getAllUserRoles();
    }
    
    public UsrRoleDataModel getUserRoleByName(String name){
        UsrRoleDataModel usrRole = new UsrRoleDataModel();
        
        for (UsrRoleDataModel role : getAllUserRoles()){
            if (role.getRoleName().equals(name)){
                usrRole = role;
            }
        }
        return usrRole;
    }
}
