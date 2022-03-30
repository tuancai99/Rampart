package test;
import main.Base;
import main.PlayerConfig;
import main.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class BaseTests {

	/* M4
	Checks if the game correctly halts if the Base health drops below zero.
	*/
	public void testBaseHealthBelowZero() {
		Base b = new Base();
		b.setHealth(1);
		Enemy e1 = new Enemy();
		e1.attack();
		GameStart.baseGone();
	}

}