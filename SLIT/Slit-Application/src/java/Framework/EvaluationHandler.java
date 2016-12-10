/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.DeliveryDataModel;
import DataModel.EvaluationDataModel;
import DataModel.UserDataModel;
import Server.EvaluationSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Melcor
 */
public class EvaluationHandler {
    private EvaluationSessionBeanRemote lookupEvaluationSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (EvaluationSessionBeanRemote) c.lookup("java:comp/env/EvaluationSessionBean");
            return (EvaluationSessionBeanRemote) c.lookup("java:global/SLIT-ejb/EvaluationSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public EvaluationDataModel getEvaluationById(int id){
        return this.lookupEvaluationSessionBeanRemote().getEvaluationById(id);
    }
    
    public EvaluationDataModel getEvaluationByDelivery(DeliveryDataModel delivery){
        return this.lookupEvaluationSessionBeanRemote().getEvaluationByDelivery(delivery);
    }
    
    public List<EvaluationDataModel> getEvaluationsByUser(UserDataModel user){
        return this.lookupEvaluationSessionBeanRemote().getEvaluationsByUser(user);
    }
    
    public void saveEvaluation(EvaluationDataModel evaluation){
        this.lookupEvaluationSessionBeanRemote().saveEvaluation(evaluation);
    }
}
