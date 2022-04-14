package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Tower1 extends Tower {
    private Image sprite = new Image("/Images/blueTower.png");
    private Circle c;
    public Tower1() {
        price = 30 * playerLevel;
        dps = (6 - (0.4 * (playerLevel - 1)));
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

    public Circle createAttackObject(Enemy e) {
        c = new Circle(xVal + (75/2), yVal + (75/2), 8, Color.BLUE);
        return c;
    }

    public boolean attackEnemy(Enemy e) {
        if (e.getImageView().intersects(c.getBoundsInLocal())) {
            e.setHealth(e.getHealth() - dps);
            return true;
        }
        return false;
    }
}