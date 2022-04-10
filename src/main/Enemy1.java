package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy1 extends Enemy {
    private Image sprite = new Image("/Images/Yellow.png");
    public Enemy1(double x, double y) {
        classification = "Yellow";
        health = 50;
        walkingSpeed = 3;
        dps = 50;
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