package test;
import javafx.scene.image.ImageView;
import main.*;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TowerConfigTest {

    
    @Test
    public void testIsTowerOnTower() {
        assertEquals("Null array was passed in successfully",
                PlaceTowers.isTowerOnTower(null, null), false);
        ArrayList<Tower> t = new ArrayList<>();
        Tower.setLevel(1);
        Tower1 t1 = new Tower1();
        t1.setXVal(120);
        t1.setYVal(150);
        ImageView i = t1.draw();

        Tower2 t2 = new Tower2();
        t2.setXVal(0);
        t2.setYVal(0);

        Tower3 t3 = new Tower3();
        t3.setXVal(700);
        t3.setYVal(700);

        Tower2 t4 = new Tower2();
        t4.setXVal(130);
        t4.setYVal(160);

        t.add(t2);
        t.add(t3);
        t.add(t4);
        assertEquals("Was able to place two towers on top of each other",
                PlaceTowers.isTowerOnTower(t, i), true);


    }
}