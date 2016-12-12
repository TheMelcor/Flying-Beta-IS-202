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
public class TeacherModuleViewController implements Initializable {

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
    private TableView<ModuleDataModel> moduleTable;
    @FXML
    private TableColumn<ModuleDataModel, String> moduleNr;
    @FXML
    private TableColumn<ModuleDataModel, String> moduleDescription;
    @FXML
    private TableColumn<ModuleDataModel, String> moduleDate;
    
    private ModuleHandler moduleHandler = new ModuleHandler();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.moduleNr.setCellValueFactory(
                new PropertyValueFactory<ModuleDataModel, String>("moduleNr"));
        this.moduleDescription.setCellValueFactory(
                new PropertyValueFactory<ModuleDataModel, String>("moduleName"));
        this.moduleDate.setCellValueFactory(
                new PropertyValueFactory<ModuleDataModel, String>("handinDate"));
        
        ObservableList<ModuleDataModel> moduleList = FXCollections.observableArrayList();
        
        for(ModuleDataModel module : this.moduleHandler.getAllModules()){
            moduleList.add(module);
        }
        
        this.moduleTable.setItems(moduleList);
                
    }    

    @FXML
    private void onMouseClickedModuleTable(MouseEvent event) throws Exception{
        ModuleDataModel module = moduleTable.getSelectionModel().getSelectedItem();
        ModuleHandler.setSelectedModule(module);
        MainUserInterface.getInstance().setScene(ViewNames.teacherModuleInfoView);
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
