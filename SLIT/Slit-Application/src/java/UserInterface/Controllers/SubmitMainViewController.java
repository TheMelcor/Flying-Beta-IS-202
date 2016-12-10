/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.ModuleDataModel;
import Framework.ModuleHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class SubmitMainViewController implements Initializable {

    @FXML
    private Label moduleNameLabel;
    @FXML
    private Label moduleDateLabel;
    @FXML
    private Button chooseFileButton;
    @FXML
    private Button submitButton;
    @FXML
    private TextArea deliveryTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ModuleDataModel module = ModuleHandler.getSelectedModule();
        
        moduleNameLabel.setText(module.getModuleName());
        moduleDateLabel.setText(module.getHandinDate());
    }    

    @FXML
    private void onClickSubmitDelivery(ActionEvent event) {
    }
    
}
