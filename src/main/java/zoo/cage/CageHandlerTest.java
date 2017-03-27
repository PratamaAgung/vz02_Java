package cage;

import static org.junit.Assert.*;

import org.junit.Test;

public class CageHandlerTest {

	@Test
	public void testCageHandler() {
		CageHandler c_handler = new CageHandler();
		assertEquals(0, c_handler.getNbCage());
	}
	
	@Test
	public void testAddCage() {
		CageHandler c_handler = new CageHandler();
		Cage cage = new Cage(1, 'x');
		c_handler.addCage(cage);
		assertEquals(1, c_handler.getNbCage());
	}
	
	@Test
	public void testGetCage() {
		CageHandler c_handler = new CageHandler();
		Cage cage = new Cage(1, 'x');
		c_handler.addCage(cage);
		assertEquals(cage, c_handler.getCage(1));
	}

}
