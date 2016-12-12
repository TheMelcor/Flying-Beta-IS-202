/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.DeliveryDataModel;
import Framework.DeliveryHandler;
import Framework.UserHandler;
import UserInterface.MainUserInterface;
import UserInterface.Names.ViewNames;
import java.net.URL;
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
public class TeacherDeliveryViewController implements Initializable {

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
    private Label studentNameLabel;
    @FXML
    private Label moduleNrLabel;
    @FXML
    private Text deliveryContentText;
    @FXML
    private Button evaluateButton;
    @FXML
    private Label dateDeliveredLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DeliveryDataModel delivery = DeliveryHandler.getSelectedDelivery();
        this.studentNameLabel.setText(delivery.getDeliveredByFullName());
        this.moduleNrLabel.setText(delivery.getModuleNr().getModuleNr() + " " + delivery.getModuleNr().getModuleName());
        this.deliveryContentText.setText(delivery.getContent());
        this.dateDeliveredLabel.setText(delivery.getDeliveryDate());
    }    

    @FXML
    private void onClickEvaluateButton(ActionEvent event) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.teacherEvaluationView);
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
