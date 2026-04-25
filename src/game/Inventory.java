package game;

public class Inventory {
	private Weapon[] items;
	private int count;
	
	public Inventory(int capacity) {
		items = new Weapon[capacity];
		count = 0;
	}
	
	public void addWeapon(Weapon w) {
		if (count < items.length) {
			items[count] = w;
			count++;
		}
	}
	
	public void sortByDamage() {
		for (int i = 0; i < count - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < count; j++) {
				if (items[j].getDamage() < items[minIdx].getDamage()) {
					minIdx = j;
				}
			}
			Weapon temp = items[minIdx];
			items[minIdx] = items[i];
			items[i] = temp;
		}
		System.out.println(">>> Inventory sorted by Damage! <<<");
	}
	
	public void displayInventory() {
		System.out.println("\n--- INVENTORY ---");
		for (int i = 0; i < count; i++) {
			System.out.println((i+1) + ". " + items[i].toString());
		}
	}
}