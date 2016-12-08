/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import DataModel.DeliveryDataModel;
import DataModel.ModuleDataModel;
import DataModel.ResponseDataModel;
import DataModel.UserDataModel;
import DataModel.UsrRoleDataModel;
import Database.Handin;
import Database.Module;
import Database.Response;
import Database.User;
import Database.Usrrole;
import java.sql.Timestamp;

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
    
    public static ModuleDataModel convertModuleEntityToModel(Module module){
        ModuleDataModel moduleModel = new ModuleDataModel();
        
        moduleModel.setModuleNr(module.getModuleNr());
        moduleModel.setModuleName(module.getModuleName());
        moduleModel.setModuleDesc(module.getModuleDesc());
        moduleModel.setModuleGoal(module.getModuleGoal());
        moduleModel.setHandinDate(String.valueOf(module.getHandinDate()));
        
        return moduleModel;
    }
    
    public static Module convertModuleModelToEntity(ModuleDataModel moduleModel){
        Module module = new Module();
        
        module.setModuleNr(moduleModel.getModuleNr());
        module.setModuleName(moduleModel.getModuleName());
        module.setModuleDesc(moduleModel.getModuleDesc());
        module.setModuleGoal(moduleModel.getModuleGoal());
        module.setHandinDate(Timestamp.valueOf(moduleModel.getHandinDate()));
        
        return module;
    }
    
    public static DeliveryDataModel convertDeliveryEntityToModel(Handin delivery){
        DeliveryDataModel deliveryModel = new DeliveryDataModel();
        
        deliveryModel.setId(delivery.getId());
        deliveryModel.setModuleNr(convertModuleEntityToModel(delivery.getModuleNr()));
        deliveryModel.setDeliveredBy(convertUserEntityToModel(delivery.getDeliveredBy()));
        deliveryModel.setDeliveryDate(String.valueOf(delivery.getDeliveryDate()));
        deliveryModel.setContent(delivery.getContent());
        
        return deliveryModel;
    }
    
    public static Handin convertDeliveryModelToEntity(DeliveryDataModel deliveryModel){
        Handin delivery = new Handin();
        
        delivery.setId(deliveryModel.getId());
        delivery.setModuleNr(convertModuleModelToEntity(deliveryModel.getModuleNr()));
        delivery.setDeliveredBy(convertUserModelToEntity(deliveryModel.getDeliveredBy()));
        delivery.setDeliveryDate(Timestamp.valueOf(deliveryModel.getDeliveryDate()));
        delivery.setContent(deliveryModel.getContent());
        
        return delivery;
    }
    
    public static ResponseDataModel convertResponseEntityToModel(Response response){
        ResponseDataModel responseModel = new ResponseDataModel();
        
        responseModel.setResponseId(response.getRespId());
        responseModel.setAuthor(convertUserEntityToModel(response.getWrittenBy()));
        responseModel.setDeliveryId(convertDeliveryEntityToModel(response.getHandin()));
        responseModel.setComment(response.getRespComment());
        responseModel.setDate(String.valueOf(response.getRespDate()));
        
        return responseModel;
    }
    
   
}
