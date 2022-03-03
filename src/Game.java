import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class Game extends Application {

    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws FileNotFoundException {


        Image image = new Image("/Images/Game.png");

        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(600);
        imageView.setFitWidth(800);

        imageView.setPreserveRatio(true);

        int startingMoney = Player.getMoney();
        int startingHealth = Base.getHealth();

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