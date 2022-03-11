import java.util.ArrayList;

public class Player {
    private static String name;
    private static int level;
    private static int money;
    private static ArrayList<Tower> towersOwned;

    public static void setName(String n) {
        name = n;
    }
    public static String getName() {
        return name;
    }
    public static void setLevel(Integer l) {
        level = l.intValue();
    }
    public static int getLevel() {
        return level;
    }
    public static void setMoney(int m) {
        money = m;
    }
    public static int getMoney() {
        return money;
    }
    public static void setTowersOwned(Tower t) {
        towersOwned.add(t);
    }
    public static ArrayList<Tower> getTowersOwned() {
        return towersOwned;
    }

}