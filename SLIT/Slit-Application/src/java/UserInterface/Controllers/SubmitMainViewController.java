/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.DeliveryDataModel;
import DataModel.ModuleDataModel;
import Framework.DeliveryHandler;
import Framework.ModuleHandler;
import Framework.UserHandler;
import UserInterface.MainUserInterface;
import UserInterface.Names.ViewNames;
import java.net.URL;
import java.sql.Timestamp;
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
    
    private DeliveryHandler deliveryHandler = new DeliveryHandler();

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
    private void onClickSubmitDelivery(ActionEvent event) throws Exception{
        DeliveryDataModel delivery = new DeliveryDataModel();
        delivery.setDeliveredBy(UserHandler.getLoggedInUser());
        delivery.setModuleNr(ModuleHandler.getSelectedModule());
        delivery.setContent(deliveryTextArea.getText());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        delivery.setDeliveryDate(String.valueOf(timestamp));
        deliveryHandler.saveDelivery(delivery);
        DeliveryHandler.setSelectedDelivery(delivery);
        
        // Set to studentHandinView when that is fixed...
        MainUserInterface.getInstance().setScene(ViewNames.studentHandinView);
    }
    
}
