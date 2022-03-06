public class Tower1 implements Tower {
	private int price;
	private int xVal;
	private int yVal;
	private double dps;

	public Tower1(int dif) {
		price = 100 * dif;
		dps = 2.5 - (0.4(dif - 1));
	}

	public void setPrice(int p) {
		price = p;
	}

	public int getPrice() {
		return price;
	}

	public void setxVal(int x) {
		xVal = x;
	}

	public int getxVal() {
		return xVal;
	}

	public void setyVal(int y) {
		yVal = y;
	}

	public int getyVal(){
		return yVal;
	}

	public void setdps(int d) {
		dps = d;
	}

	public double getdps() {
		return dps;
	}
}