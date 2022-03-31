package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy1 extends Enemy {
    private Image sprite = new Image("/Images/Yellow.png");
    public Enemy1() {
        classification = "Yellow";
        health = 50;
        walkingSpeed = 10;
        dps = 50;
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