package test;

import javafx.application.Application;
import main.*;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStartTest {
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

    /* M4
       Checks to see that Enemy1 attacks Base/decrements health by correct value
    */
    @Test
    public void testEnemy1AttackBase() {
        Enemy e1 = new Enemy1();
        double orgHealth = 100;
        double e1Dps = e1.getDPS();
        Base.setHealth(orgHealth);
        e1.attackBase();
        assertEquals((orgHealth - e1Dps), Base.getHealth(), 0);
        e1.attackBase();
        assertEquals((orgHealth - 2 * e1Dps), Base.getHealth(), 0);
    }

    /* M4
       Checks to see that Enemy2 attacks Base/decrements health by correct value
     */
    @Test
    public void testEnemy2AttackBase() {
        Enemy e2 = new Enemy2();
        double orgHealth = 200;
        double e2Dps = e2.getDPS();
        Base.setHealth(orgHealth);
        e2.attackBase();
        assertEquals((orgHealth - e2Dps), Base.getHealth(), 0);
        e2.attackBase();
        assertEquals((orgHealth - 2 * e2Dps), Base.getHealth(), 0);
    }

    /* M4
       Checks to see that Enemy3 attacks Base/decrements health by correct value
     */
    @Test
    public void testEnemy3AttackBase() {
        Enemy e3 = new Enemy3();
        double orgHealth = 300;
        double e3Dps = e3.getDPS();
        Base.setHealth(orgHealth);
        e3.attackBase();
        assertEquals((orgHealth - e3Dps), Base.getHealth(), 0);
        e3.attackBase();
        assertEquals((orgHealth - 2 * e3Dps), Base.getHealth(), 0);
    }

    /* M4
       Checks to see that different enemies cause
       health to decrement by different values
     */
    @Test
    public void testEnemyAttackBaseDifferently() {
        Enemy e1 = new Enemy1();
        Enemy e2 = new Enemy2();
        Enemy e3 = new Enemy3();

        double e1Dps = e1.getDPS();
        double e2Dps = e2.getDPS();
        double e3Dps = e3.getDPS();
        assertNotEquals(e1Dps, e2Dps, 0);
        assertNotEquals(e1Dps, e3Dps, 0);
        assertNotEquals(e2Dps, e3Dps, 0);

        // enemy1 attack's remaining health
        double orgHealth = 100;
        Base.setHealth(orgHealth);
        e1.attackBase();
        double enemy1AttackRemainHP = Base.getHealth();
        // enemy2 attack's remaining health
        Base.setHealth(orgHealth);
        e2.attackBase();
        double enemy2AttackRemainHP = Base.getHealth();
        // enemy3 attack's remaining health
        Base.setHealth(orgHealth);
        e3.attackBase();
        double enemy3AttackRemainHP = Base.getHealth();

        assertNotEquals(enemy1AttackRemainHP, enemy2AttackRemainHP, 0);
        assertNotEquals(enemy1AttackRemainHP, enemy3AttackRemainHP, 0);
        assertNotEquals(enemy2AttackRemainHP, enemy3AttackRemainHP, 0);

    }

    /* M4
       Testing createEnemy() method to see if it
       creates the right enemy following the order
     */
    @Test
    public void testCreateEnemy1() {
        GameStart myGame = new GameStart();

        Enemy e1 = new Enemy1();
        ((Enemy1) e1).draw();
        e1.setXVal(1180);
        e1.setYVal(270);

        Enemy e1test = myGame.createEnemy(0);
        assertEquals(e1.getXVal(), e1test.getXVal(), 0);
        assertEquals(e1.getYVal(), e1test.getYVal(), 0);

    }
    @Test
    public void testCreateEnemy2() {
        GameStart myGame = new GameStart();

        Enemy e2 = new Enemy2();

        ((Enemy2) e2).draw();
        e2.setXVal(1180);
        e2.setYVal(270);

        Enemy e2test = myGame.createEnemy(1);
        assertEquals(e2.getXVal(), e2test.getXVal(), 0);
        assertEquals(e2.getYVal(), e2test.getYVal(), 0);
    }
    @Test
    public void testCreateEnemy3() {
        GameStart myGame = new GameStart();

        Enemy e3 = new Enemy3();

        ((Enemy3) e3).draw();
        e3.setXVal(1180);
        e3.setYVal(270);

        Enemy e3test = myGame.createEnemy(2);
        assertEquals(e3.getXVal(), e3test.getXVal(), 0);
        assertEquals(e3.getYVal(), e3test.getYVal(), 0);
    }

    @Test
    public void testEnemyHealth () {
        Enemy e1 = new Enemy1();
        Enemy e2 = new Enemy2();
        Enemy e3 = new Enemy3();

        assertNotEquals(e1.getHealth(),e2.getHealth());
        assertNotEquals(e2.getHealth(),e3.getHealth());
        assertNotEquals(e1.getHealth(),e3.getHealth());

    }

    /*M4
    Checks if enemies walk correctly.
    Creates 3 enemies: One neir the top right of the map, one near the center, and one near the base.
    Checks if:
    The enemy near the top right walks to the left
    The enemy near the center walks downwards
    The enemy near the base disappears.
    */
    public void testEnemyWalk() {
        ArrayList<Enemy> list_of_enemies = new ArrayList<Enemy>();
        Enemy1 e1 = new Enemy1();
        e1.setXVal(1100);
        e1.setYVal(250);
        list_of_enemies.add(e1);
        Enemy1 e2 = new Enemy1();
        e2.setXVal(600);
        e2.setYVal(500);
        list_of_enemies.add(e2);
        Enemy1 e3 = new Enemy1();
        e3.setXVal(150);
        e3.setYVal(500);
        list_of_enemies.add(e3);
        GameStart g = new GameStart();
        list_of_enemies = g.enemyWalk(list_of_enemies);
        assertEquals(list_of_enemies.size(), 2);
        assertEquals(e1.getXVal(), 1099);
        assertEquals(e2.getYVal(), 499);
    }

    /* M4
       Checks to see that enemies are walking
     */
    @Test
    public void testEnemyIsWalking2() {
        Enemy e1 = new Enemy1();
        Enemy e2 = new Enemy2();
        Enemy e3 = new Enemy3();
        new ArrayList<Enemy> enemiesWalking = ArrayList{e1, e2, e3};

        int initx1Pos = e1.getXVal();
        int inity1Pos = e1.getYVal();

        int initx2Pos = e2.getXVal();
        int inity2Pos = e2.getYVal();

        int initx3Pos = e3.getXVal();
        int inity3Pos = e3.getYVal();

        assertEquals(initx1Pos, initx2Pos, 0);
        assertEquals(initx2Pos, initx3Pos, 0);
        assertEquals(initx1Pos, initx3Pos, 0);
        assertEquals(inity1Pos, inity2Pos, 0);
        assertEquals(inity2Pos, inity3Pos, 0);
        assertEquals(inity1Pos, inity3Pos, 0);

        enemyWalk(enemiesWalking);

        int newx1Pos = e1.getXVal();
        int newy1Pos = e1.getYVal();

        int newx2Pos = e2.getXVal();
        int newy2Pos = e2.getYVal();

        int newx3Pos = e3.getXVal();
        int newy3Pos = e3.getYVal();

        assertNotEquals(initx1Pos, newx1Pos, 0);
        assertNotEquals(initx2Pos, newx2Pos, 0);
        assertNotEquals(initx3Pos, newx3Pos, 0);
        assertNotEquals(inity1Pos, newy1Pos, 0);
        assertNotEquals(inity2Pos, newy2Pos, 0);
        assertNotEquals(inity3Pos, newy3Pos, 0);

    }

}