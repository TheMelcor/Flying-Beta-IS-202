/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.gui;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
/**
 *
 * @author Melcor
 */
public class TestGen {
    ObservableList<CModules> modList = FXCollections.observableArrayList();
    public TestGen(){
       
    }
    public void generateMods(int amount){
        for(int i = 0; i < amount; i++){
            int temp = i+1;
            int nr = temp;
            String title = "Some Title";
            String desc = "Some Description";
            String goals = "Some Goals";
            modList.add(new CModules(nr, title, desc, goals));
        }
    }
    public ObservableList getMods(){
        return modList;
    }
}
