package cage;

import animal.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class CageTest {

	@Test
	public void testCage() {
		Cage cage1 = new Cage(1, 'X');
		assertEquals(1, cage1.getId());
		assertEquals('X', cage1.getHabitat());
		assertEquals(0, cage1.getLuas());
		assertEquals(0, cage1.getNbAnimal());
		assertEquals(true, cage1.isAvailable());
	}
	
	@Test
	public void testAddAnimal() {
		Cage cage1 = new Cage(1, 'x');
		Animal animal = new Animal(1,2,50, '0', "OrangUtan", "Auooo", true, "X", 1);
		cage1.addAnimal(animal);
		assertEquals(1, cage1.getNbAnimal());
	}
	
	@Test
	public void testAddCell() {
		Cage cage1 = new Cage(1, 'X');
		cage1.addCell('X');
		assertEquals(1, cage1.getLuas());
	}
	
	@Test
	public void testIsIsiJinak() {
		Cage cage1 = new Cage(1, 'x');
		Animal animal = new Animal(1,2,50, '0', "OrangUtan", "Auooo", true, "X", 1);
		cage1.addAnimal(animal);
		assertEquals(true, cage1.isIsiJinak());
	}
}
