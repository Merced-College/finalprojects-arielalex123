package game;
import java.util.Random;

public class GameEngine {
	private Random rand = new Random();
	
	public boolean calculateDodge(double chance) {
		return (rand.nextDouble() * 100) < chance;
	}
	
	public boolean tryArise(String rank) {
		int chance = rank.equals("S") ? 10 : 35;
		return rand.nextInt(100) < chance;
	}
}