package test;
import main.Base;
import main.PlayerConfig;
import main.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class PlayerConfigTest {

    // Milestone 2 - Entering Invalid Player Name gives Correct Alert
    @Test
    public void testNameInputValid() {
        String invalid;
        String n = "";
        invalid = PlayerConfig.checkName(n);
        assertEquals("Incorrect name was entered but never caught",
                invalid, "Invalid name");
        n = "  ";
        invalid = PlayerConfig.checkName(n);
        assertEquals("Incorrect name was entered but never caught",
                invalid, "Invalid name");
        n = "Enter your name!";
        invalid = PlayerConfig.checkName(n);
        assertEquals("Incorrect name was entered but never caught",
                invalid, "Please enter your name");
    }

    // Milestone 2 - Player starting money is different based on difficulty levels
    @Test
    public void testDifficultyCostDifferent() {
        PlayerConfig.startingMoney(1);
        assertEquals("Expected money was not equal to actual money",
                Player.getMoney(), 2000);
        int lev1Money = Player.getMoney();

        PlayerConfig.startingMoney(2);
        assertEquals("Expected money was not equal to actual money",
                Player.getMoney(), 1500);
        int lev2Money = Player.getMoney();

        PlayerConfig.startingMoney(3);
        assertEquals("Expected money was not equal to actual money",
                Player.getMoney(), 1000);
        int lev3Money = Player.getMoney();
        assertTrue(lev1Money != lev2Money);
        assertTrue(lev1Money != lev3Money);
        assertTrue(lev2Money != lev3Money);

    }

    // Milestone 2 - Player starting health is different based on difficulty levels
    @Test
    public void testDifficultyHealthDifferent1() {
        PlayerConfig.startingHealth(1);
        assertEquals("Expected health was not equal to actual health",
                Base.getHealth(), 500);
        int lev1Health = Base.getHealth();

        PlayerConfig.startingHealth(2);
        assertEquals("Expected health was not equal to actual health",
                Base.getHealth(), 400);
        int lev2Health = Base.getHealth();

        PlayerConfig.startingHealth(3);
        assertEquals("Expected health was not equal to actual health",
                Base.getHealth(), 300);
        int lev3Health = Base.getHealth();

        assertTrue(lev1Health != lev2Health);
        assertTrue(lev1Health != lev3Health);
        assertTrue(lev2Health != lev3Health);
    }

    @Test
    public void testDifficultyIsNull() {
        assertEquals("Player difficulty was set to null",
                PlayerConfig.checkDifficulty(null), "Must choose a difficulty");
    }

}

