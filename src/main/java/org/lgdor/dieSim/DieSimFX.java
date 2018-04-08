package org.lgdor.dieSim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DieSimFX extends Application{
	
	@Override
	public void start (Stage primaryStage) throws Exception {
		primaryStage.setTitle("Die Simulation");
		Parent root = FXMLLoader.load(this.getClass().getResource("/org/lgdor/dieSim/MainWindow.fxml"));
		Scene scene = new Scene(root, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main (String[] args){
		launch(args);
	}
}
