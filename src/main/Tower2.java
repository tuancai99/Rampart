package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Tower2 extends Tower {
    private Image sprite = new Image("/Images/yellowTower.png");
    private Line l;
    public Tower2() {
        price = 35 * playerLevel;
        dps = ((6 - (0.4 * (playerLevel - 1))))/2;
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

    public Line createAttackObject(Enemy e) {
        l = new Line(xVal + (75/2), yVal + (75/2), e.getXVal() + (35/2), e.getYVal() + (35/2));
        l.setStrokeWidth(20);
        return l;
    }

    public boolean attackEnemy(Enemy e) {
        if (e.getImageView().intersects(l.getBoundsInLocal())) {
            e.setHealth(e.getHealth() - dps);
            Base.setHealth(Base.getHealth() + (int) (dps * .25));
            return true;
        }
        return false;
    }
}