package main;

import java.util.ArrayList;

public class Map {
    private static int round;
    private static ArrayList<Tower> towersPlaced = new ArrayList<>();

    public static void setRound(int r) {
        round = r;
    }
    public static int getRound() {
        return round;
    }

    public static void setTowersPlaced(Tower t) {
        towersPlaced.add(t);
    }
    public static ArrayList<Tower> getTowersPlaced() {
        return towersPlaced;
    }
}
