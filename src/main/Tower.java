package main;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;

import java.util.ArrayList;

public abstract class Tower {
    protected int price;
    protected double xVal;
    protected double yVal;
    protected double dps;
    protected static int playerLevel;
    protected ImageView imageView = new ImageView();
    protected static double proximity = 130;

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

    public double getProximity() {
        return proximity;
    }
    public void setProximity(double p) {
        proximity = p;
    }

    abstract ImageView draw();

    public double distCalculator(Enemy e) {
        if (e == null) {
            return -1.0;
        }
        double towerX = xVal;
        double towerY = yVal;
        double enemyX = e.getXVal();
        double enemyY = e.getYVal();

        double changeInY = Math.abs(enemyY - towerY);
        double changeInX = Math.abs(enemyX - towerX);
        // distance formula: sqrt(x^2 + y^2)
        return Math.hypot(changeInY, changeInX);
    }

    public boolean enemyInProximity(Enemy e) {
        if (distCalculator(e) < proximity) {
            return true;
        }
        return false;
    }

    public Enemy closestEnemy(ArrayList<Enemy> currentEnemies) {
        Enemy currE;
        double currDist;
        Enemy closestE = currentEnemies.get(0);
        double smallestDist = distCalculator(closestE);
        for (int c = 1; c < currentEnemies.size(); c++) {
            currE = currentEnemies.get(c);
            currDist = distCalculator(currE);
            if (currDist < smallestDist) {
                smallestDist = currDist;
                closestE = currE;
            }
        }
        return closestE;
    }

    public abstract Node createAttackObject(Enemy e);

    public abstract boolean attackEnemy(Enemy e);
}