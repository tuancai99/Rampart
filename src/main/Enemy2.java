package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy2 extends Enemy {
    private Image sprite = new Image("/Images/Green.png");
    public Enemy2() {
        classification = "Green";
        health = 60;
        walkingSpeed = 3;
        dps = 60;
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
