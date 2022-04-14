package test;

import javafx.application.Application;
import main.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TowerTest {
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

    /* M5 - Checks distanceCalculator returns the right result.
    If the boolean value returned is False, then the distance returned is not correct.
    The distance yielded by the method should be equal to the actual one.
    */
    @Test
    public void distCalculatorTest() {
        Enemy myEnemy = new Enemy1(20, 20);
        Tower myTow = new Tower1();
        myTow.setXVal(10);
        myTow.setYVal(10);
        assertEquals(myTow.distCalculator(myEnemy), 10 * Math.sqrt(2),
                (Math.abs(myTow.distCalculator(myEnemy) - 10 * Math.sqrt(2))));
    }

    /*M5
    Checks if Tower1 does damage correctly
    */
    @Test
    public void testTower1Attack() {
        Tower t1 = new Tower1();
        Enemy1 e1 = new Enemy1(52, 52);
        e1.draw();

        double originalHealth = e1.getHealth();

        t1.setXVal(50);
        t1.setYVal(50);
        t1.createAttackObject(e1);

        boolean attacked;
        attacked = t1.attackEnemy(e1);

        assertEquals(attacked, true);
        assertEquals(e1.getHealth(), originalHealth - t1.getDPS(), 0);
    }

    /* M5
    Checks to see if Tower2 does damage and heals the base
    */
    @Test
    public void testTower2Attack() {
        Tower t2 = new Tower2();
        Enemy1 e1 = new Enemy1(52, 52);
        e1.draw();

        double originalEnemyHealth = e1.getHealth();
        double originalBaseHealth = Base.getHealth();

        t2.setXVal(50);
        t2.setYVal(50);
        t2.createAttackObject(e1);

        boolean attacked;
        attacked = t2.attackEnemy(e1);

        assertEquals(attacked, true);
        assertEquals(e1.getHealth(), originalEnemyHealth - t2.getDPS(), 0);
        assertEquals(Base.getHealth(), originalBaseHealth + 0.03, 0);
    }

    /* M5
    Checks to see if Tower3 does damage and increases money
    */
    @Test
    public void testTower3Attack() {
        Tower t3 = new Tower3();
        Enemy1 e1 = new Enemy1(52, 52);
        e1.draw();

        double originalHealth = e1.getHealth();
        double originalMoney = Player.getMoney();

        t3.setXVal(50);
        t3.setYVal(50);
        t3.createAttackObject(e1);

        boolean attacked;
        attacked = t3.attackEnemy(e1);

        assertEquals(attacked, true);
        assertEquals(e1.getHealth(), originalHealth - t3.getDPS(), 0);

        int i = 2;
        while (i <= 20) {
            attacked = t3.attackEnemy(e1);
            i++;
        }

        assertEquals(attacked, true);
        assertEquals(e1.getHealth(), originalHealth - (t3.getDPS() * 20), .000001);
        assertEquals(Player.getMoney(), originalMoney + 1, 0);
    }
}