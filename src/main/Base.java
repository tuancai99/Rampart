package main;

public class Base {
    private static double health;

    public static void setHealth(double h) {
        if (h >= 0) {
            health = h;
        }
    }
    public static double getHealth() {
        return health;
    }

    public static boolean isBaseHealthy() {
        if (health <= 0) {
            return false;
        }
        return true;
    }
}
