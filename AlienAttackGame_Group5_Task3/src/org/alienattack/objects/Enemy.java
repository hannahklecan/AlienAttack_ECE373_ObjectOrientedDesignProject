package org.alienattack.objects;


/* Enemy class is for the enemy ships that will be implemented into the game. This class will keep track of the enemies movement 
 * down the screen and towards the player.
 */

public class Enemy extends Ship{
	//Fields, none at the moment
	
	
	
	//Constructors
	public Enemy() {
		//Change these to random positions?
		xPos = 5; //middle of board
		yPos = 10; //top of board
	}
	
	public Enemy(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	
	//Getters, none at the moment
	
	
	
	//Setters, none at the moment
	
	
	
	//Functions
	//Generate a random position for the new enemy ships to spawn at
	public int getRandomPosition() {
		//Generate a random number with min and max inclusive for X coordinate
		
		int min = 0;
		int max = 10; //whatever board game length we want
		int randomPos;
		
		randomPos = (int)Math.floor(Math.random()*(max - min + 1) + min);
		
		return randomPos;
	}
	
	//Make sure slot is empty before adding new enemy ship, may not need right now 
	/*public void updatePosition(int pos) {
		//check board positions
		//use a common class with all constants in it to check if the position is next to a wall
		 * if so, move down, if not, move right
		 * if a wall is hit, next movement will be left...
		//update position if empty slot
	}*/
	
	//Move enemy ship down towards bottom of the board
	public void moveDown() {
		yPos--;
		//update GUI
		
		if (yPos == 0) {
			//take player health down and remove ship
			
			//-- reset to 10 for testing right now --//
			yPos = 10;
			//---------------------------------------//
		}
	}

}
