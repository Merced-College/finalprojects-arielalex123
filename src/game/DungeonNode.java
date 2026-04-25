package game;

public class DungeonNode {
	private Enemy enemy;
	private DungeonNode next;
	
	public DungeonNode(Enemy enemy) {
		this.enemy = enemy;
		this.next = null;
	}
	
	public Enemy getEnemy() { 
		return enemy; 
		}
	public DungeonNode getNext() { 
		return next; 
		}
	public void setNext(DungeonNode next) { 
		this.next = next; 
		}
}