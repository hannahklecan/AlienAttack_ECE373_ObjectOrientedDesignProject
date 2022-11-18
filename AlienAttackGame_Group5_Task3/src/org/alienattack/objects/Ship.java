package org.alienattack.objects;

/* Ship class holds the coordinates and health of enemy ships as well as the player ship */

public abstract class Ship {
	//Fields
	protected int xPos;
	protected int yPos;
	protected int health;
	
	
	//Constructor
	public Ship() {
		xPos = 0;
		yPos = 0;
		health = 100;
	}
	public Ship(int x, int y) {
		xPos = x;
		yPos = y;
		health = 100;
	}
	
	
	//Getters
	public int getXCoordinate() {
		return xPos;
	}
	public int getYCoordinate() {
		return yPos;
	}
	public int getHealth() {
		return health;
	}
	
	
	//Setters
	public void setXCoordinate(int x) {
		xPos = x;
	}
	public void setYCoordinate(int y) {
		yPos = y;
	}
	public void setHealth(int amount) {
		health = amount;
	}
	
	
	//Functions
	//Set coordinates without changing/ resetting health
	public void setCoordinates(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	//add function to reset health after level is completed?

}
