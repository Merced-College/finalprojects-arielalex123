package game;
import java.util.Scanner;
public class GameController {
	private Player player;
	private GameEngine engine;
	private Training training;
	private DungeonManager dungeonManager;
	private Inventory inventory;
	private Shop shop;
	private Scanner scnr;
	
	public GameController() {
		this.scnr = new Scanner(System.in);
		this.player = new Player("Admin");
		this.engine = new GameEngine();
		this.training = new Training(player);
		this.dungeonManager = new DungeonManager();
		this.inventory = new Inventory(10);
		this.inventory.addWeapon(Weapon.bareHands());
		this.shop = new Shop();
	}
	public void startGame() {
		boolean start = true;
		while(start) {
			showHUD();
			System.out.println("1. Enter Dungeon | 2. Daily Train | 3. Stats | 4. Inventory | 5. Shop | 6. Leave");
			int choice = scnr.nextInt();	
			
			switch(choice) {
				case 1:
					startBattle();
					break;
				case 2:
					runTraining();
					break;
				case 3:
					manageStats();
					break;
				case 4:
					manageInventory();
					break;
				case 5:
					shop.enterShop(player, inventory, scnr);
					break;
				case 6:
					start = false;
					System.out.println("Saving Progress...");
					scnr.close();
					System.exit(0);
					break;
			}
		}
	}
	
	private void showHUD() {
		System.out.println("\n================ SOLO LEVELING SYSTEM ================");
		System.out.println("Hunter: " + player.getName() + " Level: " + player.getLevel() + " Exp: " + player.getCurrentXp() + " / " + player.getNextLevelXp());
		System.out.println("HP: " + player.getCurrentHp() + " / " + player.getMaxHp());
		System.out.println("Yen: " + player.getYen() + " Mana Crystals: " + player.getManaCrystals());
		System.out.println("------------------------------------------------------");
	}
	
	private void startBattle() {
		DungeonNode currentWave = dungeonManager.generateDungeon(player.getLevel());
		boolean fled = false;
		while (currentWave != null && player.isAlive() && !fled) {
			Enemy enemy = currentWave.getEnemy();
			System.out.println("\n--- Battle with " + enemy.getName().toUpperCase() + " [ " + enemy.getRank() + " ] ---");
			
			while (enemy.isAlive() && player.isAlive()) {
                System.out.println("HP Enemy: " + enemy.getHp() + " | Your HP: " + player.getCurrentHp());
                System.out.print("1. Attack | 2. Leave: ");
                int act = scnr.nextInt();
                
                if (act == 1) {
                    double damage = player.getDamage();
                    if (engine.calculateDodge(player.getCritChance())) {
                        damage *= 2;
                        System.out.println("¡CRIT ATTACK!");
                    }
                    enemy.takeDamage(damage);
                    
                    if (enemy.isAlive()) {
                        if (!engine.calculateDodge(player.getDodgeChance())) {
                            player.takeDamage(enemy.getAttack());
                        } else {
                            System.out.println("¡Dogde!");
                        }
                    }
                } else {
                	fled = true;
                    break; 
                }
            }
            
            if (player.isAlive() && !fled) {
                System.out.println("You defeat " + enemy.getName());
                if (enemy.getRank().equals("S") && engine.tryArise("S")) {
                    player.addShadow();
                }
                currentWave = currentWave.getNext();
            }
        }
        
		if (!player.isAlive()) {
			player.healFull();
		}
		else if (fled) {
			training.resetDaily();
		}
		else {
            player.gainRewards(150, 5);
            player.gainXp(200);
            training.resetDaily();
        }
    }

    private void runTraining() {
        System.out.println("\n--- Training Center ---");
        System.out.println("1. Pushups | 2. Situps (Lv5) | 3. Squats (Lv15) | 4. Running (Lv30)");
        int ex = scnr.nextInt();
        System.out.println(training.executeExercise(ex));
    }

    private void manageStats() {
    	boolean  upgrading = true;
    	while(upgrading) {
	        System.out.println("\n--- Assing Points (" + player.getStatPoints() + ") ---");
	        System.out.println("1. STRENGTH ("+player.getStr()+")");
	        System.out.println("2. SPEED ("+player.getAgi()+")");
	        System.out.println("3. HEALTH ("+player.getVit()+")");
	        System.out.println("4. INTELLIGENCE ("+player.getIntel()+")");
	        System.out.println("5. STAMINA ("+player.getSen()+")");
	        int stat = scnr.nextInt();
	        
	        if(stat == 0) {
	        	upgrading = false;
	        }
	        else {
		        if (player.upgradeStat(stat)) {
		            System.out.println("Stat Increase");
		            if(player.getStatPoints() <= 0) {
		            	upgrading = false;
		            }
		        } else {
		        	if (player.getStatPoints() <= 0) {
		        		System.out.println("No enough Points Stats");
		        		upgrading = false;
		        	}
		        }
    		}
	    }//end while
    }//end manageStats
    
    private void manageInventory() {
		boolean inInventory = true;
		while(inInventory) {
			inventory.displayInventory();
			System.out.println("\n1. Equip Weapon | 2. Sort by Damage | 3. Leave");
			int choice = scnr.nextInt();
			
			if (choice == 1) {
				System.out.print("Enter the number of the weapon to equip: ");
				int idx = scnr.nextInt();
				Weapon selected = inventory.getWeapon(idx - 1);
				if (selected != null) {
					player.setWeapon(selected);
				} else {
					System.out.println("Invalid selection.");
				}
			} else if (choice == 2) {
				inventory.sortByDamage();
			} else {
				inInventory = false;
			}
		}
	}
	
}
