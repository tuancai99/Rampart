package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

public class GameStart extends Application {
    private Button endBtn;
    private ArrayList<Tower> currentTowers;
    private static Stage newStage;
    private ArrayList<Enemy> currentEnemies;
    private static double enemyStartX = 1175;
    private static double enemyStartMinY = 250;
    private static double enemyStartMaxY = 300;
    public GameStart() {
        currentEnemies = new ArrayList<>();
    }
    private static Group root = new Group();
    private int round;
    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws Exception {
        newStage = stage;
        currentTowers = Player.getTowersOwned();
        round = Player.getRound();

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
        text3.setFill(Color.MISTYROSE);
        text3.setStroke(Color.BLACK);
        text3.setStrokeWidth(.5);
        if (round == 4) {
            text3.setText("Final Round Start!");
        } else {
            text3.setText("Round " + round + " Start!");
        }

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

        root = new Group(imageView, text, text2, text3, endBtn);

        if (currentTowers != null) {
            for (int i = 0; i < currentTowers.size(); i++) {
                Tower curr = currentTowers.get(i);
                root.getChildren().add(curr.getImageView());
            }
        }

        Enemy first = createEnemy(1);
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
            private int numOfEnemies = numEnemies(round);
            @Override
            public void handle(long now) {
                text.setText("MONEY: " + String.valueOf(Player.getMoney()));
                text2.setText("HEALTH: " + String.valueOf(Base.getHealth()) + "hp");

                z = (int) (Math.random() * 3) + 1; // return 1, 2, or 3
                if (i == 100 && numOfEnemies > 0) {
                    Enemy newEnemy = createEnemy(z);
                    if (newEnemy != null) { // catch
                        currentEnemies.add(newEnemy);
                        root.getChildren().add(newEnemy.draw());
                        numOfEnemies = numOfEnemies - 1;
                    }
                    i = 0;
                }
                i = i + 1;

                currentEnemies = allEnemyWalk(currentEnemies);

                if (currentEnemies.size() == 0 && numOfEnemies == 0) {
                    if (round != 4) {
                        try {
                            stop();
                            roundWon();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            stop();
                            wonGame();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
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

    public static void main(String[] args) {
        launch(args);
    }

    public void pressEndBtn() throws Exception {
        Stage stage;

        stage = (Stage) endBtn.getScene().getWindow();
        stage.close();

    }


    public static Enemy createEnemy(int z) {
        double y = Math.random() * 51 + enemyStartMinY;
        if (z == 1) {
            return new Enemy1(enemyStartX, y);
        } else if (z == 2) {
            return new Enemy2(enemyStartX, y);
        } else if (z == 3) {
            return new Enemy3(enemyStartX, y);
        }
        return null;
    }

    public static ArrayList<Enemy> allEnemyWalk(ArrayList<Enemy> currentEnemies) {
        int x = currentEnemies.size();
        boolean isEnemyAttacking;
        Enemy curr;
        for (int b = 0; b < x; b++) {
            curr = currentEnemies.get(b);
            isEnemyAttacking = curr.enemyWalk();
            if (isEnemyAttacking) {
                curr.attackBase();
                curr.getImageView().setVisible(false);
                root.getChildren().remove(curr.getImageView());
                root.getChildren().remove(curr);
                currentEnemies.remove(curr);
            }
        }
        return currentEnemies;
    }

    public static int numEnemies(int round) {
        int n;
        switch (round) {
        case 1:
            n = 12;
            break;
        case 2:
            n = 22;
            break;
        case 3:
            n = 33;
            break;
        case 4:
            n = 44;
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + round);
        }
        return n;
    }

    public void roundWon() throws Exception {
        Player.setRound(round + 1);
        Stage stage;
        stage = newStage;
        GameConfig gameConfigScreen = new GameConfig();
        gameConfigScreen.start(stage);
    }

    public void wonGame() throws Exception {
        Stage stage;
        stage = newStage;
        GameConfig gameConfigScreen = new GameConfig();
        gameConfigScreen.start(stage);
    }

    public void endGame() throws Exception {
        Stage stage;
        stage = newStage;
        EndGame endGameScreen = new EndGame();
        endGameScreen.start(stage);
    }

}