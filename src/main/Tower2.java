package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class Tower2 extends Tower {
    private Image sprite = new Image("/Images/yellowTower.png");
    public Tower2() {
        price = 35 * playerLevel;
        dps = ((6 - (0.4 * (playerLevel - 1))))/2;
    }

    
    public Line attack(Enemy e) {
        Line l = new Line(this.getXVal(), this.getYVal(), e.getXVal(), e.getYVal());
        e.setHealth(e.getHealth() - this.getDPS());
        Base.setHealth(Base.getHealth() + this.getDPS());
        return l;
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
}