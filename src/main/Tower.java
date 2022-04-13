package main;

import javafx.scene.image.ImageView;

public abstract class Tower {
    protected int price;
    protected double xVal;
    protected double yVal;
    protected double dps;
    protected static int playerLevel;
    protected ImageView imageView = new ImageView();

    abstract Line attack(Enemy e);

    public void setPrice(int p) {
        price = p;
    }
    public int getPrice() {
        return price;
    }
    public void setXVal(double x) {
        xVal = x;
    }
    public double getXVal() {
        return xVal;
    }
    public void setYVal(double y) {
        yVal = y;
    }
    public double getYVal() {
        return yVal;
    }
    public void setDPS(int d) {
        dps = d;
    }
    public double getDPS() {
        return dps;
    }
    public static void setLevel(int l) {
        playerLevel = l;
    }
    public static int getLevel() {
        return playerLevel;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView i) {
        imageView = i;
    }
    abstract ImageView draw();

    public double distCalculator(Enemy cE) {
        if (cE == null) {
            return -1.0;
        }

        double xT = this.getXVal();
        double yT = this.getYVal();
        double xE = cE.getXVal();
        double yE = cE.getYVal();

        double vertical = Math.abs(yE - yT);
        double horizontal = Math.abs(xE - xT);

        return Math.hypot(vertical, horizontal);
    }
}