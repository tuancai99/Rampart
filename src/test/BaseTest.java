package test;
import main.Base;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseTest {
    /* M4
    Checks if method correctly returns the boolean value false
    if the Base health drops to 0.
    */
    @Test
    public void testIsBaseHealthy() {
        Base.setHealth(1);
        assertEquals(Base.isBaseHealthy(), true);
        Base.setHealth(0);
        assertEquals(Base.isBaseHealthy(), false);
        Base.setHealth(-3);
        assertEquals(Base.isBaseHealth(), false);
    }

}