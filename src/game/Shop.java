package game;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
	private HashMap<String, Integer> itemPrices;
	private HashMap<String, Weapon> weaponStock;
	
	public Shop() {
		itemPrices = new HashMap<>();
		weaponStock = new HashMap<>();
		
		itemPrices.put("Healing Potion", 50);
		itemPrices.put("Experience Crystal", 150);
		itemPrices.put("+1 Stats Points", 500);
		
		weaponStock.put("Steel Dagger", new Weapon("Steel Dagger", 15.5, "E", new String[]{"Stab"}));
		weaponStock.put("Longsword", new Weapon("Longsword", 25.0, "D", new String[]{"Slash"}));
		weaponStock.put("Dragon Dagger", new Weapon("Dragon Dagger", 100.0, "S", new String[]{"Dragon Breath"}));
		
		itemPrices.put("Steel Dagger", 200);
		itemPrices.put("Longsword", 500);
		itemPrices.put("Dragon Dagger", 5000);
	}
	
	public void enterShop(Player player,Inventory inv, Scanner scnr) {
		boolean shopping = true;
		while(shopping) {
			System.out.println("\n========= SYSTEM SHOP =========");
			System.out.println("Your Yen: " + player.getYen());
			System.out.println("1. Healing Potion (Restore HP) - " + itemPrices.get("Healing Potion") + " Yen");
			System.out.println("2. Experience Crystal (+150 XP) - " + itemPrices.get("Experience Crystal") + " Yen");
			System.out.println("3. Extra Stat Point (+1 Stat) - " + itemPrices.get("+1 Stats Points") + " Yen");
			System.out.println("4. Steel Dagger - " + itemPrices.get("Steel Dagger") + " Yen");
			System.out.println("5. Longsword - " + itemPrices.get("Longsword") + " Yen");
			System.out.println("6. Dragon Dagger - " + itemPrices.get("Dragon Dagger") + " Yen");
			System.out.println("7. Leave Shop");
			System.out.print("Select a Number: ");
			
			int choice = scnr.nextInt();
			
			switch(choice) {
			case 1:
				buyItem(player, "Healing Potion", null, inv);
				break;
			case 2:
				buyItem(player, "Experience Crystal", null, inv);
				break;
			case 3:
				buyItem(player, "+1 Stats Points", null, inv);
				break;
			case 4:
				buyItem(player, "Steel Dagger", weaponStock.get("Steel Dagger"), inv);
				break;
			case 5:
				buyItem(player, "Longsword", weaponStock.get("Steel Dagger"), inv);
				break;
			case 6:
				buyItem(player, "Dragon Dagger", weaponStock.get("Steel Dagger"), inv);
				break;
			case 7:
				shopping = false;
				break;
			}
		}
	}

	private void buyItem(Player player, String name, Weapon w, Inventory inv) {
		int cost = itemPrices.get(name);
		if (player.spendYen(cost)) {
			if (w != null) {
				inv.addWeapon(w);
				System.out.println(">>> Bought: " + name + " (Check Inventory to equip) <<<");
			} else {
				if (name.equals("Healing Potion")) player.healFull();
				if (name.equals("Experience Crystal")) player.gainXp(150);
				if (name.equals("+1 Stats Points")) player.getStatPoints();
				System.out.println(">>> Used: " + name + " <<<");
			}
		} else {
			System.out.println("Not enough Yen");
		}
	}
}
