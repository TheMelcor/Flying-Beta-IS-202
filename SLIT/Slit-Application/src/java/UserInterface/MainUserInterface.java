/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import UserInterface.Names.ViewNames;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Melcor
 */
public class MainUserInterface extends Application {
    
    private Stage stage;
    
    private static MainUserInterface instance; 
    
    private HashMap<String, String> views = new HashMap<String, String>()
    {
        {
            put(ViewNames.studentMainView , "StudentMainView.fxml");
            put(ViewNames.loginView, "LoginView.fxml"); 
            put(ViewNames.studentHandinsView, "StudentHandinsView.fxml");
            put(ViewNames.studentModuleInfoView, "StudentModuleInfoView.fxml");
            put(ViewNames.submitMainView, "SubmitMainView.fxml");
            put(ViewNames.teacherCreateView, "TeacherCreateView.fxml");
            put(ViewNames.teacherEvaluationView, "TeacherEvaluationView.fxml");
            put(ViewNames.teacherStudentView, "TeacherStudentView.fxml");
            put(ViewNames.teacherView, "TeacherView.fxml");
            put(ViewNames.studentHandinView, "StudentHandinView.fxml");
            put(ViewNames.teacherDeliveryView, "TeacherDeliveryView.fxml");
            put(ViewNames.teacherModuleView, "TeacherModuleView.fxml");
            put(ViewNames.teacherModuleInfoView, "TeacherModuleInfoView.fxml");
        }
        
    }; 
    
    public MainUserInterface() 
    {
        instance = this;
    }
    
    public static MainUserInterface getInstance() 
    {
        return instance; 
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        try 
        {
            this.stage = stage; 
            this.setScene(ViewNames.loginView);
            this.stage.show();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }
    
    public void setScene(String value) throws Exception
    {
        if(this.views.containsKey(value))
        {
            this.replaceSceneContent(this.views.get(value)); 
        }
        else 
            throw new Exception("Value does not exist"); 
    }
    

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(MainUserInterface.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            //scene.getStylesheets().add(SlitGUI.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
