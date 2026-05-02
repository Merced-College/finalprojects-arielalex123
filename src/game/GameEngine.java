/*
Author: Ariel Penaloza
Class: GameEngine.java
Description: The random probability calculations for the game, for battles, dodge chances, critical hits and shadow extractions
Source: https://www.geeksforgeeks.org/java/java-math-random-method-examples/ // https://www.geeksforgeeks.org/java/java-math-class/
Modified by: Ariel Penaloza
Changes: Create specific boolean to return success rates based on player stats and enemy rank
*/

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