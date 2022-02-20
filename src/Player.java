import java.lang.*;
public class Player {

	private static String name;
	private static int level;

	public static void setName(String n) {
		name = n;
	}

	public static void setLevel(Integer l) {
		level = l.intValue();
	}

	public static String getName() {
		return name;
	}

	public static int getLevel() {
		return level;
	}
}