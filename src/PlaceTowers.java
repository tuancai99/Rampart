import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PlaceTowers extends Application {
    private Button placeBtn;
    private ArrayList<Tower> currentTowers;
    private ArrayList<Tower> newTowers;
    private Boolean isPlaced;

    @Override
    public void start(Stage stage, ArrayList<Tower> newList) throws Exception {
        currentTowers = currList;
        newTowers = newList;
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
        placeBtn = new Button("Start Round");
        placeBtn.setFont(f1);
        placeBtn.setLayoutX(230);
        placeBtn.setLayoutY(18);
        placeBtn.setPrefWidth(100);
        placeBtn.setPrefHeight(35);
        placeBtn.setOnAction(event -> {
            try {
                pressPlaceBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Group root = new Group(imageView, text, text2, placeBtn);

        for (int i = 0; i < currentTowers.size(); i++) {
            Tower curr = currentTowers.get(i);
            root.getChildren().add(curr.draw());
        }

        Tower newCurr = newTowers.get(0);
        newCurr.setXVal(0);
        newCurr.setYVal(0);
        root.getChildren().add(newCurr.draw());

        // need to have drag and drop implemented here

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < newTowers.size(); i++) {
                    Tower curr = newTowers.get(i);
                    ImageView temp = curr.draw();
                    double[] delta = {0,0};
                    temp.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent mouseEvent) {
                            // record a delta distance for the drag and drop operation.
                            delta[0] = temp.getX() - mouseEvent.getScreenX();
                            delta[1] = temp.getY() - mouseEvent.getScreenY();
                        }
                    });
                    temp.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent mouseEvent) {
                            temp.setX(mouseEvent.getScreenX() + delta[0]);
                            temp.setY(mouseEvent.getScreenY() + delta[1]);
                        }
                    });
                    root.getChildren().add(temp);
                    isPlaced = false;
                    while(!isPlaced) {

                        isPlaced = true;
                    }
                }
            }
        }.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void pressPlaceBtn() throws Exception {


    }


}
