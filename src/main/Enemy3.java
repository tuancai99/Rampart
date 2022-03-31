package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy3 extends Enemy {
    private Image sprite = new Image("/Images/Pink.png");
    public Enemy3() {
        classification = "Pink";
        health = 70;
        walkingSpeed = 10;
        dps = 70;
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
