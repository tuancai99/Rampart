package test;
import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShopTest {

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
        int T1MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTow2 = new Tower2();
        myShop.purchaseTower(myTow2);
        int T2MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTow3 = new Tower3();
        myShop.purchaseTower(myTow3);
        int T3MoneyLeft = Player.getMoney();

        assertTrue(T1MoneyLeft != T2MoneyLeft);
        assertTrue(T1MoneyLeft != T3MoneyLeft);
        assertTrue(T2MoneyLeft != T3MoneyLeft);
    }

    @Test
    public void checkDifLevelSameTowerMoneyChange() {
        Shop myShop = new Shop();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(1);
        Tower myTowLev1 = new Tower1();
        myShop.purchaseTower(myTowLev1);
        int L1MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(2);
        Tower myTowLev2 = new Tower1();
        myShop.purchaseTower(myTowLev2);
        int L2MoneyLeft = Player.getMoney();

        PlayerConfig.startingMoney(1);
        Tower.setLevel(3);
        Tower myTowLev3 = new Tower1();
        myShop.purchaseTower(myTowLev3);
        int L3MoneyLeft = Player.getMoney();

        assertTrue(L1MoneyLeft != L2MoneyLeft);
        assertTrue(L1MoneyLeft != L3MoneyLeft);
        assertTrue(L2MoneyLeft != L3MoneyLeft);
    }
}