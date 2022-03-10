import javafx.scene.image.ImageView;

public abstract class Tower {
    protected int price;
    protected int xVal;
    protected int yVal;
    protected double dps;
    protected static int playerLevel;

    void setPrice(int p) {
        price = p;
    }
    int getPrice() {
        return price;
    }
    void setXVal(int x) {
        xVal = x;
    }
    int getXVal() {
        return xVal;
    }
    void setYVal(int y) {
        yVal = y;
    }
    int getYVal() {
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
	abstract ImageView draw();
}