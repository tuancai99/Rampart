package main;

import javafx.scene.image.ImageView;

public abstract class Enemy {
    protected String classification;
    protected int health;
    protected double dps;
    protected double walkingSpeed;

    protected double xVal;
    protected double yVal;
    protected ImageView imageView = new ImageView();

    protected static int playerLevel;

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
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView i) {
        imageView = i;
    }
    public void attackBase() {
//        if (Base.getHealth() < dps) {
//            // call a method to a pop-up prompt asking player if they want to restart
//        } else {
            Base.setHealth(Base.getHealth() - dps);
//        }
    }
    abstract ImageView draw();
}