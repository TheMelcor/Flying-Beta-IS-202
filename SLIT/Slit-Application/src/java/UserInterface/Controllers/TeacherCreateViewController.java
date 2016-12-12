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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class TeacherCreateViewController implements Initializable {

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
    private TextArea moduleDescField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button createButton;
    @FXML
    private TextField moduleNameField;
    @FXML
    private TextArea moduleGoalField;
    @FXML
    private TextField moduleNrField;
    @FXML
    private TextField hourField;
    @FXML
    private TextField minuteField;
    @FXML
    private TextField secondsField;
    @FXML
    private Label errorLabel;
    
    private ModuleHandler moduleHandler;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        moduleHandler = new ModuleHandler();
    }    

    private boolean checkIntInput(String input){
        if (input.contains("[a-zA-Z]+")){
            return false;
        }
        
        else{
            return true;
        }
    }
    
    @FXML
    private void onClickCreateButton(ActionEvent event) throws Exception{
        boolean check = true;
        ModuleDataModel module = new ModuleDataModel();
        
        if(!checkIntInput(this.moduleNrField.getText())){
            check = false;
        }
        if(!checkIntInput(this.hourField.getText())){
            check = false;
        }
        if(!checkIntInput(this.minuteField.getText())){
            check = false;
        }
        if(!checkIntInput(this.secondsField.getText())){
            check = false;
        }
        module.setModuleNr(Integer.parseInt(this.moduleNrField.getText()));
        module.setModuleDesc(this.moduleDescField.getText());
        module.setModuleName(this.moduleNameField.getText());
        module.setModuleGoal(this.moduleGoalField.getText());
        
        String moduleDate;
        moduleDate = String.valueOf(this.datePicker.getValue()) + " "
                + this.hourField.getText() + ":" + this.minuteField.getText() 
                + ":" + this.secondsField.getText();
        module.setHandinDate(moduleDate);
        
        if (check){
            moduleHandler.saveModule(module);
            MainUserInterface.getInstance().setScene(ViewNames.teacherModuleView);
        }
        else{
            errorLabel.setText("Input Error!");
        }
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
