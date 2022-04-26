package test;

import javafx.application.Application;
import main.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpgradeTest {
    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        // Initialise Java FX
        Thread t = new Thread("JavaFX GameStart Thread") {
            public void run() {
                Application.launch(GameStart.class);
            }
        };
        t.setDaemon(true);
        t.start();
        Thread.sleep(500);
    }

    /* M6
    Checks if Upgrade instance is correctly initialized when Tower1 object is created.
    */
    @Test
    public void testInitializeUpgradeTower1() {
        Tower curr = new Tower1();
        Upgrade currUp = curr.getUpgrade();
        int upgradeLevel = currUp.getUpgradeLevel();
        int upgradePrice = currUp.getUpgradePrice();
        assertEquals(upgradeLevel, 0);
        assertEquals(upgradePrice, 30);
    }

    /* M6
    Checks if Upgrade instance is correctly initialized when Tower2 object is created.
    */
    @Test
    public void testInitializeUpgradeTower2() {
        Tower curr = new Tower2();
        Upgrade currUp = curr.getUpgrade();
        int upgradeLevel = currUp.getUpgradeLevel();
        int upgradePrice = currUp.getUpgradePrice();
        assertEquals(upgradeLevel, 0);
        assertEquals(upgradePrice, 30);
    }

    /* M6
    Checks if Upgrade instance is correctly initialized when Tower3 object is created.
    */
    @Test
    public void testInitializeUpgradeTower3() {
        Tower curr = new Tower3();
        Upgrade currUp = curr.getUpgrade();
        int upgradeLevel = currUp.getUpgradeLevel();
        int upgradePrice = currUp.getUpgradePrice();
        assertEquals(upgradeLevel, 0);
        assertEquals(upgradePrice, 30);
    }

    /* M6
    Checks if the checkInvalidUpgrade() method correctly outputs the string statement
    if player doesn't have enough money to purchase upgrade (money < upgrade price)
    */
    @Test
    public void testCheckInvalidUpgrade() {
        Upgrade upgrade = new Upgrade();
        Player.setMoney(20);
        String check = upgrade.checkInvalidUpgrade();
        assertNotNull(check);
        assertEquals(check, "Not Enough Money. Cannot Purchase Upgrade for Tower.");
    }

    /* M6
    Checks if the checkInvalidUpgrade() method correctly outputs null
    if player has enough money to purchase upgrade (money > upgrade price)
    */
    @Test
    public void testCheckValidUpgrade() {
        Upgrade upgrade = new Upgrade();
        Player.setMoney(60);
        String check = upgrade.checkInvalidUpgrade();
        assertNull(check);
    }

}