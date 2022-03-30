package test;
import main.Base;
import main.Enemy;
import main.Enemy1;
import main.GameStart;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseTests {
    /* M4
    Checks if the game correctly halts if the Base health drops below zero.
    */
    @Test
    public void testBaseHealthBelowZero() {
        Base b = new Base();
        b.setHealth(1);
        Enemy e1 = new Enemy1();
    }

}