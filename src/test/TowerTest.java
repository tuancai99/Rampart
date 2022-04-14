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

    @Test
    public void distCalculatorTest() {
        Enemy myEnemy = new Enemy1(20,20);
        Tower myTow = new Tower1();
        myTow.setXVal(10);
        myTow.setYVal(10);
        assertEquals(myTow.distCalculator(myEnemy),
                10*Math.sqrt(2), (Math.abs(myTow.distCalculator(myEnemy) - 10 * Math.sqrt(2))));
    }
}