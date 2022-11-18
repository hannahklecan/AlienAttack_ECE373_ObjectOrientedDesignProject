package org.alienattack.game;

import java.util.ArrayList;

import org.alienattack.objects.Enemy;
import org.alienattack.objects.Player;
import org.alienattack.objects.Missile;


/* GameBoard class keeps track of all "characters" in game. Keeps track of all elements implemented */

public class GameBoard {
	//Fields
	//---------- Game Board Dimensions ----------//
	private int lengthEnd;
	private int heightEnd;
	// Name of gameBoard
	private String gameName;
	//------- Game "characters" on Game Board -------//
	private ArrayList<Enemy> currEnemies;
	private Player currPlayer;
	private ArrayList<Missile> missilesOnBoard;
	
	
	//Constructors
	public GameBoard() {
		lengthEnd = 10;
		heightEnd = 10;
		currEnemies = new ArrayList<Enemy>();
		currPlayer = new Player();
		missilesOnBoard = new ArrayList<Missile>();
		gameName = "Game";
	}
	
	
	//Getters
	public int getMaxLength() {
		return lengthEnd;
	}
	
	public int getMaxHeight() {
		return heightEnd;
	}
	
	public ArrayList<Enemy> getEnemyPositions() {
		return currEnemies;
	}
	
	public Player getPlayer() {
		return currPlayer;
	}
	public ArrayList<Missile> getMissiles() {
		return missilesOnBoard;
	}
	public String getName() {
		return gameName;
	}
	
	
	//Setters
	public void setMaxLength(int num) {
		lengthEnd = num;
	}
	
	public void setMaxHeight(int num) {
		heightEnd = num;
	}
	
	public void addNewEnemy(Enemy newEnemy) {
		currEnemies.add(newEnemy);
	}
	
	public void setNewPlayer(Player newPlayer) {
		currPlayer = newPlayer;
	}
	
	public void addMissile(Missile newBomb) {
		missilesOnBoard.add(newBomb);
	}
	public void setName(String title) {
		gameName = title;
	}
	
	
	//Functions
	
	//Makes sure enemy position isn't already occupied before adding new enemy
	public boolean checkEnemyPosition(int x, int y) {
		boolean check = false;
		
		for(int i = 0; i < currEnemies.size(); i++) {
			if (currEnemies.get(i).getXCoordinate() == x && currEnemies.get(i).getYCoordinate() == y) {
				check = true;
			}
		}
		return check;
	}
	
	
	public void checkEnemyHit(Missile mis) { 
		for (int i = 0; i < this.currEnemies.size() ; i++) {
			if(currEnemies.get(i).getXCoordinate() == mis.getXPosition() && 
					currEnemies.get(i).getYCoordinate() == mis.getYPosition()) {
				//delete ship from board & array
				deleteEnemyShip(currEnemies.get(i));
				//delete missile from board & array
				deleteMissile(mis);
				
				this.currPlayer.addToScore(50);
			}
		}
		
	}
	
	//Enemy ship reaches bottom end of board
	public void checkPlayerHit(Player p1) { 
		for (int i = 0; i < this.currEnemies.size() ; i++) {
			if (currEnemies.get(i).getYCoordinate() == 0) {
				//decrease player health by 10
				decreaseHealth(10);
				//delete ship from board & array
				deleteEnemyShip(currEnemies.get(i));
			}
		}
	}
	
	//Checks if there are still enemies on board (to determine when levels end)
	public boolean checkNumOfEnemies() {
		if (currEnemies.size() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Make sure player still has health to keep playing
	public void checkPlayerHealth () {
		if (currPlayer.getHealth() == 0) {
			System.out.println("Game Over");
		}
		else {
			System.out.println("You are not dead yet! Keep going!");
		}
	}
	
	//Delete enemy from game board once its been hit or reached the bottom
	public void deleteEnemyShip(Enemy e1) {
		currEnemies.remove(e1);
	}
	
	//Delete missile from board once it hits an enemy or reached top of board
	public void deleteMissile(Missile m1) {
		missilesOnBoard.remove(m1);
	}
	
	//Decrease player health by a given amount
	public void decreaseHealth(int decrement) {
		int health = currPlayer.getHealth();
		
		health = health - decrement;
		
		currPlayer.setHealth(health);
	}
	
	//Resize game board
	public void resetGameBoardDimensions(int length, int height) {
		setMaxLength(length);
		setMaxHeight(height);
	}

}

