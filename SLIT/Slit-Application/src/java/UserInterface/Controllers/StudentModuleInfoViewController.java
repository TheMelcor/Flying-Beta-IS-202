/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.ModuleDataModel;
import Framework.ModuleHandler;
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
    
}
