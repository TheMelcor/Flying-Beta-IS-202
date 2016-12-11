/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.ModuleDataModel;
import Framework.ModuleHandler;
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
public class StudentModuleInfoViewController implements Initializable {
   
    // ---- Top Menu items ----
    @FXML
    private Button moduleButton;
    @FXML
    private Button deliveriesButton;
    @FXML
    private Button logOutButton;
    // ---- Ent Top Menu ----
    
    @FXML
    private Label moduleNameLabel;
    @FXML
    private Text moduleInfoLabel;
    @FXML
    private Button goToSubmitButton;
    @FXML
    private Text moduleGoalLabel;
    @FXML
    private Label moduleDateLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ModuleDataModel module = ModuleHandler.getSelectedModule();
        
        moduleNameLabel.setText(module.getModuleName());
        moduleInfoLabel.setText(module.getModuleDesc());
        moduleGoalLabel.setText(module.getModuleGoal());
        moduleDateLabel.setText(module.getHandinDate());
    }    

    @FXML
    private void onClickSubmitButton(ActionEvent event) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.submitMainView);
    }
    
    // ---- Top Menu on click functions ----
    @FXML
    private void onClickModuleButton(ActionEvent e) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.studentMainView);
    }
    @FXML
    private void onClickDeliveriesButton(ActionEvent e) throws Exception{
        MainUserInterface.getInstance().setScene(ViewNames.studentHandinsView);
    }
    @FXML
    private void onClickLogOutButton(ActionEvent e) throws Exception{
        UserHandler.logOutUser();
        MainUserInterface.getInstance().setScene(ViewNames.loginView);
    }
    // ---- End Top Menu on click functions ----
    
}
