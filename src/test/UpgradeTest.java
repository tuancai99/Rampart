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
    Checks if method correctly returns the boolean value false
    if the Base health drops to 0.
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
    Checks if method correctly returns the boolean value false
    if the Base health drops to 0.
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
    Checks if method correctly returns the boolean value false
    if the Base health drops to 0.
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
    Checks if method correctly returns the boolean value false
    if the Base health drops to 0.
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
    Checks if method correctly returns the boolean value false
    if the Base health drops to 0.
    */
    @Test
    public void testCheckValidUpgrade() {
        Upgrade upgrade = new Upgrade();
        Player.setMoney(60);
        String check = upgrade.checkInvalidUpgrade();
        assertNull(check);
    }

}