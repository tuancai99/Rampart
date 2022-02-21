import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class Game extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {


        Image image = new Image("/Images/Game.png");

        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(600);
        imageView.setFitWidth(800);

        imageView.setPreserveRatio(true);

        //Tuan's //
        int startingMoney = 0;
        int startingHealth = 0;
        String charName = Player.getName();
        int levelDif = Player.getLevel();

        if (levelDif == 1) {
            startingMoney =  1000;
            startingHealth = 300;
        } else if (levelDif == 2) {
            startingMoney =  1500;
            startingHealth = 400;
        } else if (levelDif == 3) {
            startingMoney =  2000;
            startingHealth = 500;
        }
        Text text = new Text();

        String moneyStr = "MONEY: " + String.valueOf(startingMoney);
        String healthStr = "HEALTH: " + String.valueOf(startingHealth) + "hp";

        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setX(30);
        text.setY(50);
        text.setText(moneyStr);

        Text text2 = new Text();
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text2.setX(600);
        text2.setY(50);
        text2.setText(healthStr);

        Group root = new Group(imageView, text, text2);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}