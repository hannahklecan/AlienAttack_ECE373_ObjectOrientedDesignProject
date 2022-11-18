package org.alienattack.objects;

import java.util.ArrayList;

/* Player class keeps track of the player name and score as well as the movement of the player. */

public class Player extends Ship{
	//Fields
	private String playerName;
	private int playerScore;
	private ArrayList<Missile> ShipsMissiles;
	
	//Constructor
	public Player() {
		playerName = "";
		playerScore = 0;
		xPos = 5; //middle of board
		yPos = 0; // bottom row of board
		ShipsMissiles = new ArrayList<Missile>();
	}
	
	//Getters
	public String getName() {
		return playerName;
	}
	
	public int getScore() {
		return playerScore;
	}
	
	public ArrayList<Missile> getShipsMissiles() {
		return ShipsMissiles;
	}

	//Setters
	public void setShipsMissiles(ArrayList<Missile> shipsMissiles) {
		ShipsMissiles = shipsMissiles;
	}
	
	public void setName(String aName) {
		playerName = aName;
	}
	
	public void setScore(int aScore) {
		playerScore = aScore;
	}
	
	
	//Functions
	//Move player ship left
	public void moveLeft() {
		if (xPos == 0) {
			//at bound, stay at edge
			xPos = 0;
		}
		else {
			xPos -= 1;
		}
		//update position in game board and GUI
		
	}
	
	//Move player ship right
	public void moveRight() {
		if (xPos == 10) {
			//at bound, stay at edge
			xPos = 10;
		}
		else {
			xPos += 1;
		}
		//update position in game board and GUI
		
	}
	
	//Shoot a missile, move to main?
	public void shootMissle() {
		Missile playerMissle = new Missile(xPos, 1);
		
		this.ShipsMissiles.add(playerMissle);
		//add missile to game board, update GUI
	}
	
	public void shootMissle(Missile mis) {
		//mis.setXPosition(this.xPos);
		//mis.setYPosition(this.yPos + 1);
		
		
		this.ShipsMissiles.add(mis);
		//add missile to game board, update GUI
	}
	
	//Get input for keys Player pushed for movement, move to main?
	public void getKeyboardInput(String inputKey) {
		if (inputKey == "left" || inputKey == "a" ) {
			moveLeft();
		}
		else if (inputKey == "right" || inputKey == "d") {
			moveRight();
		}
		
		if (inputKey == "spacebar") {
			shootMissle();
		}
	}
	
	//Add an amount to players score, could be for when an enemy dies or player reaches next level
	public void addToScore(int amount) {
		playerScore += amount;
		
	}
}
