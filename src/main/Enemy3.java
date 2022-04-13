package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy3 extends Enemy {
    private Image sprite = new Image("/Images/Pink.png");
    public Enemy3(double x, double y) {
        classification = "Pink";
        health = 70;
        walkingSpeed = 1.5;
        dps = 70;
        xVal = x;
        yVal = y;
    }
    public ImageView draw() {
        imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }

    static Enemy createEnemy() {
        return new Enemy3(enemyStartX, 295);
    }

}
