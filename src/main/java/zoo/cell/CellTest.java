package cell;

import static org.junit.Assert.*;
import cage.*;
import animal.*;
import org.junit.Test;

public class CellTest {

	@Test
	public void testCell() {
		Cell sel = new Cell('X',1,2);
		assertEquals('X',sel.getType());
		assertEquals(1,sel.getAbsis());
		assertEquals(2,sel.getOrdinat());
	}

	@Test
	public void testGetType() {
		Cell sel = new Cell('X',1,2);
		assertEquals('X',sel.getType());
	}

	@Test
	public void testGetAbsis() {
		Cell sel = new Cell('X',1,2);
		assertEquals(1,sel.getAbsis());
	}

	@Test
	public void testGetOrdinat() {
		Cell sel = new Cell('X',1,2);
		assertEquals(2,sel.getOrdinat());
	}

	@Test
	public void testGetCage() {
		Cell sel = new Cell('X',1,2);
		Cage _cage = new Cage();
		sel.setCage(_cage);
		assertEquals(_cage,sel.getCage());
	}

	@Test
	public void testSetCage() {
		Cell sel = new Cell('X',1,2);
		Cage _cage = new Cage();
		sel.setCage(_cage);
		assertEquals(_cage,sel.getCage());
	}

	@Test
	public void testGetAnimal() {
		Cell sel = new Cell('X',1,2);
		Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
		sel.setAnimal(animal1);
		assertEquals(animal1,sel.getAnimal());
	}

	@Test
	public void testSetAnimal() {
		Cell sel = new Cell('X',1,2);
		Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
		sel.setAnimal(animal1);
		assertEquals(animal1,sel.getAnimal());
	}

	@Test
	public void testGetHabitat() {
		Cell sel = new Cell('X',1,2);
		sel.setHabitat("W");
		assertEquals("W",sel.getHabitat());
	}

	@Test
	public void testSetHabitat() {
		Cell sel = new Cell('X',1,2);
		sel.setHabitat("W");
		assertEquals("W",sel.getHabitat());
	}

	@Test
	public void testGetFacility() {
		Cell sel = new Cell('X',1,2);
		sel.setFacility("P");
		assertEquals("P",sel.getFacility());
	}

	@Test
	public void testSetFacility() {
		Cell sel = new Cell('X',1,2);
		sel.setFacility("P");
		assertEquals("P",sel.getFacility());
	}
}
