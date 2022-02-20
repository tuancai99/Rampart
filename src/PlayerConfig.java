import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.lang.Integer;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.event.EventHandler;

public class PlayerConfig extends Application {
    private TextField charName;
    private ComboBox<Integer> dif;
    private Button beginBtn; 
     /*
     * @param theStage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage theStage) throws Exception {

	  TextField name = new TextField("Enter your name!");
	  charName = name;
	  beginBtn = new Button("Begin Game!");
	  Font f1 = Font.font("Comic Sans MS", FontWeight.BOLD, 25);
	  beginBtn.setFont(f1);
	  beginBtn.setLayoutX(310);
	  beginBtn.setLayoutY(350);
	  beginBtn.setPrefWidth(200);
	  beginBtn.setPrefHeight(90);
	  beginBtn.setOnAction(new PostHandler());

	  Font f2 = Font.font("Comic Sans MS", FontWeight.BOLD, 20);
	  Font f3 = Font.font("Comic Sans MS", FontWeight.BOLD, 50);
	  Text t1 = new Text(480, 240, "Choose your difficulty:");
	  t1.setFont(f2);
	  Text t2 = new Text(160, 100, "Player Configuration!");
	  t2.setFont(f3);
	  Text t3 = new Text(150, 240, "Name:");
	  t3.setFont(f2);
	  
	  ComboBox<Integer> c = new ComboBox<Integer>();
	  c.getItems().addAll(new Integer(1), new Integer(2), new Integer(3));
	  c.setPrefWidth(210);
	  c.setPrefHeight(20);
	  c.setLayoutX(480);
	  c.setLayoutY(250);
	  dif = c;
	  
	  name.setLayoutX(150);
	  name.setLayoutY(250);

	  Image back = new Image("/Images/welcome.jpeg");
	  BackgroundImage bi = new BackgroundImage(back, null, null, null, null);
	  Background fin = new Background(bi);
	  
      Pane pane = new Pane();
	  pane.setPrefSize(800, 600);
	  pane.getChildren().addAll(name, beginBtn, c, t3, t2, t1);
	  pane.setBackground(fin);
      Scene scene = new Scene(pane);
	  theStage.setTitle("Game Config");
      theStage.setScene(scene);
      theStage.show();
    }

    class PostHandler implements EventHandler<ActionEvent> {
		public void handle() throws Exception {
			handle();
		}

		public void handle(ActionEvent event) {
	       if ((charName.getText().isEmpty()) || (charName.getText().trim().length() == 0)) {
			Alert myAlert = new Alert(Alert.AlertType.ERROR);
			myAlert.setHeaderText("Invalid name");
			myAlert.showAndWait();
		  } else if (dif.getValue() == null) {
			Alert myAlert = new Alert(Alert.AlertType.ERROR);
			myAlert.setHeaderText("Must choose a difficulty");
			myAlert.showAndWait();
		  } else {
		  
			Player.setName(charName.getText());
			Player.setLevel(dif.getValue());

			Stage myStage;
			myStage = (Stage) beginBtn.getScene().getWindow();
        	Game gameScreen = new Game();
			   try {
				   gameScreen.start(myStage);
			   } catch (FileNotFoundException e) {
				   e.printStackTrace();
			   }
		   }
	    }
    }
    

    public static void main(String[] args) {
        launch(args);
    }


}
