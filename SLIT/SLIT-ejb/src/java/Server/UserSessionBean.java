/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverter;
import DataModel.UserDataModel;
import Database.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Melcor
 */
@Stateless
public class UserSessionBean implements UserSessionBeanRemote{

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public UserDataModel getUserFromId(int id){
        UserDataModel user = new UserDataModel();
        
        try{
            User userResult = em.find(User.class, id);
            
            user = DataModelConverter.convertUserEntityToModel(userResult);
        }
        
        catch (Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
    @Override
    public UserDataModel loginUser(String email, String password){
        UserDataModel user = new UserDataModel();
        
        try{
            Query query = em.createNamedQuery("User.findByEmail", User.class);
            
            query.setParameter("email", email);
            
            User userEntity = (User)query.getSingleResult();
            
            if (password.equals(userEntity.getPasswrd())){
                user = DataModelConverter.convertUserEntityToModel(userEntity);
            }
            
        }
        catch (javax.persistence.NoResultException e){
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
    @Override
    public List<UserDataModel> getAllUsers(){
        List<UserDataModel> users = new ArrayList<UserDataModel>();
        
        try{
            Query query = em.createNamedQuery("User.findAll", User.class);
            
            List<User> userEntities = query.getResultList();
            
            for (User user : userEntities){
                users.add(DataModelConverter.convertUserEntityToModel(user));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return users;
    }
    
    @Override
    public void saveUser(UserDataModel user){
        try{
            User userEntity = DataModelConverter.convertUserModelToEntity(user);
            
            em.persist(userEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    

}
