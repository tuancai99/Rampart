package test;

import javafx.application.Application;
import main.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

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

    /* M5 - Checks enemyInProximity returns the right result for Enemy1.
    Proximity is a radius of 130 for all Towers.
    If the boolean value returned is False, then the enemy is not in the Tower's
    proximity. If True, the enemy is in the Tower's proximity and can be attacked.
    */
    @Test
    public void testEnemy1InProximity() {
        Tower t1 = new Tower1();
        t1.setXVal(10);
        t1.setYVal(10);
        Boolean isEnemyInProximity;

        Enemy e1 = new Enemy1(30, 30);
        isEnemyInProximity = t1.enemyInProximity(e1);
        assertTrue(isEnemyInProximity);

        Enemy e2 = new Enemy1(200, 200);
        isEnemyInProximity = t1.enemyInProximity(e2);
        assertFalse(isEnemyInProximity);
    }

    /* M5 - Checks enemyInProximity returns the right result for Enemy2.
    Proximity is a radius of 130 for all Towers.
    If the boolean value returned is False, then the enemy is not in the Tower's
    proximity. If True, the enemy is in the Tower's proximity and can be attacked.
    */
    @Test
    public void testEnemy2InProximity() {
        Tower t1 = new Tower1();
        t1.setXVal(10);
        t1.setYVal(10);
        Boolean isEnemyInProximity;

        Enemy e1 = new Enemy2(40, 40);
        isEnemyInProximity = t1.enemyInProximity(e1);
        assertTrue(isEnemyInProximity);

        Enemy e2 = new Enemy2(300, 300);
        isEnemyInProximity = t1.enemyInProximity(e2);
        assertFalse(isEnemyInProximity);
    }

    /* M5 - Checks enemyInProximity returns the right result for Enemy3.
    Proximity is a radius of 130 for all Towers.
    If the boolean value returned is False, then the enemy is not in the Tower's
    proximity. If True, the enemy is in the Tower's proximity and can be attacked.
    */
    @Test
    public void testEnemy3InProximity() {
        Tower t1 = new Tower1();
        t1.setXVal(10);
        t1.setYVal(10);
        Boolean isEnemyInProximity;

        Enemy e1 = new Enemy3(20, 20);
        isEnemyInProximity = t1.enemyInProximity(e1);
        assertTrue(isEnemyInProximity);

        Enemy e2 = new Enemy3(150, 150);
        isEnemyInProximity = t1.enemyInProximity(e2);
        assertFalse(isEnemyInProximity);

    }

    /*M5
    Checks if Tower1 does damage correctly to Enemy1 type Enemy
    */
    @Test
    public void testTower1AttackEnemy1() {
        Tower t1 = new Tower1();
        Enemy e1 = new Enemy1(52, 52);
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

    /*M5
    Checks if Tower1 does damage correctly to Enemy2 type Enemy
    */
    @Test
    public void testTower1AttackEnemy2() {
        Tower t1 = new Tower1();
        Enemy e2 = new Enemy2(52, 52);
        e2.draw();

        double originalHealth = e2.getHealth();

        t1.setXVal(50);
        t1.setYVal(50);
        t1.createAttackObject(e2);

        boolean attacked;
        attacked = t1.attackEnemy(e2);

        assertEquals(attacked, true);
        assertEquals(e2.getHealth(), originalHealth - t1.getDPS(), 0);
    }

    /*M5
    Checks if Tower1 does damage correctly to Enemy3 type Enemy
    */
    @Test
    public void testTower1AttackEnemy3() {
        Tower t1 = new Tower1();
        Enemy e3 = new Enemy3(52, 52);
        e3.draw();

        double originalHealth = e3.getHealth();

        t1.setXVal(50);
        t1.setYVal(50);
        t1.createAttackObject(e3);

        boolean attacked;
        attacked = t1.attackEnemy(e3);

        assertEquals(attacked, true);
        assertEquals(e3.getHealth(), originalHealth - t1.getDPS(), 0);
    }

    /* M5
    Checks to see if Tower2 does damage to Enemy1 and heals the base
    */
    @Test
    public void testTower2AttackEnemy1() {
        Tower t2 = new Tower2();
        Enemy e1 = new Enemy1(52, 52);
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
    Checks to see if Tower2 does damage to Enemy2 and heals the base
    */
    @Test
    public void testTower2AttackEnemy2() {
        Tower t2 = new Tower2();
        Enemy e2 = new Enemy2(52, 52);
        e2.draw();

        double originalEnemyHealth = e2.getHealth();
        double originalBaseHealth = Base.getHealth();

        t2.setXVal(50);
        t2.setYVal(50);
        t2.createAttackObject(e2);

        boolean attacked;
        attacked = t2.attackEnemy(e2);

        assertEquals(attacked, true);
        assertEquals(e2.getHealth(), originalEnemyHealth - t2.getDPS(), 0);
        assertEquals(Base.getHealth(), originalBaseHealth + 0.03, 0);
    }

    /* M5
    Checks to see if Tower2 does damage to Enemy3 and heals the base
    */
    @Test
    public void testTower2AttackEnemy3() {
        Tower t2 = new Tower2();
        Enemy e3 = new Enemy3(52, 52);
        e3.draw();

        double originalEnemyHealth = e3.getHealth();
        double originalBaseHealth = Base.getHealth();

        t2.setXVal(50);
        t2.setYVal(50);
        t2.createAttackObject(e3);

        boolean attacked;
        attacked = t2.attackEnemy(e3);

        assertEquals(attacked, true);
        assertEquals(e3.getHealth(), originalEnemyHealth - t2.getDPS(), 0);
        assertEquals(Base.getHealth(), originalBaseHealth + 0.03, 0);
    }

    /* M5
    Checks to see if Tower3 does damage to Enemy1 and increases money
    for every 20 times Tower3 successfully attacks Enemy1
    */
    @Test
    public void testTower3AttackEnemy1() {
        Tower t3 = new Tower3();
        Enemy e1 = new Enemy1(52, 52);
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

    /* M5
    Checks to see if Tower3 does damage to Enemy2 and increases money
    for every 20 times Tower3 successfully attacks Enemy2
    */
    @Test
    public void testTower3AttackEnemy2() {
        Tower t3 = new Tower3();
        Enemy e2 = new Enemy2(52, 52);
        e2.draw();

        double originalHealth = e2.getHealth();
        double originalMoney = Player.getMoney();

        t3.setXVal(50);
        t3.setYVal(50);
        t3.createAttackObject(e2);

        boolean attacked;
        attacked = t3.attackEnemy(e2);

        assertEquals(attacked, true);
        assertEquals(e2.getHealth(), originalHealth - t3.getDPS(), 0);

        int i = 2;
        while (i <= 20) {
            attacked = t3.attackEnemy(e2);
            i++;
        }

        assertEquals(attacked, true);
        assertEquals(e2.getHealth(), originalHealth - (t3.getDPS() * 20), .000001);
        assertEquals(Player.getMoney(), originalMoney + 1, 0);
    }

    /* M5
    Checks to see if Tower3 does damage to Enemy3 and increases money
    for every 20 times Tower3 successfully attacks Enemy3
    */
    @Test
    public void testTower3AttackEnemy3() {
        Tower t3 = new Tower3();
        Enemy e3 = new Enemy3(52, 52);
        e3.draw();

        double originalHealth = e3.getHealth();
        double originalMoney = Player.getMoney();

        t3.setXVal(50);
        t3.setYVal(50);
        t3.createAttackObject(e3);

        boolean attacked;
        attacked = t3.attackEnemy(e3);

        assertEquals(attacked, true);
        assertEquals(e3.getHealth(), originalHealth - t3.getDPS(), 0);

        int i = 2;
        while (i <= 20) {
            attacked = t3.attackEnemy(e3);
            i++;
        }

        assertEquals(attacked, true);
        assertEquals(e3.getHealth(), originalHealth - (t3.getDPS() * 20), .000001);
        assertEquals(Player.getMoney(), originalMoney + 1, 0);
    }
}