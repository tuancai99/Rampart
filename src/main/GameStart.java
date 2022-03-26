package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameStart extends Application {
    private Button endBtn;
    private ArrayList<Tower> currentTowers;
    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        currentTowers = Player.getTowersOwned();
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
        text.setY(115);
        text.setText(moneyStr);

        Text text2 = new Text();
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        text2.setX(250);
        text2.setY(90);
        text2.setText("Battle Start!");

        Text text3 = new Text();
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text3.setX(730);
        text3.setY(50);
        text3.setText(healthStr);

        Font f1 = Font.font("verdana", FontWeight.BOLD, 18);

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

        Rectangle r1 = new Rectangle(204.5, 549.5, 505.5, 66);
        r1.setFill(Color.TRANSPARENT);
        Rectangle r2 = new Rectangle(630, 250, 80, 300);
        r2.setFill(Color.TRANSPARENT);
        Rectangle r3 = new Rectangle(709, 250, 491, 74.75);
        r3.setFill(Color.TRANSPARENT);

        Rectangle r4 = new Rectangle(118, 370, 86.5, 360);
        r4.setFill(Color.TRANSPARENT);
        Rectangle r5 = new Rectangle(135, 340, 60, 30);
        r5.setFill(Color.TRANSPARENT);
        Rectangle r6 = new Rectangle(150, 310, 30, 30);
        r6.setFill(Color.TRANSPARENT);
        Rectangle r7 = new Rectangle(160, 275, 19, 35);
        r7.setFill(Color.TRANSPARENT);

        Group root = new Group(imageView, text, text2, text3, endBtn,
                r1, r2, r3, r4, r5, r6, r7);

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

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                text.setText("MONEY: " + String.valueOf(Player.getMoney()));
                text3.setText("HEALTH: " + String.valueOf(Base.getHealth()) + "hp");
            }
        }.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void pressEndBtn() throws Exception {
        Stage stage;

        stage = (Stage) endBtn.getScene().getWindow();
        stage.close();

    }

}
