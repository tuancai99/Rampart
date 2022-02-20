import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

public class Game extends Application {

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		Pane myPane = new Pane();
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String args[]) { 
      		launch(args); 
   	} 

 }