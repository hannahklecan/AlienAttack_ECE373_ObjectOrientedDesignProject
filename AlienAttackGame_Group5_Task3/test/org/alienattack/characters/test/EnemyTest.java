package org.alienattack.characters.test;

import static org.junit.jupiter.api.Assertions.*;

import org.alienattack.objects.Enemy;

import org.junit.jupiter.api.Test;

class EnemyTest {

	@Test
	void testEnemy() {
		Enemy e1 = new Enemy();
		//x = 5, y = 10, health = 100
		
		//Testing xPos
		assertEquals(5, e1.getXCoordinate());
		//Testing yPos
		assertEquals(10, e1.getYCoordinate());
		//Testing health
		assertEquals(100, e1.getHealth());

	}

	@Test
	void testUpdatePosition() {
		//fail("Not yet implemented");
	}

	@Test
	void testMoveDown() {
		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		
		//e1 yPos = 10, move down makes it 9
		e1.moveDown();
		assertEquals(9, e1.getYCoordinate());
		
		//set e2 = 1, so move down will reset it back to 10
		e2.setYCoordinate(1);
		e2.moveDown();
		assertEquals(10, e2.getYCoordinate());
		
	}

}
