package org.alienattack.characters.test;

import static org.junit.jupiter.api.Assertions.*;

import org.alienattack.objects.Player;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testPlayer() {
		Player p1 = new Player();
		//playerName = "", playerScore = 0, xPos = 5, yPos = 0, health = 100
		
		//testing name
		assertEquals("", p1.getName());
		//testing score
		assertEquals(0, p1.getScore());
		//testing x
		assertEquals(5, p1.getXCoordinate()); //ship
		//testing Y
		assertEquals(0, p1.getYCoordinate()); //ship
		//testing health
		assertEquals(100, p1.getHealth()); //ship
	}

	@Test
	void testSetName() {
		Player p1 = new Player();
		//playerName = "", playerScore = 0, xPos = 5, yPos = 0, health = 100
		
		p1.setName("Jack");
		//playerName = "Jack", playerScore = 0, xPos = 5, yPos = 0, health = 100
		
		//testing name
		assertEquals("Jack", p1.getName());
		//testing score
		assertEquals(0, p1.getScore());
		//testing x
		assertEquals(5, p1.getXCoordinate()); //ship
		//testing Y
		assertEquals(0, p1.getYCoordinate()); //ship
		//testing health
		assertEquals(100, p1.getHealth()); //ship
	}

	@Test
	void testSetScore() {
		Player p1 = new Player();
		//playerName = "", playerScore = 0, xPos = 5, yPos = 0, health = 100
		
		p1.setScore(30);
		//playerName = "", playerScore = 30, xPos = 5, yPos = 0, health = 100
		
		//testing name
		assertEquals("", p1.getName());
		//testing score
		assertEquals(30, p1.getScore());
		//testing x
		assertEquals(5, p1.getXCoordinate()); //ship
		//testing Y
		assertEquals(0, p1.getYCoordinate()); //ship
		//testing health
		assertEquals(100, p1.getHealth()); //ship

	}

	@Test
	void testMoveLeft() {
		Player p1 = new Player();
		Player p2 = new Player();
		
		//p1 xPos = 5, move left makes it 4
		p1.moveLeft();
		assertEquals(4, p1.getXCoordinate());
		
		//set p2 = 0, so move left will keep it at 0
		p2.setXCoordinate(0);
		p2.moveLeft();
		assertEquals(0, p2.getXCoordinate());
	}

	@Test
	void testMoveRight() {
		Player p1 = new Player();
		Player p2 = new Player();
		
		//p1 xPos = 5, move right makes it 6
		p1.moveRight();
		assertEquals(6, p1.getXCoordinate());
		
		//set p2 = 10, so move left will keep it at 10
		p2.setXCoordinate(10);
		p2.moveRight();
		assertEquals(10, p2.getXCoordinate());
	}

	@Test
	void testShootMissle() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetKeyboardInput() {
		//fail("Not yet implemented");
	}

	@Test
	void testAddToScore() {
		Player p1 = new Player();
		//score = 0
		
		//add 62 to score, score = 62
		p1.addToScore(62);
		assertEquals(62, p1.getScore());
		
		//add 10 more to score, score = 72
		p1.addToScore(10);
		assertEquals(72, p1.getScore());
	}

}
