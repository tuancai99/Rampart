package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.event.EventHandler;

public class PlayerConfig extends Application {
    private TextField charName;
    private ComboBox<Integer> dif;
    private Button beginBtn;

    /**
     * Player Configuration screen using Javafx
     * @param theStage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage theStage) throws Exception {
        charName = new TextField("Enter your name!");
        beginBtn = new Button("Begin Game!");
        Font f1 = Font.font("Comic Sans MS", FontWeight.BOLD, 25);
        beginBtn.setFont(f1);
        beginBtn.setLayoutX(310);
        beginBtn.setLayoutY(350);
        beginBtn.setPrefWidth(200);
        beginBtn.setPrefHeight(90);
        beginBtn.setOnAction(new PostHandler());

        Font f2 = Font.font("Comic Sans MS", FontWeight.BOLD, 20);
        Font f3 = Font.font("Comic Sans MS", FontWeight.BOLD, 50);
        Text t1 = new Text(480, 240, "Choose your difficulty:");
        t1.setFont(f2);
        Text t2 = new Text(160, 100, "Player Configuration!");
        t2.setFont(f3);
        Text t3 = new Text(150, 240, "Name:");
        t3.setFont(f2);

        ComboBox c = new ComboBox<Integer>();
        c.getItems().addAll(1, 2, 3);
        c.setPrefWidth(210);
        c.setPrefHeight(20);
        c.setLayoutX(480);
        c.setLayoutY(250);
        dif = c;

        charName.setLayoutX(150);
        charName.setLayoutY(250);
        Image back = new Image("/Images/welcome.jpeg");
        BackgroundImage bi = new BackgroundImage(back, null, null, null, null);
        Background fin = new Background(bi);

        Pane pane = new Pane();
        pane.setPrefSize(800, 600);
        pane.getChildren().addAll(charName, beginBtn, c, t3, t2, t1);
        pane.setBackground(fin);
        Scene scene = new Scene(pane);
        theStage.setTitle("Game Config");
        theStage.setScene(scene);
        theStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void startingMoney(Integer i) {
        int money = 0;
        if (i.equals(1)) {
            money = 2000;
        } else if (i.equals(2)) {
            money = 1500;
        } else {
            money = 1000;
        }
        Player.setMoney(money);
    }

    public static void startingHealth(Integer i) {
        int health = 0;
        if (i.equals(1)) {
            health = 500;
        } else if (i.equals(2)) {
            health = 400;
        } else {
            health = 300;
        }
        Base.setHealth(health);
    }

    public static String checkName(String name) {
        String invalid = null;
        if (name.isEmpty()
                || (name.trim().length() == 0)
                || (name == null)) {
            invalid = "Invalid name";
        } else if ((name.equals("Enter your name!"))) {
            invalid = "Please enter your name";
        }
        return invalid;
    }

    public static String checkDifficulty(Integer dif) {
        String invalid = null;
        if (dif == null) {
            invalid = "Must choose a difficulty";
        }
        return invalid;
    }

    public class PostHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Alert myAlert = new Alert(Alert.AlertType.ERROR);
            String invalidName = checkName(charName.getText());
            String invalidDiff = checkDifficulty(dif.getValue());
            if (invalidName != null) {
                myAlert.setHeaderText(invalidName);
                myAlert.showAndWait();
            } else if (invalidDiff != null) {
                myAlert.setHeaderText(invalidDiff);
                myAlert.showAndWait();
            } else {
                Player.setName(charName.getText());
                Player.setLevel(dif.getValue());
                Tower.setLevel(dif.getValue());
                startingMoney(dif.getValue());
                startingHealth(dif.getValue());
                Stage myStage;
                myStage = (Stage) beginBtn.getScene().getWindow();
                GameConfig gameConfigScreen = new GameConfig();
                try {
                    gameConfigScreen.start(myStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
