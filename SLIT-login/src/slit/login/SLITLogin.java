/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tinahollelandkvist
 */
public class SLITLogin extends Application {
   private Scene scene;
   private BorderPane root;
   private GridPane gp;
   private Label lblUserName, lblPassword; 
   private TextField txtUserName, txtPassword;
   private Button btnLogin, btn1, moduler, minPlan,
           oversikt;
   private HBox hbox;
   private String css;
   private static final int WINDOW_HEIGHT = 700;
   private static final int WINDOW_WIDTH = 900;
 
  
     public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) {
        gp = new GridPane();
        
    gp.setHgap(10);
    gp.setVgap(10);
    gp.setPadding(new Insets(25, 25, 25, 25));
    gp.setAlignment(Pos.CENTER);
    
    lblUserName = new Label("Brukernavn:");
    gp.add(lblUserName, 0, 1);
    lblUserName.getStyleClass().add("textFont");
    
    
    txtUserName = new TextField();
    gp.add(txtUserName, 1, 1);
    
    lblPassword = new Label("Passord:");
    gp.add(lblPassword, 0, 3);
    lblPassword.getStyleClass().add("textFont"); 
    
    txtPassword = new TextField();
    gp.add(txtPassword, 1, 3);
    
    btnLogin = new Button("Logg inn");
    HBox hBtn = new HBox(10);
    hBtn.setAlignment(Pos.BOTTOM_RIGHT);
    btnLogin.getStyleClass().add("btnLogin");
    btnLogin.getStyleClass().add("textFont");
    btnLogin.getStyleClass().add("colorWhite");
    hBtn.getChildren().add(btnLogin);
    gp.add(hBtn, 1, 5);  
        
    btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            //Label secondLabel = new Label ("Yes");  
     
        BorderPane bp = new BorderPane();
        bp.getStyleClass().add("fill");
    
        bp.setTop(addHBox());
    
        //bp.getChildren().add(secondLabel);
    
        Scene secondScene = new Scene (bp, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        Stage secondStage = new Stage();
        secondStage.setTitle("New Stage");
        secondStage.setScene(secondScene);
        
        secondStage.show();
        primaryStage.close();
        
        }
    });
 
    root = new BorderPane();
    root.setTop(btn1);
    root.setPadding(new Insets(15, 15, 15, 15));
    root.getStyleClass().add("fill");
    
  
    root.setCenter(gp);
 
    scene = new Scene(root,  WINDOW_WIDTH, WINDOW_HEIGHT); 
    
    css = SLITLogin.class.getResource("looks.css").toExternalForm();
    scene.getStylesheets().add(css);  
    
    primaryStage.setScene(scene);       
    primaryStage.show();
    
    }
    
     
    private HBox addHBox () {
        
        hbox = new HBox(8);
        hbox.getStylesheets().add(css);
        hbox.setStyle(
                       "-fx-background-color: #88bca2;");
        hbox.setPadding(new Insets(10, 9, 10, 9));
        hbox.getStyleClass().add("btnLogin");
        
        
        moduler = new Button("MODULER");
        moduler.setPadding(new Insets(10, 10, 10, 10));
        moduler.setStyle(
                        "-fx-background-color: #88bca1");
        moduler.getStyleClass().add("colorWhite");
        moduler.getStyleClass().add("fontSize");
        
        minPlan = new Button ("MIN PLAN");
        minPlan.setPadding(new Insets(10, 10, 10, 10));
        minPlan.setStyle(
                        "-fx-background-color: #88bca1");
        minPlan.getStyleClass().add("colorWhite");
        minPlan.getStyleClass().add("fontSize");
        
        oversikt = new Button ("OVERSIKT");
        oversikt.setPadding(new Insets(10, 300, 10, 10));
        oversikt.setStyle(
                        "-fx-background-color: #88bca1");
        oversikt.getStyleClass().add("colorWhite");
        oversikt.getStyleClass().add("fontSize");
        
        Label loginAs = new Label("Logget inn som");
        loginAs.getStyleClass().add("colorWhite");
        loginAs.setAlignment(Pos.CENTER_RIGHT);
        
        HBox.setHgrow(moduler, Priority.ALWAYS);
        HBox.setHgrow(minPlan, Priority.ALWAYS);
        HBox.setHgrow(oversikt, Priority.ALWAYS);
        HBox.setHgrow(loginAs, Priority.ALWAYS);
       
        /*loginAs.setPadding (new Insets(20, 20, 20, 20));
        loginAs.setAlignment(Pos.TOP_RIGHT);*/
        
        hbox.getChildren().addAll(moduler, minPlan, oversikt, loginAs);
        
        
        return hbox;
    } 
 
    /**private GridPane addGridPane () {
    
    gp = new GridPane();
        
    gp.setHgap(10);
    gp.setVgap(10);
    gp.setPadding(new Insets(25, 25, 25, 25));
    gp.setAlignment(Pos.CENTER);
    
    lblUserName = new Label("Brukernavn:");
    gp.add(lblUserName, 0, 1);
    lblUserName.getStyleClass().add("textFont");
    
    
    txtUserName = new TextField();
    gp.add(txtUserName, 1, 1);
    
    lblPassword = new Label("Passord:");
    gp.add(lblPassword, 0, 3);
    lblPassword.getStyleClass().add("textFont"); 
    
    txtPassword = new TextField();
    gp.add(txtPassword, 1, 3);
    
    btnLogin = new Button("Logg inn");
    HBox hBtn = new HBox(10);
    hBtn.setAlignment(Pos.BOTTOM_RIGHT);
    btnLogin.getStyleClass().add("btnLogin");
    btnLogin.getStyleClass().add("textFont");
    btnLogin.getStyleClass().add("loginColor");
    hBtn.getChildren().add(btnLogin);
    gp.add(hBtn, 1, 5);
    
    final Text actiontarget = new Text();
    gp.add(actiontarget, 1, 6);
    
    btnLogin.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent e) {
            actiontarget.setFill(Color.RED);
            actiontarget.setText("Ok");
        }
    });
    
   
    
    return gp;   
    
    }*/
    
    /**
     * @param args the command line arguments
     */
    
}   

