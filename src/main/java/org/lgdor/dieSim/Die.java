/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lgdor.dieSim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lars2
 */
public class Die extends GridPane implements Initializable {
    
    MainWindowController mainController;
    
    @FXML
    private Text number;
    public String getNumber() {
        return numberTextProperty().get();
    }
    public void setNumber(String number) {
        numberTextProperty().set(number);
    }
    public StringProperty numberTextProperty() {
        return number.textProperty();
    }
    
    @FXML
    private Text value;
    public String getValue() {
        return valueTextProperty().get();
    }
    public void setValue(String value) {
        valueTextProperty().set(value);
    }
    public StringProperty valueTextProperty() {
        return value.textProperty();
    }
    
    public Die(int i,MainWindowController mainControllerInstance) throws IOException{
        this.mainController = mainControllerInstance;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DieGUI.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
        this.setNumber(String.valueOf(i));
        this.setValue(String.valueOf(1));
          
    }
    
    @FXML
    public void roll(ActionEvent event){
        int oldDieValue = Integer.parseInt(this.value.getText());
        int newDieValue = (int)(6*Math.random()+1);
        this.setValue(String.valueOf(newDieValue));
        this.mainController.updateSum(oldDieValue,newDieValue);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
