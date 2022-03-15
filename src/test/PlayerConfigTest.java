package test;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.PlayerConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class PlayerConfigTest {
    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        // Initialise Java FX
        System.out.printf("About to launch FX App\n");
        Thread t = new Thread("JavaFX PlayerConfig Thread") {
            public void run() {
                Application.launch(PlayerConfig.class);
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.printf("FX App thread started\n");
        Thread.sleep(500);
    }

    @Test
    public void testNameInputValid1() {
        TextField name = new TextField();
        name.setText("");
        ComboBox<Integer> dif;
    }

    @Test
    public void testNameInputValid2() {
        PlayerConfig test = new PlayerConfig();
        TextField name = new TextField();
        name.setText(null);
        ComboBox<Integer> dif;
    }

    @Test
    public void testNameInputValid3() {
        PlayerConfig test = new PlayerConfig();
        TextField name = new TextField();
        name.setText("         ");
        ComboBox<Integer> dif;
    }

    @Test
    public void testNameInputValid4() {
        PlayerConfig test = new PlayerConfig();
        TextField name = new TextField();
        name.setText("Please enter your name");
        ComboBox<Integer> dif;


    }

    @Test
    public void testDifficultyCostDifferent() {

    }
}