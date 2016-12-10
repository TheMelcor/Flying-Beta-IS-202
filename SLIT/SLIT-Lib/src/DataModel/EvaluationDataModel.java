/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Melcor
 */
public class EvaluationDataModel implements java.io.Serializable{
    private int evaluationId;
    private String date;
    private String evaluation;
    private UserDataModel evaluatedBy;
    private DeliveryDataModel handin;
    
    public EvaluationDataModel(){
        
    }

    public EvaluationDataModel(int evaluationId, String date, String evaluation, UserDataModel evaluatedBy, DeliveryDataModel handin) {
        this.evaluationId = evaluationId;
        this.date = date;
        this.evaluation = evaluation;
        this.evaluatedBy = evaluatedBy;
        this.handin = handin;
    }
    
    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public UserDataModel getEvaluatedBy() {
        return evaluatedBy;
    }

    public void setEvaluatedBy(UserDataModel evaluatedBy) {
        this.evaluatedBy = evaluatedBy;
    }

    public DeliveryDataModel getHandin() {
        return handin;
    }

    public void setHandin(DeliveryDataModel handin) {
        this.handin = handin;
    }
    
    
}
