import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Button backBtn;
    private ArrayList<Tower> currentTowers;
    private static Tower newTower;
    private ImageView tempTower;

    @Override
    public void start(Stage stage) throws Exception {
        currentTowers = Player.getTowersOwned();
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
        text.setX(900);
        text.setY(130);
        text.setText(moneyStr);

        Text text2 = new Text();
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        text2.setX(300);
        text2.setY(100);
        text2.setText("Place Your Tower");

        Text text3 = new Text();
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text3.setX(900);
        text3.setY(65);
        text3.setText(healthStr);

        Font f1 = Font.font("Comic Sans MS", FontWeight.BOLD, 20);
        placeBtn = new Button("Place Tower");
        placeBtn.setFont(f1);
        placeBtn.setLayoutX(50);
        placeBtn.setLayoutY(50);
        placeBtn.setPrefWidth(150);
        placeBtn.setPrefHeight(60);
        placeBtn.setOnAction(event -> {
            try {
                pressPlaceBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        backBtn = new Button("Go Back");
        backBtn.setFont(f1);
        backBtn.setLayoutX(1250);
        backBtn.setLayoutY(50);
        backBtn.setPrefWidth(150);
        backBtn.setPrefHeight(60);
        backBtn.setOnAction(event -> {
            try {
                pressBackBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        newTower.setXVal(0);
        newTower.setYVal(0);
        tempTower = newTower.draw();
        double[] delta = {0, 0};
        tempTower.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                delta[0] = tempTower.getX() - mouseEvent.getScreenX();
                delta[1] = tempTower.getY() - mouseEvent.getScreenY();
            }
        });
        tempTower.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                tempTower.setX(mouseEvent.getScreenX() + delta[0]);
                tempTower.setY(mouseEvent.getScreenY() + delta[1]);
            }
        });
        tempTower.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tempTower.setX(mouseEvent.getScreenX() + delta[0]);
                tempTower.setY(mouseEvent.getScreenY() + delta[1]);
                newTower.setXVal(mouseEvent.getScreenX() + delta[0]);
                newTower.setYVal(mouseEvent.getScreenY() + delta[1]);
            }
        });

        Group root = new Group(imageView, text, text2, text3, placeBtn, backBtn, tempTower);
        if (currentTowers != null) {
            for (int i = 0; i < currentTowers.size(); i++) {
                Tower curr = currentTowers.get(i);
                root.getChildren().add(curr.getImageView());
            }
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.setX(0);
        stage.setY(0);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void pressPlaceBtn() throws Exception {
        boolean canPlace = true;
        currentTowers = Player.getTowersOwned();
        if (currentTowers != null) {
            for (int i = 0; i < currentTowers.size(); i++) {
                if (tempTower.intersects(currentTowers.get(i).getImageView().getBoundsInLocal())) {
                    canPlace = false;
                }
            }
        }
        if (!canPlace) {
            Alert myAlert = new Alert(Alert.AlertType.ERROR);
            myAlert.setHeaderText("Tower cannot be place there.");
            myAlert.showAndWait();
        } else {
            Player.setTowersOwned(newTower);
            Stage stage;
            stage = (Stage) placeBtn.getScene().getWindow();
            GameConfig gameConfig = new GameConfig();
            gameConfig.start(stage);
        }

    }

    public void pressBackBtn() throws Exception {
        Stage myStage;
        myStage = (Stage) backBtn.getScene().getWindow();
        Shop shop = new Shop();
        shop.start(myStage);
    }

    public static void setNewTower(Tower nT) {
        newTower = nT;
    }


}
