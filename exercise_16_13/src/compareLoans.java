/*
 * *16.13 (Compare loans with various interest rates) Rewrite Programming Exercise 
5.21 to create a GUI, as shown in Figure 16.41b. Your program should let the 
user enter the loan amount and loan period in the number of years from text 
fields, and it should display the monthly and total payments for each interest 
rate starting from 5 percent to 8 percent, with increments of one-eighth, in a 
text area. 
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author rocke
 */
public class compareLoans extends Application {
    //had to move variables so they could be accessed in other methods
    
    TextField loanTxt = new TextField();
    TextArea textArea = new TextArea();
    TextField yearTxt = new TextField();
    
    
    
    @Override
    public void start(Stage primaryStage) {
        //create pane
     BorderPane pane = new BorderPane();
     
     //Loan Amount Text box
     
     Label textA = new Label("Loan Amount: ", loanTxt);
     loanTxt.setPrefColumnCount(7);
     textA.setContentDisplay(ContentDisplay.RIGHT);
     
     //Year Text Box
     
     
     Label textB = new Label("Number of Years:", yearTxt);
     yearTxt.setPrefColumnCount(7);
     textB.setContentDisplay(ContentDisplay.RIGHT);
     
     //Create a Button
     
     Button btTable = new Button("Show Table");
     
     //Create a text area
     textArea.setPrefColumnCount(30);
     
     
     //Create a scroll pane
     
     ScrollPane scrollPane = new ScrollPane(textArea);
     
     //Hbox
     HBox hBox = new HBox(10);
     hBox.setAlignment(Pos.CENTER);
     hBox.getChildren().addAll(textA, yearTxt, textB, loanTxt, btTable);
     
     
     //Positioning within the pane
     pane.setTop(hBox);
     pane.setCenter(textArea);
     
    
     
     
     //Create the Scene
     Scene scene = new Scene(pane);
     primaryStage.setTitle("Ecercise 16.13");
     primaryStage.setScene(scene);
     primaryStage.show();
     
      //Event Handler
     
     btTable.setOnAction(e -> {
         Output();
     });

    }
    public static void main(String[] args) {
        launch(args);
    }
    private void Output() {
        // Create a output string
		String output = "";
		double monthlyInterestRate; // Monthly interest rate
		double monthlyPayment;	// Monthly payment
		
		// Add table header
		output += "Interest Rate       Monthly Payment          Total Payment\n";
		
		// Calculate and add table with interest rates to output
		for (double i = 5.0; i <= 8; i += 0.125) {
			monthlyInterestRate = i / 1200;
			monthlyPayment = Double.parseDouble(loanTxt.getText()) * 
				monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,
				Double.parseDouble(yearTxt.getText()) * 12));

			output += String.format("%-24.3f%-34.2f%-8.2f\n", i, 
				monthlyPayment, (monthlyPayment * 12) * 
				Double.parseDouble(yearTxt.getText()));
		}

		textArea.setText(output);
	}
}
        
    
    