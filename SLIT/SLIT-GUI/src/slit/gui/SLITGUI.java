/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


/**
 *
 * @author Melcor
 */
public class SLITGUI extends Application {
    private HBox hbox, hboxLeft, hboxRight, moduleTop;
    private VBox vboxModule, vboxOptions;
    private BorderPane border, borderModule;
    private Button modName, btModules, btCourseOverview, btContact, btProfile, appLogo;
    private Label usrname, lbCourse;
    private Text modDesc, modGoals;
    private Scene sceneOne, sceneMod, sceneOV, sceneCont, sceneProf;
    private TableView moduleTable;
    private List<TableColumn> tcModules;
    private Stage mainStage;
    private static int WINDOW_HEIGHT = 700;
    private static int WINDOW_WIDTH = 1000;
    private TestGen generator;
    
    private String modDescript = "I denne modulen skal du først og fremst lære å "+ 
                "bruke verktøyene \ndu skal bruke i resten av kurset. " +
                "I tillegg skal \ndu begynne å lære litt om objektorientert"+
                " programmering og java.";
    private String modGoal = "LÆRINGSMÅL:\nBruke BlueJ, bl.a. til å:\n" +
                "Åpne, lagre, og lukke prosjekter.\n" +
                "Lage objekter\n" +
                "Kalle metoder i objektene, med og uten parametere\n" +
                "Bruke editoren til å se på kildekoden til en klasse\n" +
                "Kunne kompilere prosjektet\n" +
                "Litt java, du skal f.eks.\n" +
                "Kunne kjenne igjen en klassedefinisjon, og kunne finne " +
                "navnet på klassen\nKjenne til forskjellige typer data\n" +
                "Kalle metoder med et objekt som parameter\n" +
                "Kalle metoder som returnerer en verdi\n" +
                "Kjenne forskjellen mellom klasser og objekter";
    @Override
    public void start(Stage primaryStage) {
        int numb = 10;
        generator = new TestGen();
        generator.generateMods(numb);
        ObservableList<CModules> modList;
        modList = generator.getMods();
        border = new BorderPane();
        
        vboxModule = new VBox(50);
        vboxModule.setAlignment(Pos.CENTER);
        borderModule = new BorderPane();
        CModules modOne = modList.get(0);
        modName = new Button(modOne.getTitle());
        modDesc = new Text(modOne.getDesc());
        modGoals = new Text(modOne.getGoals());
        
        moduleTop = new HBox(10);
        modName.setPrefWidth(500);
        modName.setPrefHeight(70);
        moduleTop.getChildren().addAll(modName);
        borderModule.setPrefWidth(500);
        
        borderModule.setTop(moduleTop);
        borderModule.setLeft(modDesc);
        borderModule.setMargin(modDesc, new Insets(50,10,10,10));
        borderModule.setBottom(modGoals);
        borderModule.setMargin(modGoals, new Insets(10,10,90,10));
        borderModule.setStyle("-fx-border-style: solid;"
                        + "-fx-border-width: 1;"
                        + "-fx-border-color: black;"
                        + "-fx-background-color: #FFF");
        
        vboxOptions = new VBox(30);
        vboxOptions.setAlignment(Pos.CENTER_RIGHT);

        border.setTop(getHeader());
        border.setLeft(borderModule);
        border.setMargin(borderModule, new Insets(100,0,100,10));
        border.setRight(vboxOptions);
        border.setMargin(vboxOptions, new Insets(100,10,100,0));
        btModules = new Button("All Modules");
        btModules.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                gotoScene(getSceneModules());
            }
        });
        btModules.setPrefHeight(50);
        btModules.setPrefWidth(200);
        btCourseOverview = new Button("Course Overview");
        btCourseOverview.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                gotoScene(getSceneOV());
            }
        });
        btCourseOverview.setPrefHeight(50);
        btCourseOverview.setPrefWidth(200);
        btContact = new Button("Contact Prof.");
        btContact.setPrefHeight(50);
        btContact.setPrefWidth(200);
        btProfile = new Button("Profile");
        btProfile.setPrefHeight(50);
        btProfile.setPrefWidth(200);
        
        vboxOptions.setPrefWidth(500);
        vboxOptions.getChildren().addAll(btModules, btCourseOverview, 
                btContact, btProfile);
      

        sceneOne = new Scene(border, WINDOW_WIDTH, WINDOW_HEIGHT);
        mainStage = primaryStage;
        mainStage.setTitle("SLIT v0.01");
        mainStage.setScene(sceneOne);
        mainStage.show();
    }
    
    private HBox getHeader(){
        hbox = new HBox(500);
        hbox.setAlignment(Pos.CENTER);
        
        hboxLeft = new HBox(50);
        hboxLeft.setAlignment(Pos.CENTER);
        
        hboxRight = new HBox();
        hboxRight.setAlignment(Pos.CENTER_RIGHT);
        appLogo = new Button("SLIT v0.01");
        appLogo.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                gotoScene(sceneOne);
            }
        });
        appLogo.setStyle("-fx-focus-color: transparent;"
                        +"-fx-base: transparent;"
                        +"-fx-background-color: #A8C5ED;"
                        +"-fx-text-fill: black"
        );
        appLogo.setPrefWidth(70);
        appLogo.setPrefHeight(55);
        usrname = new Label("UserName");
        lbCourse = new Label("IS-109");

        hboxLeft.getChildren().addAll(appLogo, usrname, lbCourse);
        hboxLeft.setPrefHeight(70);
        
        hbox.getChildren().addAll(hboxLeft, hboxRight);
        hbox.setPrefHeight(60);
        hbox.setStyle(
        "-fx-background-color: #A8C5ED");
        return hbox;
    }
    
    private void gotoScene(Scene scene){
        mainStage.setScene(scene);
    }
    // move this into its own class later on
    private Scene getSceneOV(){
        tcModules = new ArrayList<TableColumn>();
        moduleTable = new TableView();
        TableColumn tcUsers = new TableColumn("Name");
        tcModules.add(tcUsers);
        for(int i=1; i<11; i++){
            tcModules.add(new TableColumn("" + i));
            tcModules.get(i).setCellValueFactory(
                            new PropertyValueFactory<>(""+i));
        }
        
        for(int i=0; i<tcModules.size(); i++){
            moduleTable.getColumns().add(tcModules.get(i));
        }
        BorderPane mborder = new BorderPane();
        mborder.setTop(getHeader());
        mborder.setLeft(moduleTable);
        sceneOV = new Scene(mborder, WINDOW_WIDTH, WINDOW_HEIGHT);
        return sceneOV;
    }
    
    private Scene getSceneModules(){
        ObservableList<CModules> modList = FXCollections.observableArrayList();
        modList = generator.getMods();
        TableView<CModules> modTable = new TableView<>();
        TableColumn modNrCol = new TableColumn("Number");
        modNrCol.setCellValueFactory(new PropertyValueFactory<>("modNr"));
        TableColumn modNameCol = new TableColumn("Title");
        modNameCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn modDescCol = new TableColumn("Description");
        modDescCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
        modTable.getColumns().addAll(modNrCol, modNameCol, modDescCol);
        modTable.setItems(modList);
        BorderPane modBorders = new BorderPane();
        modBorders.setTop(getHeader());
        modBorders.setCenter(modTable);
        Scene moduleScene = new Scene(modBorders, WINDOW_WIDTH, WINDOW_HEIGHT);

        return moduleScene;     
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
