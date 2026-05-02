/*
Author: Ariel Penaloza
Class: Weapon.java
Description: Equippable items that increase damage and the upgrade the weapon
Source: https://medium.com/codex/object-oriented-principles-explained-2d1d4bdd3be7
Modified by: Ariel Penaloza
Changes: Use of getters and setters
*/

package game;

public class Weapon {
	private String name;
	private double damage;
	private String rank;
	private int level;
	private String[] skills;
	
	public Weapon(String name, double damage, String rank, String[] skills) {
		this.name = name;
		this.damage = damage;
		this.rank = rank;
		this.skills = skills;
		this.level= 1;
	}
	
	//default weapon, bare hands
	public static Weapon bareHands() {
		return new Weapon("Bare Hands", 5.0, "F", new String[ ] {"Basic Punch"});
	}
	
	//Upgrade Weapons, increase damage exchange of ManaCrystals
	
	public void upgradeWeapon() {
		this.level++;
		this.damage += 15.5;
		System.out.println("Upgrade Success: " + this.name + " is level " + this.level);
	}
	
	// Getters
	
	public String getName() {
		return name;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public String getRank() {
		return rank;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String[] getSkills() {
		return skills;
	}
	
	@Override
	public String toString() {
		return "[" + rank + "] " + name + " Lvl. " + level + " - Dmg: " + damage;
	}
	
}
