/*
Author: Ariel Penaloza
Class: Enemy.java
Description: Similar as player class, but for enemies and bosses for dungeons, storing stats and boss status
Source: https://medium.com/codex/object-oriented-principles-explained-2d1d4bdd3be7
Modified by: Ariel Penaloza
Changes: The use of getters and setters the logic and scale for stadistics like player class
*/

package game;

public class Enemy {
	private String name, rank;
	private double hp, attack;
	private boolean isBoss;
	
	public Enemy(String name, String rank, double hp, double attack, boolean isBoss) {
		this.name = name;
		this.rank = rank;
		this.hp = hp;
		this.attack = attack;
		this.isBoss = isBoss;
	}
	
	public void takeDamage(double dmg) { 
		this.hp = Math.max(0, this.hp - dmg); 
		}
	
	public boolean isAlive() { 
		return hp > 0; 
		}
	
	public String getName() { 
		return name; 
		}
	public double getHp() { 
		return hp; 
		}
	public double getAttack() { 
		return attack; 
		}
	public String getRank() { 
		return rank; 
		}
	public boolean isBoss() { 
		return isBoss; 
		}
}