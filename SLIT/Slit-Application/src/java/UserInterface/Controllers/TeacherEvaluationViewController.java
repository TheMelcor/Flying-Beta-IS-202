/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.DeliveryDataModel;
import DataModel.EvaluationDataModel;
import DataModel.ResponseDataModel;
import Framework.DeliveryHandler;
import Framework.EvaluationHandler;
import Framework.ResponseHandler;
import Framework.UserHandler;
import UserInterface.MainUserInterface;
import UserInterface.Names.ViewNames;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class TeacherEvaluationViewController implements Initializable {

    // ---- Top Menu Items ----
    @FXML
    private Button deliveriesButton;
    @FXML
    private Button studentButton;
    @FXML
    private Button moduleButton;
    @FXML
    private Button createModuleButton;
    @FXML
    private Button logOutButton;
    // ---- Ent Top Menu ----
    
    @FXML
    private TextArea evaluationCommentText;
    @FXML
    private ComboBox<String> gradeComboBox;
    @FXML
    private Label moduleNameLabel;
    @FXML
    private Label studentNameLabel;
    
    private DeliveryHandler deliveryHandler = new DeliveryHandler();
    
    private EvaluationHandler evaluationHandler = new EvaluationHandler();
    
    private ResponseHandler responseHandler = new ResponseHandler();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> comboBoxItems = FXCollections.observableArrayList("A","B","C","D","E","F");
        this.gradeComboBox.getItems().addAll(comboBoxItems);
        DeliveryDataModel delivery;
        delivery = DeliveryHandler.getSelectedDelivery();
        
        String moduleName;
        moduleName = delivery.getActualModuleNr() + " " + delivery.getModuleNr().getModuleName();
        String studentName = delivery.getDeliveredByFullName();
        
        moduleNameLabel.setText(moduleName);
        studentNameLabel.setText(studentName);
    }    

    @FXML
    private void onClickSaveButton(ActionEvent event) throws Exception{
        DeliveryDataModel delivery = DeliveryHandler.getSelectedDelivery();
        delivery.setDeliveryStatus("Evaluated");
        deliveryHandler.updateDeliveryStatus(delivery);
        
        EvaluationDataModel evaluation = new EvaluationDataModel();
        
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        evaluation.setDate(strDate);
        evaluation.setEvaluatedBy(UserHandler.getLoggedInUser());
        evaluation.setEvaluation(gradeComboBox.getValue());
        evaluation.setHandin(delivery);
        
        evaluationHandler.saveEvaluation(evaluation);
        
        ResponseDataModel response = new ResponseDataModel();
        response.setAuthor(UserHandler.getLoggedInUser());
        response.setComment(evaluationCommentText.getText());
        response.setDeliveryId(DeliveryHandler.getSelectedDelivery());
        response.setDate(strDate);
        
        responseHandler.saveResponse(response);
        
        MainUserInterface.getInstance().setScene(ViewNames.teacherView);
        
        
    }
    
    // ---- Start Top Menu on click functions ----
    @FXML
    private void onClickDeliveriesButton(ActionEvent event) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.teacherView);
    }

    @FXML
    private void onClickStudentButton(ActionEvent event) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.teacherStudentView);
    }

    @FXML
    private void onClickModuleButton(ActionEvent event) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.teacherModuleView);
    }

    @FXML
    private void onClickCreateModuleButton(ActionEvent event) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.teacherCreateView);
    }

    @FXML
    private void onClickLogOutButton(ActionEvent event) throws Exception{
        UserHandler.logOutUser();
        MainUserInterface.getInstance().setScene(ViewNames.loginView);
    }
    // ---- End Top Menu on click functions ----
    
}
