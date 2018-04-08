/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lgdor.dieSim;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lars2
 */
public class MainWindowController implements Initializable {
    
    @FXML
    Label spinnerText;
    
    @FXML
    Spinner spinner;
    
    @FXML
    HBox buttonBox;
    
    @FXML
    Text dieNumber;
    
    @FXML
    Text sumNumber;
    
    @FXML
    int numberOfDice = 0;
    
    @FXML
    int sumOfDice = 0;
    
    @FXML
    VBox rowBox;
    
    private List<Die> dieList = new ArrayList<>();
    private List<GridPane> rowList = new ArrayList<>();
    
    public void createDice() throws IOException{
        numberOfDice = (int)spinner.getValue();
        
        for (int i=0;i<numberOfDice;i++){
            Die die = new Die(i,this);
            die.roll(null);
            sumOfDice = sumOfDice + Integer.parseInt(die.getValue());
            dieList.add(die);
            rowBox.getChildren().add(die);
        }
        dieNumber.setText(String.valueOf(numberOfDice));
        sumNumber.setText(String.valueOf(sumOfDice));
        spinner.setVisible(false);
        spinnerText.setVisible(false);
        buttonBox.setVisible(false);
    }

    void updateSum(int oldDieValue, int newDieValue){
        int intSum = Integer.parseInt(this.sumNumber.getText());
        this.sumNumber.setText(String.valueOf(intSum-oldDieValue+newDieValue));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20));
        dieNumber.setText("0");
        sumNumber.setText(String.valueOf("0"));
        spinnerText.setVisible(true);
        spinner.setVisible(true);
        buttonBox.setVisible(true);
        
    }    
    
}
