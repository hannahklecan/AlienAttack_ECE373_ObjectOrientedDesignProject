package org.alienattack.objects;

/* Missile class is for the missiles that the player can shoot at the enemies. This class will keep track of the movement of the 
 * missile. 
 */

public class Missile {
	//Fields
	private int xPos;
	private int yPos;
	
	
	//Constructors
	public Missile() {
		xPos = 0;
		yPos = 1;
	}
	
	public Missile(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	
	//Getters
	public int getXPosition() {
		return xPos;
	}
	public int getYPosition() {
		return yPos;
	}
	
	
	//Setters
	public void setXPosition(int x) {
		//add check to make sure location is within game board boundaries
		xPos = x;
	}
	public void setYPosition(int y) {
		//add check to make sure location is within game board boundaries
		yPos = y;
	}
	
	
	
	//Functions
	/*Keep moving the missile up the board until it either reaches top end of board or 
	 	hits an enemy ship*/
	public void moveUp() {
		yPos++;
		//Update GUI
		
		//if enemy hit, delete enemy (main?)
		
		//else if reaches edge of game board, delete missile from game
		if (yPos == 10) {
			//delete missile from game board array
			
			//-- reseting to 0 for testing purposes --//
			yPos = 0;
			//----------------------------------------//
		}
	}

}
