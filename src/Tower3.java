import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower3 extends Tower {
    private Image sprite = new Image("/Images/blueTower.png");
    public Tower3() {
        price = 70 * playerLevel;
        dps = 6 - (0.4 * (playerLevel - 1));
    }
    public ImageView draw() {
        ImageView imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setX(xVal);
        imageView.setY(yVal);
        return imageView;
    }
}