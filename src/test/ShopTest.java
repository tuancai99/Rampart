package test;
import javafx.application.Application;
import main.*;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShopTest {
    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        // Initialise Java FX
        Thread t = new Thread("JavaFX Shop Thread") {
            public void run() {
                Application.launch(Shop.class);
            }
        };
        t.setDaemon(true);
        t.start();
        Thread.sleep(500);
    }

    @Test
    public void checkPurchaseTower1() {
        Shop myShop = new Shop();
        PlayerConfig.startingMoney(1);
        int startingMoney = Player.getMoney();

        Tower.setLevel(1);
        Tower myTow = new Tower1();

        myShop.purchaseTower(myTow);
        assertEquals(Player.getMoney(), (startingMoney - myTow.getPrice()));
    }

    @Test
    public void checkPurchaseTower2() {
        Shop myShop = new Shop();
        PlayerConfig.startingMoney(1);
        int startingMoney = Player.getMoney();

        Tower.setLevel(1);
        Tower myTow = new Tower2();

        myShop.purchaseTower(myTow);
        assertEquals(Player.getMoney(), (startingMoney - myTow.getPrice()));
    }

    @Test
    public void checkPurchaseTower3() {
        Shop myShop = new Shop();
        PlayerConfig.startingMoney(1);
        int startingMoney = Player.getMoney();

        Tower.setLevel(1);
        Tower myTow = new Tower3();

        myShop.purchaseTower(myTow);
        assertEquals(Player.getMoney(), (startingMoney - myTow.getPrice()));
    }
    
    @Test
    public void checkSameLevelDifTowerMoneyChange() {
        Shop myShop = new Shop();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTow1 = new Tower1();
        myShop.purchaseTower(myTow1);
        int t1MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTow2 = new Tower2();
        myShop.purchaseTower(myTow2);
        int t2MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTow3 = new Tower3();
        myShop.purchaseTower(myTow3);
        int t3MoneyLeft = Player.getMoney();

        assertTrue(t1MoneyLeft != t2MoneyLeft);
        assertTrue(t1MoneyLeft != t3MoneyLeft);
        assertTrue(t2MoneyLeft != t3MoneyLeft);
    }

    @Test
    public void checkDifLevelSameTowerMoneyChange() {
        Shop myShop = new Shop();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTowLev1 = new Tower1();
        myShop.purchaseTower(myTowLev1);
        int l1MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(2);
        Tower myTowLev2 = new Tower1();
        myShop.purchaseTower(myTowLev2);
        int l2MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(3);
        Tower myTowLev3 = new Tower1();
        myShop.purchaseTower(myTowLev3);
        int l3MoneyLeft = Player.getMoney();

        assertTrue(l1MoneyLeft != l2MoneyLeft);
        assertTrue(l1MoneyLeft != l3MoneyLeft);
        assertTrue(l2MoneyLeft != l3MoneyLeft);
    }
}