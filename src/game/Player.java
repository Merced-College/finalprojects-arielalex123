package game;

public class Player {
	private String name;
	private int level = 1;
	private int str = 1, agi = 1, vit = 1, intel = 1, sen = 1;
	private int statPoints = 0;
	private double currentHp;
	private int yen = 0;
	private int manaCrystals = 0;
	private double currentXp = 0;
	private double nextLevelXp = 100;
	private Weapon equippedWeapon;
	
	public Player(String name) {
		this.name = name;
		this.equippedWeapon = Weapon.bareHands();
		this.currentHp = getMaxHp();
	}
	
	public double getMaxHp() {
		return 100 + (vit * 15.5);
	}
	public double getDamage() {
		return equippedWeapon.getDamage() + (str * 2.5);
	}
	public double getDodgeChance() {
		return Math.min(agi * 0.15, 45.0);
	}
	
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
	
	public void takeDamage(double dmg) {
		this.currentHp = Math.max(0, this.currentHp - dmg);
	}
	
	public void healFull() {
		this.currentHp = getMaxHp();
	}
	
	public boolean isAlive() {
		return currentHp > 0;
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
}
