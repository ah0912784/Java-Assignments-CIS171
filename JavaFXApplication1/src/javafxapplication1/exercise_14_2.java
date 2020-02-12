/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
/**
 *
 * @author rocke
 */
public class exercise_14_2 extends Application{
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		GridPane pane = new GridPane();

		// Add nodes to pane
		for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
			int n = (int)(Math.random() * 3);
			if (n == 0)
                            pane.add(new ImageView(new Image("image/x.gif")), j, i);
			else if (n == 1)
                            pane.add(new ImageView(new Image("image/o.gif")), j, i);
			else
                            continue;
			}
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 120, 130);
		primaryStage.setTitle("Exercise_14_02"); // Set title for stage
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	
}



