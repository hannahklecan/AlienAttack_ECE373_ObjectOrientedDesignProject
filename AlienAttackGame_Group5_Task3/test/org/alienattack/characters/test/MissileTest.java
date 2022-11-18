package org.alienattack.characters.test;

import static org.junit.jupiter.api.Assertions.*;

import org.alienattack.objects.Missile;
import org.junit.jupiter.api.Test;

class MissileTest {

	@Test
	void testMissile() {
		Missile m1 = new Missile();
		//x = 0, y = 1
		
		//testing X
		assertEquals(0, m1.getXPosition());
		//testing Y
		assertEquals(1, m1.getYPosition());
	}

	@Test
	void testMissileIntInt() {
		Missile m2 = new Missile(5, 2);
		//x = 5, Y = 2
		
		//testing x
		assertEquals(5, m2.getXPosition());
		//testing y
		assertEquals(2, m2.getYPosition());
	}

	@Test
	void testSetXPosition() {
		Missile m3 = new Missile();
		//x =0, y = 1
		m3.setXPosition(9);
		//x = 9, y= 1
		
		//testing x
		assertEquals(9, m3.getXPosition());
		//testing y
		assertEquals(1, m3.getYPosition());
	}

	@Test
	void testSetYPosition() {
		Missile m4 = new Missile();
		//x =0, y = 1
		m4.setYPosition(3);
		//x = 0, y= 3
		
		//testing x
		assertEquals(0, m4.getXPosition());
		//testing y
		assertEquals(3, m4.getYPosition());
	}

	@Test
	void testMoveUp() {
		Missile m1 = new Missile();
		Missile m2 = new Missile();
		
		//m1 yPos = 1, move up makes it 2
		m1.moveUp();
		assertEquals(2, m1.getYPosition());
		
		//set m2 = 9, so move up will reset it back to 0
		m2.setYPosition(9);
		m2.moveUp();
		assertEquals(0, m2.getYPosition());
	}

}
