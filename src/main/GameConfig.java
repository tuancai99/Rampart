package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.util.ArrayList;

public class GameConfig extends Application {
    private Button beginBtn;
    private Button endBtn;
    private Button accessShop;
    private ArrayList<Tower> currentTowers;
    private int round;
    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws Exception {
        currentTowers = Player.getTowersOwned();
        round = Map.getRound();

        Image image = new Image("/Images/map2.png");
        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(900);
        imageView.setFitWidth(1200);
        imageView.setPreserveRatio(true);

        int startingMoney = Player.getMoney();
        double startingHealth = Base.getHealth();

        String moneyStr = "MONEY: " + String.valueOf(startingMoney);
        String healthStr = "HEALTH: " + String.valueOf(startingHealth) + "hp";

        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setX(730);
        text.setY(105);
        text.setText(moneyStr);

        Text text2 = new Text();
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text2.setX(730);
        text2.setY(65);
        text2.setText(healthStr);

        Text text3 = new Text();
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text3.setX(250);
        text3.setY(70);
        text3.setFill(Color.PALEVIOLETRED);
        text3.setStroke(Color.BLACK);
        text3.setStrokeWidth(.5);
        text3.setText("Prepare for Battle");

        Text text4 = new Text();
        text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text4.setX(380);
        text4.setY(115);
        text4.setFill(Color.MISTYROSE);
        text4.setStroke(Color.BLACK);
        text4.setStrokeWidth(.5);
        if (round == 4) {
            text4.setX(370);
            text4.setText("Final Round");
        } else {
            text4.setText("Round " + round);
        }

        Font f1 = Font.font("verdana", FontWeight.BOLD, 18);
        beginBtn = new Button("Start Round");
        beginBtn.setFont(f1);
        beginBtn.setLayoutX(50);
        beginBtn.setLayoutY(10);
        beginBtn.setPrefWidth(150);
        beginBtn.setPrefHeight(60);
        beginBtn.setOnAction(event -> {
            try {
                pressStartRoundBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        endBtn = new Button("End Game");
        endBtn.setFont(f1);
        endBtn.setLayoutX(1000);
        endBtn.setLayoutY(45);
        endBtn.setPrefWidth(150);
        endBtn.setPrefHeight(60);
        endBtn.setOnAction(event -> {
            try {
                pressEndBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        accessShop = new Button("Shop");
        accessShop.setFont(f1);
        accessShop.setLayoutX(50);
        accessShop.setLayoutY(80);
        accessShop.setPrefWidth(150);
        accessShop.setPrefHeight(60);
        accessShop.setOnAction(new ShopHandler());

        Group root = new Group(imageView, text, text2, text3, text4, beginBtn, endBtn,
                accessShop);

        if (currentTowers != null) {
            for (int i = 0; i < currentTowers.size(); i++) {
                Tower curr = currentTowers.get(i);
                root.getChildren().add(curr.getImageView());
            }
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setX(150);
        stage.setY(0);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
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

    public class ShopHandler implements EventHandler<javafx.event.ActionEvent> {
        public void handle(ActionEvent action) {
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

}