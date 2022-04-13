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
import java.util.ArrayList;
import java.lang.Double;

public class GameStart extends Application {
    private Button endBtn;
    private ArrayList<Tower> currentTowers;
    private static Stage newStage;
    private ArrayList<Enemy> currentEnemies;
    public GameStart() {
        currentEnemies = new ArrayList<>();
    }
    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws Exception {
        newStage = stage;
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

        Enemy first = createEnemy(0);
        currentEnemies.add(first);
        root.getChildren().add(first.draw());

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setX(150);
        stage.setY(0);
        stage.show();

        new AnimationTimer() {
            private int i = 0; // counter decide when new enemies will come up next
            private int z = 0; // decide which type of enemy will come up next
            @Override
            public void handle(long now) {
                text.setText("MONEY: " + String.valueOf(Player.getMoney()));
                text3.setText("HEALTH: " + String.valueOf(Base.getHealth()) + "hp");

                z = (int) (Math.random() * 3); // return 0, 1 or 2
                if (i == 300) {
                    Enemy newEnemy = createEnemy(z);
                    if (newEnemy != null) { // catch
                        currentEnemies.add(newEnemy);
                        root.getChildren().add(newEnemy.draw());
                    }
                    i = 0;
                }
                i = i + 1;
                int size_of_Towers = currentTowers.size();
                Tower tHolder;
                for (int b = 0; b < size_of_Towers; b++) {
                    tHolder = size_of_Towers.get(b);
                    int size_of_enemy = currentEnemies.size();
                    Enemy smallest = null;
                    int smallest_dist = Double.POSITIVE_INFINITY;
                    //int counter = 0;
                    for (int c = 0; c < size_of_enemy; c++) {
                        Enemy toAttack = currentEnemies.get(c);
                        counter = tHolder.distCalculator(toAttack);
                        if (counter < smallest_dist) {
                            smallest = toAttack;
                            smallest_dist = counter;
                        }
                    }
                    if ((smallest_dist < 150) && (i%40 == 0)) { //Figure out actual value
                        Line attacker = tHolder.attack(smallest);
                        //root.getChildren.add(attacker); // Figure out actual animation
                        if (smallest.getHealth() <= 0) {
                            smallest.setYVal(10000);
                            smallest.getImageView.setY(10000);
                            currentEnemies.remove(smallest);

                        }
                    }
                }
                currentEnemies = enemyWalk(currentEnemies);
                if (!Base.isBaseHealthy()) {
                    try {
                        stop();
                        endGame();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    public void EnemyAttack()

    public static void main(String[] args) {
        launch(args);
    }

    public void pressEndBtn() throws Exception {
        Stage stage;

        stage = (Stage) endBtn.getScene().getWindow();
        stage.close();

    }


    public static Enemy createEnemy(int z) {
        if (z == 0) {
            final Enemy1 e1 = new Enemy1();
            e1.setXVal(1175); // Figure this out!
            e1.setYVal(270); // Figure this out
            return e1;
        } else if (z == 1) {
            final Enemy2 e2 = new Enemy2();
            e2.setXVal(1175);
            e2.setYVal(270);
            return e2;
        } else if (z == 2) {
            final Enemy3 e3 = new Enemy3();
            e3.setXVal(1175);
            e3.setYVal(270);
            return e3;
        }
        return null;
    }

    public static ArrayList<Enemy> enemyWalk(ArrayList<Enemy> currentEnemies) {
        int x = currentEnemies.size();
        for (int b = 0; b < x; b++) {
            if (!(currentEnemies.get(b).getXVal() < 200)) {
                if ((currentEnemies.get(b).getXVal() < 660)
                        && (currentEnemies.get(b).getYVal() < 560)) {
                    currentEnemies.get(b).setYVal(currentEnemies.get(b).getYVal()
                            + currentEnemies.get(b).getWalkingSpeed());
                } else {
                    currentEnemies.get(b).setXVal(currentEnemies.get(b).getXVal()
                            - currentEnemies.get(b).getWalkingSpeed());
                }
                currentEnemies.get(b).getImageView().setX(currentEnemies.get(b).getXVal());
                currentEnemies.get(b).getImageView().setY(currentEnemies.get(b).getYVal());
            } else {
                currentEnemies.get(b).attackBase();
                currentEnemies.get(b).setYVal(10000);
                currentEnemies.get(b).getImageView().setY(10000);
                currentEnemies.remove(currentEnemies.get(b));
            }
        }
        return currentEnemies;
    }

    

    public void endGame() throws Exception {
        Stage stage;
        stage = newStage;
        EndGame endGameScreen = new EndGame();
        endGameScreen.start(stage);
    }

}