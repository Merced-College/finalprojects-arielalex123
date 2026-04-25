package game;
import java.util.HashMap;
import javas.util.Scanner;

public class Shop {
	private HashMap<String, Integer> prices;
	
	public Shop() {
		prices = new HashMap<>();
		prices.put("Healing Potion", 50);
		prices.put("Experience Crystal", 150);
		prices.put("+1 Stats Points", 500);
	}
	
	public void enterShop(Player player, java.util.Scanner scnr) {
		boolean shopping = true;
		while(shopping) {
			System.out.println("\n========= SYSTEM SHOP =========");
			System.out.println("Your Yen: " + player.getYen());
			System.out.println("1. Healing Potion (Restore HP) - " + prices.get("Healing Potion") + " Yen");
			System.out.println("2. Experience Crystal (+150 XP) - " + prices.get("Experience Crystal") + " Yen");
			System.out.println("3. Extra Stat Point (+1 Stat) - " + prices.get("+1 Stats Points") + " Yen");
			System.out.println("4. Leave Shop");
			System.out.print("Select an item to buy: ");
			
			int choice = scnr.nextInt();
			
			switch(choice) {
			case 1:
				processPurchase(player, "Healing Potion");
				break;
			case 2:
			}
		}
	}

	private void processPurchase(Player player, String itemName) {
		int cost = prices.get(itemName);
		
		if(player.spendYen(cost)) {
			applyEffect(player, itemName);
		} else {
			System.out.println("Not enough Yen");
		}
	}
	
	private void applyEffect(Player player, String itemName) {
		if(itemName.equals("Healing Potion")) {
			player.healFull();
		} 
		else if (itemName.equals("Experience Crystal")) {
			player.gainXp(150);
		}
		else if (itemName.equals("+1 Stats Points")) {
			player.gainStatPoint();
		}
	}
}
