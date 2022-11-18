package org.alienattack.game.test;

import static org.junit.jupiter.api.Assertions.*;

import org.alienattack.objects.Enemy;
import org.alienattack.objects.Player;
import org.alienattack.objects.Missile;
import org.alienattack.game.GameBoard;


import org.junit.jupiter.api.Test;

class GameBoardTest {

	@Test
	void testGameBoard() {
		GameBoard g1 = new GameBoard();
		//lengthEnd = 10, heightEnd = 10, currEnemies = new ArrayList<Enemy>(), currPlayer = new Player(), 
		//	missilesOnBoard = new ArrayList<Missile>(), gameName = "Game"
		
		//testing length
		assertEquals(10, g1.getMaxLength());
		//testing height
		assertEquals(10, g1.getMaxLength());
		//testing name
		assertEquals("Game", g1.getName());
		//testing enemies
		assertEquals(0, g1.getEnemyPositions().size());
		
		//-------------- testing player stuff --------------//
		//testing  name
		assertEquals("", g1.getPlayer().getName());
		//testing score
		assertEquals(0, g1.getPlayer().getScore());
		//testing x
		assertEquals(5, g1.getPlayer().getXCoordinate()); //ship
		//testing Y
		assertEquals(0, g1.getPlayer().getYCoordinate()); //ship
		//testing health
		assertEquals(100, g1.getPlayer().getHealth()); //ship
		//--------------- player stuff done -----------------//
		
		//testing missiles
		assertEquals(0, g1.getMissiles().size());
	}

	@Test
	void testSetMaxLength() {
		GameBoard g1 = new GameBoard();
		
		//set length to 50
		g1.setMaxLength(50);
		assertEquals(50, g1.getMaxLength());
		assertEquals(10, g1.getMaxHeight());
	}

	@Test
	void testSetMaxHeight() {
		GameBoard g1 = new GameBoard();
		
		//set height to 50
		g1.setMaxHeight(50);
		assertEquals(50, g1.getMaxHeight());
		assertEquals(10, g1.getMaxLength());
	}

	@Test
	void testAddNewEnemy() {
		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		GameBoard g1 = new GameBoard();
		
		//add e1 to board and verify it's been added
		g1.addNewEnemy(e1);
		assertEquals(1, g1.getEnemyPositions().size());
		
		//add e2 to board and verify it's been added
		g1.addNewEnemy(e2);
		assertEquals(2, g1.getEnemyPositions().size());
	}

	@Test
	void testSetNewPlayer() {
		Player p1 = new Player();
		p1.setName("Jeff");
		GameBoard g1 = new GameBoard();
		
		//player not added yet
		assertEquals("", g1.getPlayer().getName());
		
		//player should be added
		g1.setNewPlayer(p1);
		assertEquals("Jeff", g1.getPlayer().getName());
	}

	@Test
	void testAddMissle() {
		Missile m1 = new Missile();
		Missile m2 = new Missile();
		GameBoard g1 = new GameBoard();
		
		//add e1 to board and verify it's been added
		g1.addMissile(m1);
		assertEquals(1, g1.getMissiles().size());
		
		//add e2 to board and verify it's been added
		g1.addMissile(m2);
		assertEquals(2, g1.getMissiles().size());
	}

	@Test
	void testSetName() {
		GameBoard g1 = new GameBoard();
		
		//set name to "Master Game"
		g1.setName("Master Game");
		assertEquals("Master Game", g1.getName());
	}

	@Test
	void testCheckEnemyPosition() {
		//add enemy at position (3,9)
		Enemy e1 = new Enemy();
		e1.setXCoordinate(3);
		e1.setYCoordinate(9);
		GameBoard g1 = new GameBoard();
		
		//add to board
		g1.addNewEnemy(e1);
		
		//check if enemy is at (6,2) and (3,9)
		assertEquals(false, g1.checkEnemyPosition(6, 2));
		assertEquals(true, g1.checkEnemyPosition(3, 9));
	}

	@Test
	void testCheckPlayerHit() {
		//e1 gets to the bottom of the board
		Enemy e1 = new Enemy();
		e1.setYCoordinate(0);
		//e2 isn't at the bottom of the board
		Enemy e2 = new Enemy();
		Player p1 = new Player();
		GameBoard g1 = new GameBoard();
		
		//add characters to game board
		g1.setNewPlayer(p1);
		g1.addNewEnemy(e1);
		g1.addNewEnemy(e2);
		
		//testing enemies
		
		g1.checkPlayerHit(p1);
		assertEquals(90, g1.getPlayer().getHealth());
	}

	@Test
	void testCheckNumOfEnemies() {
		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		GameBoard g1 = new GameBoard();
		GameBoard g2 = new GameBoard();
				
		//add characters to game board
		g1.addNewEnemy(e1);
		g1.addNewEnemy(e2);
				
		//testing game 1
		assertEquals(true, g1.checkNumOfEnemies());
				
		//testing game 2
		assertEquals(false, g2.checkNumOfEnemies());
	}

	@Test
	void testCheckPlayerHealth() {
		GameBoard g1 = new GameBoard();
		Player p1 = new Player();
		g1.setNewPlayer(p1);
		p1.setHealth(50);
		g1.checkPlayerHealth();
		
		p1.setHealth(0);
		g1.checkPlayerHealth();
		
	}

	@Test
	void testDeleteEnemyShip() {
		Enemy e1 = new Enemy();
		GameBoard g1 = new GameBoard();
		
		//add enemy to game board, verify it has been added
		g1.addNewEnemy(e1);
		assertEquals(1, g1.getEnemyPositions().size());
		
		//remove enemy from game board and verify
		g1.deleteEnemyShip(e1);
		assertEquals(0, g1.getEnemyPositions().size());
	}

	@Test
	void testDeleteMissile() {
		Missile m1 = new Missile();
		GameBoard g1 = new GameBoard();
		
		//add missile to game board, verify it has been added
		g1.addMissile(m1);
		assertEquals(1, g1.getMissiles().size());
		
		//remove missile from game board and verify
		g1.deleteMissile(m1);
		assertEquals(0, g1.getMissiles().size());
	}

	@Test
	void testDecreaseHealth() {
		Player p1 = new Player();
		GameBoard g1 = new GameBoard();
		
		//add player to game board
		g1.setNewPlayer(p1);
		
		//decrease health by 20 (100 - 20 = 80)
		g1.decreaseHealth(20);
		assertEquals(80, g1.getPlayer().getHealth());
	}

	@Test
	void testResetGameBoardDimensions() {
		GameBoard g1 = new GameBoard();
		
		//reset dimension to 40 x 60
		g1.resetGameBoardDimensions(40, 60);
		assertEquals(40, g1.getMaxLength());
		assertEquals(60, g1.getMaxHeight());
	}

}
