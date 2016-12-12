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
public class TeacherModuleInfoViewController implements Initializable {

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
    private Text moduleInfoLabel;
    @FXML
    private Text moduleGoalLabel;
    @FXML
    private Label moduleNameLabel;
    @FXML
    private Label moduleDateLabel;
    
    private ModuleHandler moduleHandler = new ModuleHandler();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ModuleDataModel selectedModule = ModuleHandler.getSelectedModule();
        moduleNameLabel.setText(selectedModule.getModuleNr() + " "+ selectedModule.getModuleName());
        moduleInfoLabel.setText(selectedModule.getModuleDesc());
        moduleGoalLabel.setText(selectedModule.getModuleGoal());
        moduleDateLabel.setText(selectedModule.getHandinDate());
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
