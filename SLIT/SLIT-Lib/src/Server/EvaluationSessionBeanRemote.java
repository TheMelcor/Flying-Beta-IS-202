/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.EvaluationDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface EvaluationSessionBeanRemote {
    boolean addEvaluation(EvaluationDataModel evaluation);
    
    EvaluationDataModel getEvaluationById(String id);
    
    EvaluationDataModel getEvaluationFromDelivery(String delivery);
    
    List<EvaluationDataModel> getAllEvaluations();
    
    List<EvaluationDataModel> getAllEvaluationsByUser(String userId);
}
