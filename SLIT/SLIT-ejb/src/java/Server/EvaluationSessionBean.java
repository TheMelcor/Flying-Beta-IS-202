/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverter;
import DataModel.DeliveryDataModel;
import DataModel.EvaluationDataModel;
import DataModel.UserDataModel;
import Database.Evaluation;
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
public class EvaluationSessionBean implements EvaluationSessionBeanRemote{

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public EvaluationDataModel getEvaluationById(int id){
        EvaluationDataModel evaluation = new EvaluationDataModel();
        
        try{
            Evaluation evaluationResult = em.find(Evaluation.class, id);
            
            evaluation = DataModelConverter.convertEvaluationEntityToModel(evaluationResult);
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        return evaluation;
    }
    
    @Override
    public List<EvaluationDataModel> getAllEvaluations(){
        List<EvaluationDataModel> evaluations = new ArrayList<EvaluationDataModel>();
        
        try{
            Query query = em.createNamedQuery("Evaluation.findAll", Evaluation.class);
            
            List<Evaluation> evaluationList = query.getResultList();
            
            for (Evaluation evaluation : evaluationList){
                evaluations.add(DataModelConverter.convertEvaluationEntityToModel(evaluation));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return evaluations;
    }

    @Override
    public List<EvaluationDataModel> getEvaluationsByUser(UserDataModel user){
        List<EvaluationDataModel> evaluations = new ArrayList<EvaluationDataModel>();
        
        List<EvaluationDataModel> allEvaluations = getAllEvaluations();
        
        for (EvaluationDataModel evaluation : allEvaluations){
            if (evaluation.getHandin().getDeliveredBy().equals(user)){
                evaluations.add(evaluation);
            }
        }
        
        return evaluations;
    }
    
    @Override
    public EvaluationDataModel getEvaluationByDelivery(DeliveryDataModel delivery){
        List<EvaluationDataModel> allEvaluations = getAllEvaluations();
        
        for (EvaluationDataModel evaluation : allEvaluations){
            if (evaluation.getHandin().equals(delivery)){
                return evaluation;
            }
        }
        return null;
        
    }
    
    @Override
    public void saveEvaluation(EvaluationDataModel evaluation){
        try{
            Evaluation evaluationEntity = DataModelConverter.convertEvaluationModelToEntity(evaluation);
            
            em.persist(evaluationEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
