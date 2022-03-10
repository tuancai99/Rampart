import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower1 extends Tower {
    private Image sprite = new Image("/Images/yellowTower.png");
    public Tower1() {
        price = 10 * playerLevel;
        dps = 0.75 - (0.4 * (playerLevel - 1));
    }
    public ImageView draw() {
        ImageView imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }
}