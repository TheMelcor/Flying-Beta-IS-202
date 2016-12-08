/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverter;
import DataModel.ResponseDataModel;
import Database.Response;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Melcor
 */
@Stateless
public class ResponseSessionBean implements ResponseSessionBeanRemote{

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public ResponseDataModel getResponseById(int id){
        ResponseDataModel response = new ResponseDataModel();
        
        try{
            Response responseResult = em.find(Response.class, id);
            
            response = DataModelConverter.convertResponseEntityToModel(responseResult);
        }
        
        catch (Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
}
