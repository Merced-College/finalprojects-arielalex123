package game;

public class Player {
	private String name;
	private int level = 1;
	private int str = 5, agi = 5, vit = 0, intel = 5, sen = 5;
	private int statPoints = 0;
	private double currentHp;
	private int yen = 0;
	private int manaCrystals = 0;
	private double currentXp = 0;
	private double nextLevelXp = 100;
	private Weapon equippedWeapon;
	private int activeShadows = 0;
	
	public Player(String name) {
		this.name = name;
		this.equippedWeapon = Weapon.bareHands();
		this.currentHp = getMaxHp();
	}
	
	// stats using for combats including Raids and Dungeons
	public double getMaxHp() {
		return 100 + (vit * 15.5);
	}
	public double getDamage() {
		return equippedWeapon.getDamage() + (str * 2.5) + (activeShadows * 5.0);
	}
	public double getDodgeChance() {
		return Math.min(agi * 0.15, 45.0);
	}
	
	public double getCritChance() {
		return Math.min(sen * 0.15, 75.0);
	}
	
	//System of levelUp
	public void gainXp(double amount) {
		this.currentXp += amount;
		while (this.currentXp >= nextLevelXp) {
			this.currentXp -= nextLevelXp;
			this.level++;
			this.statPoints += 5;
			this.nextLevelXp = (double)(this.nextLevelXp * 1.3);
			System.out.println("\n>>> LEVEL UP " + level + " <<<");
		}
	}
	
	public boolean upgradeStat(int choice) {
		if(statPoints <= 0) 
			return false; 
		switch (choice) {
			case 1: str++;
				break;
			case 2: agi++;
				break;
			case 3: vit++;
				break;
			case 4: intel++;
				break;
			case 5: sen++;
				break;
			default: return false;
		}
		statPoints--;
		return true;
	}
	
	public boolean spendYen(int amount) {
		if(this.yen >= amount) {
			this.yen -= amount;
			return true;
		}
		return false;
	}
	
	public void gainStatPoint() {
		this.statPoints++;
	}
	
	public void takeDamage(double dmg) {
		this.currentHp = Math.max(0, this.currentHp - dmg);
	}
	
	public void healFull() {
		this.currentHp = getMaxHp();
	}
	
	public boolean isAlive() {
		return currentHp > 0;
	}
	
	public void addShadow() {
		this.activeShadows++;
		System.out.println("Extraction Completed: Army of Shadows: " + activeShadows);
	}
	
	//getters
	public int getLevel() {
		return level;
	}
	
	public int getStatPoints() {
		return statPoints;
	}
	
	public double getCurrentXp() {
		return currentXp;
	}
	
	public double getNextLevelXp() {
		return nextLevelXp;
	}
	
	public double getCurrentHp() {
		return currentHp;
	}
	
	public Weapon getWeapon() {
		return equippedWeapon;
	}
	
	public String getName() {
		return name;
	}
	
	public void gainRewards(int y, int mc) {
		this.yen += y;
		this.manaCrystals += mc;
	}
	
	public int getStr() {
		return str;
	}
	
	public int getAgi() {
		return agi;
	}
	
	public int getVit() {
		return vit;
	}
	
	public int getIntel() {
		return intel;
	}
	
	public int getSen() {
		return sen;
	}
	
	public int getYen() {
		return yen;
	}
	
	public int getManaCrystals() {
		return manaCrystals;
	}
}
