

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author rocke
 */
public class BlackJackGUI extends Application{
     BlackJackFunctions func = new BlackJackFunctions();
   

    @Override
    public void start(Stage primaryStage) throws Exception {
        BlackJackFunctions func = new BlackJackFunctions();
        func.shuffle();
        primaryStage.setTitle("Black Jack");
        GridPane pane = new GridPane();
        
        
        //creating buttons 
        Button stayB = new Button("Stay");
        Button hitB = new Button("Hit");
        Button dealB = new Button("Deal");
        Button resetB = new Button("Reset");
        Button newRound = new Button("New Round");
        //actions 
        dealB.setOnAction((ActionEvent event) -> {
            func.Deal();
            createImg(4,func.getPlayerHand(),pane);
            createImgDealer(pane, func.getDealerHand());
            func.calculatePoints(func.getDealerHand(), func.dPoints); 
        });
        
        hitB.setOnAction((ActionEvent event) -> {
            func.Hit();
            createImg(4,func.getPlayerHand(),pane);
        });
        
        stayB.setOnAction((ActionEvent event) -> {
            func.Stay();
            createImg(0,func.getDealerHand(),pane);
            textBoxes(pane, func.getWins(),func.getLosses());
        });
        
        resetB.setOnAction((ActionEvent event) -> {
           removeImg(pane, func.getPlayerHand(), func.getDealerHand());
           func.Reset(); 
           func.shuffle();
           //pane.getChildren(ImageView);
        });
        newRound.setOnAction((ActionEvent event)-> {
           removeImg(pane, func.getPlayerHand(), func.getDealerHand());
           func.newRound();
           func.shuffle();
           
           
        });
        //adding to pane
        pane.add(dealB, 0, 5);
        pane.add(hitB, 1,5);
        pane.add(stayB, 2, 5);
        pane.add(resetB, 3, 5);
        pane.add(newRound, 4, 5);
        //text fields
        textBoxes(pane, func.getWins(),func.getLosses());
       
        
        
        
        
       //setting the scene
//        pane.setHgap(71);
//        pane.setVgap(96);
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    public void createImg(int integer,ArrayList<String> ary, GridPane pane) {
        BlackJackFunctions func = new BlackJackFunctions();
        
        for (int i = 0; i < ary.size(); i++) {
            String img = func.getCardImage(i, ary);
            pane.add(new ImageView(new Image(img)),i, integer);
        }
         
    }
    public void createImgDealer(GridPane pane, ArrayList<String> ary) {
        BlackJackFunctions func = new BlackJackFunctions();
       
        String img = func.getCardImage(0, ary);
        pane.add(new ImageView(new Image(img)),0,0);
        pane.add(new ImageView(new Image("cards_png/b1fv.png")),1,0);
    }
    public void removeImg(GridPane pane, ArrayList<String> ph, ArrayList<String> dh) {
        BlackJackFunctions func = new BlackJackFunctions();
       
        for(int i = 0; i < ph.size(); i++) {
           pane.add(new ImageView(new Image("cards_png/b1fv.png")),i,4);
        }
        for(int i = 0; i < dh.size(); i++) {
           pane.add(new ImageView(new Image("cards_png/b1fv.png")),i,0);
    }
}
    public void textBoxes(GridPane pane, String w, String L) {
        TextField winsT = new TextField(w);
        TextField lossesT = new TextField(L);
        
        Label winsL = new Label("Wins: ");
        Label lossesL = new Label("Losses:    ");
        HBox hbox = new HBox();
      
        hbox.getChildren().addAll(winsL, winsT,lossesL,lossesT);
        winsT.setPrefWidth(25);
        lossesT.setPrefWidth(25);
        pane.add(hbox,0,3 );
    }
    
}