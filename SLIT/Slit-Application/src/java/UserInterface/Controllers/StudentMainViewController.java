package UserInterface.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DataModel.ModuleDataModel;
import Framework.ModuleHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class StudentMainViewController implements Initializable {

    @FXML
    private TableView<ModuleDataModel> moduleTable;
    @FXML
    private TableColumn<ModuleDataModel, String> moduleNr;
    @FXML
    private TableColumn<ModuleDataModel, String> moduleName;
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
        this.moduleName.setCellValueFactory(
                new PropertyValueFactory<ModuleDataModel, String>("moduleName"));
        this.moduleDate.setCellValueFactory(
                new PropertyValueFactory<ModuleDataModel, String>("handinDate"));
        
        ObservableList<ModuleDataModel> moduleList = FXCollections.observableArrayList();
        
        for(ModuleDataModel module : this.moduleHandler.getAllModules()){
            moduleList.add(module);
        }
        this.moduleTable.setItems(moduleList);
    }    
    
}
