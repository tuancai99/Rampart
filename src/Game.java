import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;



public class Game extends Application {
    private Button accessShop;
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

        imageView.setFitHeight(1200);
        imageView.setFitWidth(1450);

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


        accessShop = new Button("Shop");
        Font f1 = Font.font("Comic Sans MS", FontWeight.BOLD, 25);
        accessShop.setFont(f1);
        accessShop.setLayoutX(1200);
        accessShop.setLayoutY(20);
        accessShop.setPrefWidth(200);
        accessShop.setPrefHeight(90);
        accessShop.setOnAction(new ShopHandler());


        Group root = new Group(imageView, text, text2, accessShop);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    public class ShopHandler implements EventHandler<javafx.event.ActionEvent> {
        public void handle(ActionEvent event) {
            Stage myStage;
            myStage = (Stage) accessShop.getScene().getWindow();
            Shop shop = new Shop();
            try {
                shop.start(myStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}