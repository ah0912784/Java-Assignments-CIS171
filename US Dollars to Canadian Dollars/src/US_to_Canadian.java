

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Hansen
// CIS 172
//Intro to Java
public class US_to_Canadian extends Application{
    
    // main method
    public static void main(String[] args) {
        launch(args);
    }
    
    //start method
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //text fields 
        TextField textOne = new TextField();
        TextField textTwo = new TextField();
        
        //labels
        Label LabelOne = new Label("US Dollar");
        Label LabelTwo =new Label("Canada Dollar");
        
        //alignment 
        textOne.setAlignment(Pos.TOP_RIGHT);
        textTwo.setAlignment(Pos.TOP_RIGHT);
        
        
        //End of the Text Fields
        
        //Create a buttton
        
        Button button = new Button("Convert");
        
        //add event hanler
        button.setOnAction((ActionEvent arg0) -> {
            //Method to handle the action event
            double usd = Double.parseDouble(textOne.getText()) * 1.5;
            
            textTwo.setText(usd + "");
            textTwo.setStyle("-fx-text-fill: black;"+"-fx-font-size: 12px");
        } 
        );
  
        //create a grid pane
        
        GridPane panel = new GridPane();
        
        //add content
        
        panel.addRow(0,LabelOne, textOne);
        panel.addRow(1, LabelTwo, textTwo);
        panel.addRow(2, button);
        
        //create the scene
        
        Scene scene = new Scene(panel, 400, 200);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Convert USD"+" to CAD");
        primaryStage.show();
        
        
        
      
        
        
    }
}
