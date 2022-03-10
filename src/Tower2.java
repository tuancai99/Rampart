import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower2 extends Tower {
    private Image sprite = new Image("/Images/pinkTower.png");
    public Tower2() {
        price = 30 * playerLevel;
        dps = 2.5 - (0.4 * (playerLevel - 1));
    }
    public ImageView draw() {
        ImageView imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }
}