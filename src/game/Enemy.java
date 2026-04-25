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