package main;

public class Upgrade {
    private int upgradePrice;
    private int upgradeLevel;

    public void setUpgradePrice(int u) {
        upgradePrice = u;
    }
    public int getUpgradePrice() {
        return upgradePrice;
    }
    public void setUpgradeLevel(int u) {
        upgradeLevel = u;
    }
    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public Upgrade() {
        upgradeLevel = 0;
        upgradePrice = 30;
    }

    public void upgrade() {
        Player.upgradeTower(upgradePrice);
        upgradePrice *= 2;
        upgradeLevel += 1;
    }
}
