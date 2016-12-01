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
    private String evaluationId;
    private String date;
    private String evaluation;
    private String evaluatedBy;
    private String handin;

    public EvaluationDataModel(String evaluationId, String date, String evaluation, String evaluatedBy, String handin) {
        this.evaluationId = evaluationId;
        this.date = date;
        this.evaluation = evaluation;
        this.evaluatedBy = evaluatedBy;
        this.handin = handin;
    }
    
    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
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

    public String getEvaluatedBy() {
        return evaluatedBy;
    }

    public void setEvaluatedBy(String evaluatedBy) {
        this.evaluatedBy = evaluatedBy;
    }

    public String getHandin() {
        return handin;
    }

    public void setHandin(String handin) {
        this.handin = handin;
    }
    
    
}
