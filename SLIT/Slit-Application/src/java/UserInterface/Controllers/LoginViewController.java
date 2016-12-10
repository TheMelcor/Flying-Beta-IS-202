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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Melcor
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;
    
    private UserHandler userHandler = new UserHandler();
    @FXML
    private Label infoBarLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickLoginButton(ActionEvent event) throws Exception {
        UserDataModel userModel = userHandler.loginUser(this.userNameTextField.getText(), this.passwordTextField.getText());
        
        if (userModel.getEmail() != null){
            this.infoBarLabel.setText("Login Success!");
            if(userModel.getUserRole().getRoleName().equals("Teacher")){
                
                MainUserInterface.getInstance().setScene(ViewNames.teacherView);
            }
            else{
                MainUserInterface.getInstance().setScene(ViewNames.studentMainView);
            }
            
        }
        else {
            this.infoBarLabel.setText("Login Failed, u knob.");
        }
        
    }
    
}
