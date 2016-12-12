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
import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        delivery.setDeliveryDate(strDate);
        delivery.setDeliveryStatus("Not Evaluated");
        deliveryHandler.saveDelivery(delivery);
        DeliveryHandler.setSelectedDelivery(delivery);
        
        // Set to studentHandinView when that is fixed...
        MainUserInterface.getInstance().setScene(ViewNames.studentHandinView);
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
