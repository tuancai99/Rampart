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
}