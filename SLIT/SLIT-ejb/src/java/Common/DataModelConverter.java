/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import DataModel.UserDataModel;
import DataModel.UsrRoleDataModel;
import Database.User;
import Database.Usrrole;

/**
 *
 * @author Melcor
 */
public class DataModelConverter {
    
    
    public static UserDataModel convertUserEntityToModel(User user){
        UserDataModel userDataModel = new UserDataModel();
        
        userDataModel.setUserId(user.getUserId());
        userDataModel.setEmail(user.getEmail());
        userDataModel.setFirstName(user.getFirstName());
        userDataModel.setLastName(user.getLastName());
        userDataModel.setPassword(user.getPasswrd());
        userDataModel.setUserRole(convertUsrRoleEntityToModel(user.getUsrRole()));
        
        return userDataModel;
    }
    
    public static UsrRoleDataModel convertUsrRoleEntityToModel(Usrrole usrRole){
        UsrRoleDataModel usrRoleModel = new UsrRoleDataModel();
        
        usrRoleModel.setRoleId(usrRole.getRoleId());
        usrRoleModel.setRoleName(usrRole.getRoleName());
        
        return usrRoleModel;
    }
    
    public static Usrrole convertUsrRoleModelToEntity(UsrRoleDataModel usrRole){
        Usrrole usrRoleEntity = new Usrrole();
        
        usrRoleEntity.setRoleId(usrRole.getRoleId());
        usrRoleEntity.setRoleName(usrRole.getRoleName());
        
        return usrRoleEntity;
    }
    
    public static User convertUserModelToEntity(UserDataModel userDataModel){
        User user = new User();
        
        user.setUserId(userDataModel.getUserId());
        
        user.setEmail(userDataModel.getEmail());
        user.setFirstName(userDataModel.getFirstName());
        user.setLastName(userDataModel.getLastName());
        user.setPasswrd(userDataModel.getPassword());
        user.setUsrRole(convertUsrRoleModelToEntity(userDataModel.getUserRole()));
        
        return user;
    }
    
    
}
