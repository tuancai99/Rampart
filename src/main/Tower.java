package main;
import java.util.*;
import javafx.scene.image.ImageView;

public abstract class Tower {
    protected int price;
    protected double xVal;
    protected double yVal;
    protected double dps;
    protected static int playerLevel;
    protected ImageView imageView = new ImageView();

    protected ArrayList<Enemy> proximity;

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

    public void setProximity(ArrayList<Enemy> proximity) {
        this.proximity = proximity;
    }
    public ArrayList<Enemy> getProximity() {
        return this.proximity;
    }

    public double distCalculator(Tower currTower, Enemy currEnemy) {
        // if enemy or tower doesn't exist then ret null
        if (currTower == null || currEnemy == null) {
            return -1;
        }
        // else calculate the distance between the two objects
        double xT = currTower.getXVal();
        double yT = currTower.getYVal();
        double xE = currEnemy.getXVal();
        double yE = currEnemy.getYVal();

        double vertical = Math.abs(yE - yT);
        double horizontal = Math.abs(xE - xT);

        return Math.hypot(vertical, horizontal);
    }

    public Enemy pickEnemy(Tower currTower, ArrayList<Enemy> proximity) {
        // if tower or enemies in its proximity doesn't exist then ret null

        // else if there is no enemies in its proximity then no enemies is picked = ret null
//        ******************************************************************************************
//        if ((currTower == null) || (proximity == null)) {
//            return null;
//        } else if (proximity.length == 0) {
//            return null;
//        }
//        // else find the nearest
//        double[] distanceMap = new double[proximity.length];
//        for (int i = 0; i < proximity.length; i++) {
//            distanceMap[i] = distCalculator(currTower, proximity[i]);
//        }
//        double nearestDistance = Double.POSITIVE_INFINITY;
//        int atIndex = 0;
//        for (int i = 0; i < distanceMap.length; i++) {
//            if (distanceMap[i] < nearestDistance) {
//                nearestDistance = distanceMap[i];
//                atIndex = i;
//            }
//        }
//        return proximity[atIndex];
//        ******************************************************************************************
        if ((currTower == null) || (proximity == null)) {
            return null;
        } else if (proximity.size() == 0) {
            return null;
        }
        // else find the nearest
        double[] distanceMap = new double[proximity.size()];
        for (int i = 0; i < proximity.size(); i++) {
            if (distCalculator(currTower, proximity.get(i)) != -1) {
                distanceMap[i] = distCalculator(currTower, proximity.get(i));
            } else {
                distanceMap[i] = Double.POSITIVE_INFINITY;
            }
        }
        double nearestDistance = Double.POSITIVE_INFINITY;
        int atIndex = 0;
        for (int i = 0; i < distanceMap.length; i++) {
            if (distanceMap[i] < nearestDistance) {
                nearestDistance = distanceMap[i];
                atIndex = i;
            }
        }
        return proximity.get(atIndex);
    }

    public void damageHealth(Tower currTower, ArrayList<Enemy> proximity) {
        Enemy currEnemy =  pickEnemy(currTower, proximity);
        if (currEnemy == null) {
            return;
        } else if (currEnemy.getHealth() - getDPS() <= 0) {
            // if health of Enemy < 0 after this damage erase the E
            // from the proximity arrayList of tower
            this.proximity.remove(currEnemy);
        } else {
            currEnemy.setHealth(currEnemy.getHealth() - getDPS());
        }
    }
    abstract void attack();
}