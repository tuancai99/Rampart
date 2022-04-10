package main;

import javafx.scene.image.ImageView;

public abstract class Tower {
    protected int price;
    protected double xVal;
    protected double yVal;
    protected double dps;
    protected static int playerLevel;
    protected ImageView imageView = new ImageView();


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
}