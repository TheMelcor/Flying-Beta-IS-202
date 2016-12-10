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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button nextCommentButton;
    @FXML
    private Button prevCommentButton;
    
    private int commentNumber;
    
    private ResponseHandler responseHandler = new ResponseHandler();
    
    private EvaluationHandler evaluationHandler = new EvaluationHandler();
    
    private DeliveryDataModel selectedDelivery;
    
    private List<ResponseDataModel> responseList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedDelivery = DeliveryHandler.getSelectedDelivery();
        this.commentNumber = 0;
        ModuleDataModel deliveryModule = selectedDelivery.getModuleNr();
        this.moduleNrLabel.setText(deliveryModule.getModuleNr() + " " + deliveryModule.getModuleName());
        this.contentText.setText(selectedDelivery.getContent());
       
        if (this.responseHandler.getResponsesByDelivery(selectedDelivery).size() > 0){
            responseList = this.responseHandler.getResponsesByDelivery(selectedDelivery);
            this.commentText.setText(responseList.get(this.commentNumber).getComment());
            this.writtenByLabel.setText(responseList.get(this.commentNumber).getAuthor().getFullName());
        }
        else {
            this.commentText.setText("No comments found.");
            this.writtenByLabel.setText("");
        }
        
        if (this.evaluationHandler.getEvaluationByDelivery(selectedDelivery) != null){
            this.gradeLabel.setText(evaluationHandler.getEvaluationByDelivery(selectedDelivery).getEvaluation());
        }
        else {
            this.gradeLabel.setText("Not Graded Yet.");
        }
        
        if (this.responseHandler.getResponsesByDelivery(selectedDelivery).size() > 1){
            this.nextCommentButton.setDisable(false);
            this.prevCommentButton.setDisable(true);
        }
        else {
            this.nextCommentButton.setDisable(true);
            this.prevCommentButton.setDisable(true);
        }
    }    
    
    @FXML
    private void onClickNextComment(ActionEvent e){
        this.commentNumber += 1;
        this.commentText.setText(responseList.get(this.commentNumber).getComment());
        this.writtenByLabel.setText(responseList.get(this.commentNumber).getAuthor().getFullName());
        
        this.prevCommentButton.setDisable(false);
        
        // add checks for if the list has next to enable/disable the button if you have time to do it.
        

    }
    
    @FXML
    private void onClickPrevComment(ActionEvent e){
        this.commentNumber -= 1;
        this.commentText.setText(responseList.get(this.commentNumber).getComment());
        this.writtenByLabel.setText(responseList.get(this.commentNumber).getAuthor().getFullName());
        
        this.nextCommentButton.setDisable(false);
        
    }

}
