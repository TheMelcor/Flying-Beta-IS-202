/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.DeliveryDataModel;
import DataModel.EvaluationDataModel;
import DataModel.UserDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface EvaluationSessionBeanRemote {
    EvaluationDataModel getEvaluationById(int id);
    List<EvaluationDataModel> getAllEvaluations();
    List<EvaluationDataModel> getEvaluationsByUser(UserDataModel user);
    EvaluationDataModel getEvaluationByDelivery(DeliveryDataModel delivery);
    void saveEvaluation(EvaluationDataModel evaluation);
}
