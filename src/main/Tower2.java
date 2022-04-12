package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower2 extends Tower {
    private Image sprite = new Image("/Images/yellowTower.png");
    public Tower2() {
        price = 30 * playerLevel;
        dps = 2.5 - (0.4 * (playerLevel - 1));
    }
    public ImageView draw() {
        imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }
    public void attack() {
        damageHealth(this, getProximity());
    }
}