import javafx.scene.image.ImageView;

public abstract class Tower {
    protected int price;
    protected double xVal;
    protected double yVal;
    protected double dps;
    protected static int playerLevel;
    protected ImageView imageView;

    void setPrice(int p) {
        price = p;
    }
    int getPrice() {
        return price;
    }
    void setXVal(double x) {
        xVal = x;
    }
    double getXVal() {
        return xVal;
    }
    void setYVal(double y) {
        yVal = y;
    }
    double getYVal() {
        return yVal;
    }
    void setDPS(int d) {
        dps = d;
    }
    double getDPS() {
        return dps;
    }
    public static void setLevel(int l) {
        playerLevel = l;
    }
    public static int getLevel() {
        return playerLevel;
    }
    ImageView getImageView() {
        return imageView;
    }
    void setImageView(ImageView i) {
        imageView = i;
    }
    abstract ImageView draw();
}