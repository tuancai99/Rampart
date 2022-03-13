import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

public class GameConfig extends Application {
    private Button beginBtn;
    private Button endBtn;
    private Button accessShop;
    private ArrayList<Tower> currentTowers;
    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("/Images/map2.png");

        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(1200);
        imageView.setFitWidth(1450);

        imageView.setPreserveRatio(true);

        int startingMoney = Player.getMoney();
        int startingHealth = Base.getHealth();

        String moneyStr = "MONEY: " + String.valueOf(startingMoney);
        String healthStr = "HEALTH: " + String.valueOf(startingHealth) + "hp";

        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setX(30);
        text.setY(50);
        text.setText(moneyStr);

        Text text2 = new Text();
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text2.setX(600);
        text2.setY(50);
        text2.setText(healthStr);

        Font f1 = Font.font("verdana", FontWeight.BOLD, 10);
        beginBtn = new Button("Start Round");
        beginBtn.setFont(f1);
        beginBtn.setLayoutX(230);
        beginBtn.setLayoutY(18);
        beginBtn.setPrefWidth(100);
        beginBtn.setPrefHeight(35);
        beginBtn.setOnAction(event -> {
            try {
                pressStartRoundBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        endBtn = new Button("End Game");
        endBtn.setFont(f1);
        endBtn.setLayoutX(460);
        endBtn.setLayoutY(18);
        endBtn.setPrefWidth(100);
        endBtn.setPrefHeight(35);
        endBtn.setOnAction(event -> {
            try {
                pressEndBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        accessShop = new Button("Shop");
        Font f2 = Font.font("Comic Sans MS", FontWeight.BOLD, 25);
        accessShop.setFont(f2);
        accessShop.setLayoutX(1200);
        accessShop.setLayoutY(20);
        accessShop.setPrefWidth(200);
        accessShop.setPrefHeight(90);
        accessShop.setOnAction(event -> {
            try {
                shopHandler();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Rectangle rectangle1 = new Rectangle(247, 664, 514, 80);
        Rectangle rectangle2 = new Rectangle(761, 301, 97, 443);
        Rectangle rectangle3 = new Rectangle(858, 301, 600, 92);

        Group root = new Group(imageView, text, text2, beginBtn, endBtn, accessShop, rectangle1, rectangle2, rectangle3);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void shopHandler() throws Exception{
        Stage myStage;
        myStage = (Stage) accessShop.getScene().getWindow();
        Shop shop = new Shop();
        shop.start(myStage);
    }

    public void pressStartRoundBtn() throws Exception {
        Stage stage;

        stage = (Stage) beginBtn.getScene().getWindow();
        GameStart gameRoundStart = new GameStart();
        gameRoundStart.start(stage);

    }

    public void pressEndBtn() throws Exception {
        Stage stage;

        stage = (Stage) endBtn.getScene().getWindow();
        stage.close();

    }

}