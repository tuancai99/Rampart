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
import java.lang.Integer;

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
            int i = 0;
            Integer z = 0;
            ArrayList<Enemy> e = new ArrayList<Enemy>();
            @Override
            public void handle(long now) {
                text.setText("MONEY: " + String.valueOf(Player.getMoney()));
                text3.setText("HEALTH: " + String.valueOf(Base.getHealth()) + "hp");                
                if (i == 300) {
		            createEnemy(e, z);
                    i = 0;
		        }
                i = i + 1;
                enemyWalk(e);
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

    public void createEnemy(ArrayList<Enemy> en, Integer zz) {
        if (zz == 0) {
            final Enemy1 e1 = new Enemy1();
            e1.setXVal(1000); // Figure this out!
            e1.setYVal(250); // Figure this out
            e1.draw();
            en.add(e1);
            root.getChildren().add(e1.getImageView2());
            zz = 1;
        } else if (z == 1) {
            final Enemy2 e2 = new Enemy2();
            e2.setXVal(1000);
            e2.setYVal(250);
            e2.draw();
            en.add(e2);
            root.getChildren().add(e2.getImageView2());
            zz = 2;
        } else if (z == 2) {
            final Enemy3 e3 = new Enemy3();
            e3.setXVal(1000);
            e3.setYVal(250);
            e3.draw();
            en.add(e3);
            root.getChildren().add(e3.getImageView2());
            zz = 0;
        }
    }

    public void enemyWalk(ArrayList<Enemy> en) {
        int x = en.size();
        for (int b = 0; b < x; b++) {
            if (!(en.get(b).getXVal() < 200)) {
                if((en.get(b).getXVal() < 660) && (en.get(b).getYVal() < 560)) {
                    en.get(b).setYVal(en.get(b).getYVal() + (en.get(b).walkingSpeed)/10);
                    en.get(b).getImageView2().setX(en.get(b).getXVal());
                    en.get(b).getImageView2().setY(en.get(b).getYVal());
                } else {
                    en.get(b).setXVal(en.get(b).getXVal() - (en.get(b).walkingSpeed)/10);
                    en.get(b).getImageView2().setX(en.get(b).getXVal());
                    en.get(b).getImageView2().setY(en.get(b).getYVal());
                }
            } else {
                en.get(b).attackBase();
                en.get(b).setYVal(10000);
                en.get(b).getImageView2().setY(10000);
                en.remove(en.get(b));
            }
        }
    }

    public void baseGone() {
        if (Base.getHealth() <= 0) {
            EndGame egame = new EndGame();
            egame.start();
        }
    }

}