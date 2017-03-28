package cage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CageHandlerTest {

  @Test
  public void testCageHandler() {
    CageHandler cagehandler = new CageHandler();
    assertEquals(0, cagehandler.getNbCage());
  }

  @Test
  public void testAddCage() {
    CageHandler cagehandler = new CageHandler();
    Cage cage = new Cage(1, 'x');
    cagehandler.addCage(cage);
    assertEquals(1, cagehandler.getNbCage());
  }

  @Test
  public void testGetCage() {
    CageHandler cagehandler = new CageHandler();
    Cage cage = new Cage(1, 'x');
    cagehandler.addCage(cage);
    assertEquals(cage, cagehandler.getCage(1));
  }

}
