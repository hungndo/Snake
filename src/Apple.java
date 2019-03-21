import java.util.Random;

public class Apple {
	private int appleX,appleY;
	public int getAppleX() {
		return appleX;
	}
	public int getAppleY() {
		return appleY;
	}
	public void summon() {
		Random rand=new Random();
		appleX=(rand.nextInt(49)+1)*Screen.getCELL_LENGTH();
		appleY=(rand.nextInt(49)+1)*Screen.getCELL_LENGTH();
	}
}
