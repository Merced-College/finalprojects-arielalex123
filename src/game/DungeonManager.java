package game;

public class DungeonManager {
	public DungeonNode generateDungeon(int playerLevel) {
        if (playerLevel < 10) {
            DungeonNode wave1 = new DungeonNode(new Enemy("Goblin", "E", 40, 5, false));
            DungeonNode boss = new DungeonNode(new Enemy("Goblin King", "D", 100, 12, true));
            wave1.setNext(boss);
            return wave1;
        } 
        else {
			DungeonNode wave1 = new DungeonNode(new Enemy("Shadow Knight", "A", 350, 60, false));
			DungeonNode wave2 = new DungeonNode(new Enemy("Shadow Mage", "A", 200, 80, false));
			DungeonNode boss = new DungeonNode(new Enemy("Commander Igris", "S", 1200, 150, true));
			
			wave1.setNext(wave2);
			wave2.setNext(boss);
			return wave1;
		}
    }
}
