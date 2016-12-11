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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class StudentHandinsViewController implements Initializable {

    // ---- Top Menu items ----
    @FXML
    private Button moduleButton;
    @FXML
    private Button deliveriesButton;
    @FXML
    private Button logOutButton;
    // ---- Ent Top Menu ----
    
    @FXML
    private TableView<DeliveryDataModel> deliveryTable;
    @FXML
    private TableColumn<DeliveryDataModel, String> actualModuleNr;
    @FXML
    private TableColumn<DeliveryDataModel, String> deliveryDate;
    @FXML
    private TableColumn<DeliveryDataModel, String> deliveryStatus;
    
    DeliveryHandler deliveryHandler = new DeliveryHandler();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.actualModuleNr.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("actualModuleNr"));
        this.deliveryDate.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("deliveryDate"));
        this.deliveryStatus.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("deliveryStatus"));
        
        ObservableList<DeliveryDataModel> deliveryList = FXCollections.observableArrayList();
        
        for(DeliveryDataModel delivery : this.deliveryHandler.getDeliveriesByUser(UserHandler.getLoggedInUser())){
            deliveryList.add(delivery);
        }
        //for(DeliveryDataModel delivery : this.deliveryHandler.getAllDeliveries()){
        //    deliveryList.add(delivery);
        //}
        this.deliveryTable.setItems(deliveryList);
    }    

    @FXML
    private void onMouseClickedTable(MouseEvent event) throws Exception{
        DeliveryDataModel delivery = deliveryTable.getSelectionModel().getSelectedItem();
        DeliveryHandler.setSelectedDelivery(delivery);
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
