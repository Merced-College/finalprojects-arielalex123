/*
Author: Ariel Penaloza
Class: DungeonNode.java
Description: The node for the linked list data structure, the enemy next node in the dungeon
Source: https://www.geeksforgeeks.org/dsa/linked-list-data-structure/
Modified by: Ariel Penaloza
Changes: Enemy as an object to create a custom node for the waves
*/

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