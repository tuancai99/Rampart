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
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

public class Game extends Application {

	@Override
	public void start(Stage stage) throws FileNotFoundException {


		Image image = new Image(new FileInputStream("Game.jpeg"));

		ImageView imageView = new ImageView(image);

		 imageView.setX(0);
		 imageView.setY(0);

		 imageView.setFitHeight(1200);
		 imageView.setFitWidth(1450);

		 imageView.setPreserveRatio(true);

		//Tuan's // 
		int startingMoney = 0;
		int startingHealth = 0;
		String charName = Player.getName();
		int levelDif = Player.getLevel();

		if (levelDif = 1) {
			startingMoney =  1000;
			startingHealth = 300;
		} else if (levelDif = 2) {
			startingMoney =  1500;
			startingHealth = 400;
		} else if ( levelDif = 3) {
			startingMoney =  2000;
			starting = 500;
		}
		Text text = new Text(); 

		String moneyStr = "MONEY: " + String.valueOf(startingMoney);
		String healthStr = "HEALTH: " + String.valueOf(startingHealth) + "hp";
        //Tuan's // 


      	 text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
      
      	 text.setX(50); 
      	 text.setY(100);    

      	 //Tuan's //       
      // change from MONEY: 200 to moneyStr vvvv
      	 text.setText(moneyStr); 
      	 //Tuan's // 


      	 
      	Text text2 = new Text(); 
        
      	 text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
      
      	 text2.setX(1000); 
      	 text2.setY(100);    

      	 //Tuan's //       
      // change from HEALTH: 500 to healthStr vvvv
      	 text2.setText(healthStr); 
      	 //Tuan's // 

		Group root = new Group(imageView, text, text2);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String args[]) { 
      		launch(args); 
   	} 

 }