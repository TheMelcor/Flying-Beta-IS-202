/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverter;
import DataModel.DeliveryDataModel;
import Database.Handin;
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
public class DeliverySessionBean implements DeliverySessionBeanRemote {

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public DeliveryDataModel getDeliveryFromId(String id){
        DeliveryDataModel delivery = new DeliveryDataModel();
        
        try{
            Handin deliveryResult = em.find(Handin.class, id);
            
            delivery = DataModelConverter.convertDeliveryEntityToModel(deliveryResult);
        }
         
        catch (Exception e){
            e.printStackTrace();
        }
        
        return delivery;
    }
    
    @Override
    public List<DeliveryDataModel> getAllDeliveries(){
        List<DeliveryDataModel> allDeliveries = new ArrayList<DeliveryDataModel>();
        
        try{
            Query query = em.createNamedQuery("Handin.findAll", Handin.class);
            
            List<Handin> delivery = query.getResultList();
            
            for (Handin handin : delivery){
                allDeliveries.add(DataModelConverter.convertDeliveryEntityToModel(handin));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return allDeliveries;
    }
}
