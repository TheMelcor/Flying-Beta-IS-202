/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.DeliveryDataModel;
import DataModel.ModuleDataModel;
import DataModel.ResponseDataModel;
import Framework.DeliveryHandler;
import Framework.EvaluationHandler;
import Framework.ResponseHandler;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class StudentHandinViewController implements Initializable {

    @FXML
    private Text commentText;
    @FXML
    private Text contentText;
    @FXML
    private Label writtenByLabel;
    @FXML
    private Label gradeLabel;
    @FXML
    private Label moduleNrLabel;
    
    private ResponseHandler responseHandler = new ResponseHandler();
    
    private EvaluationHandler evaluationHandler = new EvaluationHandler();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DeliveryDataModel selectedDelivery = DeliveryHandler.getSelectedDelivery();
        
        ModuleDataModel deliveryModule = selectedDelivery.getModuleNr();
        this.moduleNrLabel.setText(deliveryModule.getModuleNr() + " " + deliveryModule.getModuleName());
        this.contentText.setText(selectedDelivery.getContent());
       
        if (this.responseHandler.getResponsesByDelivery(selectedDelivery).size() > 0){
            List<ResponseDataModel> responseList = this.responseHandler.getResponsesByDelivery(selectedDelivery);
            this.commentText.setText(responseList.get(0).getComment());
            this.writtenByLabel.setText(responseList.get(0).getAuthor().getFullName());
        }
        else {
            this.commentText.setText("No comment");
            this.writtenByLabel.setText("");
        }
        if (this.evaluationHandler.getEvaluationByDelivery(selectedDelivery) != null){
            this.gradeLabel.setText(evaluationHandler.getEvaluationByDelivery(selectedDelivery).getEvaluation());
        }
        else {
            this.gradeLabel.setText("Not Graded Yet.");
        }
        
        
    }    
    
}
