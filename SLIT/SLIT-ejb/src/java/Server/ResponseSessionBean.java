/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverter;
import DataModel.DeliveryDataModel;
import DataModel.ResponseDataModel;
import Database.Response;
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
    
    @Override
    public List<ResponseDataModel> getAllResponses(){
        List<ResponseDataModel> responses = new ArrayList<ResponseDataModel>();
        
        try{
            Query query = em.createNamedQuery("Response.findAll", Response.class);
            
            List<Response> responseList = query.getResultList();
            
            for (Response response : responseList){
                responses.add(DataModelConverter.convertResponseEntityToModel(response));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return responses;
    }
    
    @Override
    public List<ResponseDataModel> getResponsesByDelivery(DeliveryDataModel delivery){
        List<ResponseDataModel> responses = new ArrayList<ResponseDataModel>();
        
        List<ResponseDataModel> allResponses = getAllResponses();
        
        for (ResponseDataModel response : allResponses){
            if (response.getDeliveryId().equals(delivery)){
                responses.add(response);
            }
        }
        return responses;
    }
    
    @Override
    public void saveResponse(ResponseDataModel response){
        try{
            Response responseEntity = DataModelConverter.convertResponseModelToEntity(response);
            
            em.persist(responseEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
