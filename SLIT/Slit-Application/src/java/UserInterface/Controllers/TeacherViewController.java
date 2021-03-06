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
public class TeacherViewController implements Initializable {

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
    private TableView<DeliveryDataModel> deliveryTable;
    @FXML
    private TableColumn<DeliveryDataModel, String> studentName;
    @FXML
    private TableColumn<DeliveryDataModel, String> moduleNr;
    @FXML
    private TableColumn<DeliveryDataModel, String> deliveryStatus;
    @FXML
    private TableColumn<DeliveryDataModel, String> dateDelivered;
    
    private DeliveryHandler deliveryHandler = new DeliveryHandler();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.studentName.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("deliveredByFullName"));
        this.moduleNr.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("actualModuleNr"));
        this.deliveryStatus.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("deliveryStatus"));
        this.dateDelivered.setCellValueFactory(
                new PropertyValueFactory<DeliveryDataModel, String>("deliveryDate"));
        
        ObservableList<DeliveryDataModel> deliveryList = FXCollections.observableArrayList();
        
        for(DeliveryDataModel delivery : this.deliveryHandler.getAllDeliveries()){
            deliveryList.add(delivery);
        }
        
        this.deliveryTable.setItems(deliveryList);
    }    

    @FXML
    private void onMouseClickedStudentTable(MouseEvent event) throws Exception{
        DeliveryDataModel delivery = deliveryTable.getSelectionModel().getSelectedItem();
        DeliveryHandler.setSelectedDelivery(delivery);
        MainUserInterface.getInstance().setScene(ViewNames.teacherDeliveryView);
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
