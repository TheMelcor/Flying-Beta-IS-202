/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Controllers;

import DataModel.UserDataModel;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class TeacherStudentViewController implements Initializable {

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
    private TableView<UserDataModel> studentTable;
    @FXML
    private TableColumn<UserDataModel, String> studentColumn;
    @FXML
    private TextField firstNameField;
    @FXML
    private ComboBox<String> userRolePicker;
    @FXML
    private Button addUserButton;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    
    private UserHandler userHandler = new UserHandler();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.studentColumn.setCellValueFactory(
                new PropertyValueFactory<UserDataModel, String>("fullName"));
        ObservableList<UserDataModel> userList = FXCollections.observableArrayList();
        
        for(UserDataModel user : this.userHandler.getAllStudents()){
            userList.add(user);
        }
        
        this.studentTable.setItems(userList);
        
        ObservableList<String> comboBoxItems = FXCollections.observableArrayList("Student","Teacher","Teaching Assistant");
        this.userRolePicker.getItems().addAll(comboBoxItems);
    }    

    @FXML
    private void onMouseClickedStudentTable(MouseEvent event) {
    }
    
    @FXML
    private void onClickAddUserButton(ActionEvent event) throws Exception{
        UserDataModel user = new UserDataModel();
        user.setFirstName(this.firstNameField.getText());
        user.setLastName(this.lastNameField.getText());
        user.setEmail(this.emailField.getText());
        user.setPassword(this.passwordField.getText());
        user.setUserRole(userHandler.getUserRoleByName(this.userRolePicker.getValue()));
        
        this.userHandler.saveUser(user);
        MainUserInterface.getInstance().setScene(ViewNames.teacherStudentView);
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
