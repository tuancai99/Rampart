package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy2 extends Enemy {
    private Image sprite = new Image("/Images/Green.png");
    public Enemy2(double x, double y) {
        classification = "Green";
        health = 60;
        walkingSpeed = 2.25;
        dps = 60;
        xVal = x;
        yVal = y;
    }
    public ImageView draw() {
        imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }
}
