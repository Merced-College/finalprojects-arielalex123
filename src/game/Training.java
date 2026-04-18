package game;

public class Training {
	private Player player;
	private boolean dailyCompleted;
	
	public Training(Player player) {
		this.player = player;
		this.dailyCompleted = false;
	}
	
	public String executeExercise(int choice) {
		if(dailyCompleted) {
			return "Finish your workout?, Go to a Dungeon and get rewards.";
		}
		int lvl = player.getLevel();
		
		if(choice == 1) {
			player.gainXp(50);
			dailyCompleted = true;
			return "Pushups Completed. +50 XP";
		}
		
		else if(choice == 2 && lvl >= 5) {
			player.gainXp(150);
			dailyCompleted = true;
			return "Situps Completed. +150 XP";
		}
		
		else if(choice == 3 && lvl >= 15) {
			player.gainXp(450);
			dailyCompleted = true;
			return "Squats Completed. +450 XP";
		}
		else if(choice == 4 && lvl >= 30) {
			player.gainXp(1000);
			dailyCompleted = true;
			return "Running Completed. +1000 XP";
		}
		return "You are still weak for this exercise. ";
	}
	public void resetDaily() {
		this.dailyCompleted = false;
	}
}
