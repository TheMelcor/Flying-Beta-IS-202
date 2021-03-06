package Server;


import DataModel.UserDataModel;
import DataModel.UsrRoleDataModel;
import java.util.List;
import javax.ejb.Remote;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melcor
 */
@Remote
public interface UserSessionBeanRemote {
    UserDataModel getUserFromId(int id);
    
    UserDataModel loginUser(String email, String password);
    
    List<UserDataModel> getAllUsers();
    
    void saveUser(UserDataModel user);
    
    List<UsrRoleDataModel> getAllUserRoles();
}
