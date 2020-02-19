
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/*
 * **15.29 (Racing car) Write a program that simulates car racing, 
 * as shown in Figure 15.36a. The car moves from left to right. 
 * When it hits the right end, it restarts from the left and continues the same 
 *process. You can use a timer to control animation. Redraw the car with a 
 *new base coordinates (x, y), as shown in Figure 15.36b. Also let the user 
 *pause/resume the animation with a button press/release and increase/decrease 
 *the car speed by pressing the UP and DOWN arrow keys.
 */

/**
 *
 * @author rocke
 */
public class exercise_15_29 extends Application {
   
    @Override
    public void start(Stage primaryStage){
       // TODO Auto-generated method stub
      
       theCar pane = new theCar();

		// Create and register handles
		pane.setOnMousePressed(e -> pane.stop());
		pane.setOnMouseReleased(e -> pane.start());

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				pane.accelerate();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				pane.decelerate();
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 600, 100);
		primaryStage.setTitle("Racing Car"); //stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		pane.requestFocus(); // Request focus
	}
       
    }
    