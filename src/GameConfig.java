import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.animation.AnimationTimer;

public class GameConfig extends Application {
    private Button beginBtn;
    private Button endBtn;
    /**
     * Game screen using Javafx
     * @param stage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage stage) throws Exception {


        Image image = new Image("/Images/Game.png");

        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(600);
        imageView.setFitWidth(800);

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


        Group root = new Group(imageView, text, text2, beginBtn, endBtn);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                text.setText("MONEY: " + String.valueOf(Player.getMoney()));
                text2.setText("HEALTH: " + String.valueOf(Base.getHealth()) + "hp");
            }
        }.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void pressStartRoundBtn() throws Exception {
        Stage stage;

        stage = (Stage) beginBtn.getScene().getWindow();
        GameStart GameRoundStart = new GameStart();
        GameRoundStart.start(stage);

    }

    public void pressEndBtn() throws Exception {
        Stage stage;

        stage = (Stage) endBtn.getScene().getWindow();
        stage.close();

    }

}