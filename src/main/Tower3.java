package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower3 extends Tower {
    private Image sprite = new Image("/Images/pinkTower.png");
    public Tower3() {
        price = 60 * playerLevel;
        dps = 6 - (0.4 * (playerLevel - 1));
    }
    public ImageView draw() {
        imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitHeight(75);
        imageView.setFitWidth(75);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }
    public void attack() {
        damageHealth(this, getProximity());
    }
}