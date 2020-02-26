
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*(Demonstrate TextField properties) Write a program that sets the
 *horizontal-alignment and column-size properties of a text field dynamically, 
 *as shown in Figure 16.38a.
*/



public class exercise_16_06 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        //Top Text box
        TextField a = new TextField("JavaFXS");
        
        Label textF = new Label("Text Field:", a);
        textF.setContentDisplay(ContentDisplay.RIGHT);
        
        HBox topBox = new HBox(a);
        topBox.setPadding(new Insets(2));
        pane.add(topBox, 0, 0);
        //end of the top text box
        
       //radio buttons
        ToggleGroup group = new ToggleGroup();
        
        //starting the buttons
        RadioButton buttonRight = new RadioButton();
        RadioButton buttonLeft = new RadioButton();
        RadioButton buttonCenter = new RadioButton();
        //left position
         Label leftLabel = new Label("Left", buttonLeft);
        buttonLeft.setToggleGroup(group);
        buttonLeft.setOnAction(e -> a.setAlignment(Pos.CENTER_LEFT));
        buttonLeft.setSelected(true);
        
        //right position
        Label rightLabel = new Label("Right", buttonRight);
        buttonRight.setToggleGroup(group);
        buttonRight.setOnAction(e -> a.setAlignment(Pos.CENTER_RIGHT));
        
        //center position
        Label centerLabel = new Label("Center", buttonCenter);

        buttonCenter.setOnAction(e-> a.setAlignment(Pos.CENTER));
        buttonCenter.setToggleGroup(group);
        
        //the other text box
        TextField tfColumnSize = new TextField();
        tfColumnSize.setPrefColumnCount(3);
        tfColumnSize.setText("12");

        tfColumnSize.setOnAction(e->
                a.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText())));
        Label lblColumnSize = new Label("Column Size", tfColumnSize);
        lblColumnSize.setContentDisplay(ContentDisplay.RIGHT);
        //Putting everything tin line
        HBox hBox = new HBox(leftLabel, centerLabel, rightLabel, lblColumnSize);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        pane.add(hBox, 0, 1);

        
        //end of radio buttons
        //Setting Scene
        primaryStage.setTitle("exercise 16.6");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        
        
        
        
        
        
        
        
        
        
    }
}
