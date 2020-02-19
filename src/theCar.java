/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rocke
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.LIGHTBLUE;
import javafx.util.Duration;

public class theCar extends Pane {
    private double x = 0; 
    private final double y = 100;
    private final double radius = 5;
    private Rectangle bottomBody;
    private Polygon topBody;
    private Circle wheel;
    private Circle wheel2;
    private final Timeline animation;

    

    //building the car
    private void buildTheCar() {
    getChildren().clear();
    bottomBody = new Rectangle(x, y - 20, 50, 10);
    topBody = new Polygon(x + 10, y - 20, x + 20,y - 30, x + 30, y - 30, x + 40, y - 20);
    wheel = new Circle(x+15, y - 5, radius);
    wheel2 = new Circle(x + 35, y - 5, radius);
    getChildren().addAll(bottomBody, wheel, wheel2, topBody);
    bottomBody.setFill(GREEN);
    topBody.setFill(LIGHTBLUE);

}
    theCar() {
    buildTheCar();
    animation = new Timeline(
    new KeyFrame(Duration.millis(50), e -> driveCar()));
    animation.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void stop() {
		animation.pause();
	}

	/** Play animation */
	public void start() {
		animation.play();
	}

	/** Increase rate by 1 */
	public void accelerate() {
		animation.setRate(animation.getRate() + 1);
	}

	/** decrease rate by 1 */
	public void decelerate() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1 : 0);
	}

	/** Redraw car with new x value */
	protected void driveCar() {
		if (x <= getWidth()) {
			x += 1;	
		} 
		else
			x = 0;

		buildTheCar();
	}
    
    
    
    
    
    }
    
    
    
    
   








