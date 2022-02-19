import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.lang.Integer;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.event.EventHandler;

public class PlayerConfig extends Application {
    private TextField charName;
    private ComboBox<Integer> dif;
    /**
     *
     * @param theStage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage theStage) throws Exception {

	  TextField name = new TextField("Enter your name!");
	  charName = name;
	  Button b = new Button("Begin!");
	  Font f1 = Font.font("Times New Roman", FontWeight.BOLD, 30);
	  b.setFont(f1);
	  b.setLayoutX(325);
	  b.setLayoutY(400);
	  b.setPrefWidth(220);
	  b.setPrefHeight(125);
	  b.setOnAction(new PostHandler());
	  
	  Font f2 = Font.font("Times New Roman", FontWeight.BOLD, 20);
	  Text t1 = new Text(550, 240, "Choose your difficulty!");
	  t1.setFont(f2);
	  Text t2 = new Text(325, 100, "Player Configuration!");
	  t2.setFont(f1);
	  
	  ComboBox<Integer> c = new ComboBox<Integer>();
	  c.getItems().addAll(new Integer(1), new Integer(2), new Integer(3));	
	  c.setLayoutX(550);
	  c.setLayoutY(250);
	  dif = c;
	  
	  name.setLayoutX(200);
	  name.setLayoutY(250);

	  Image back = new Image("welcome.jpeg");
	  BackgroundImage bi = new BackgroundImage(back, null, null, null, null);
	  Background fin = new Background(bi);
	  
        Pane pane = new Pane();
	  pane.setPrefSize(800, 600);
	  pane.getChildren().addAll(name, b, c, t2, t1);
	  pane.setBackground(fin);
        Scene scene = new Scene(pane);
	  theStage.setTitle("Game Config");
        theStage.setScene(scene);
        theStage.show();
    }

    class PostHandler implements EventHandler<ActionEvent> {
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
			//Move to next map here
		  }	
	    }
    }
    

    public static void main(String[] args) {
        launch(args);
    }


}
