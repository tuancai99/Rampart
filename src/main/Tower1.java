package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower1 extends Tower {
    private Image sprite = new Image("/Images/blueTower.png");
    public Tower1() {
        price = 15 * playerLevel;
        dps = 0.75 - (0.4 * (playerLevel - 1));
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