package zoo;

import cell.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ZooTest {

  @Test
  public void testZoo() {
    Zoo zoo = new Zoo(80,100);
    assertEquals(80,zoo.getLength());
    assertEquals(100,zoo.getWidth());
  }

  @Test
  public void testSetCell() {
    Zoo zoo = new Zoo(20,20);
    Cell cell = new Cell('w',1,7);
    zoo.setCell(1, 7, cell);
    assertEquals(cell, zoo.getCell(1, 7));
  }

  @Test
  public void testGetCell() {
    Zoo zoo = new Zoo(20,20);
    Cell cell = new Cell('w',1,7);
    zoo.setCell(1, 7, cell);
    assertEquals(cell, zoo.getCell(1, 7));
  }

  @Test
  public void testGetWidth() {
	 Zoo zoo = new Zoo(10,19);
	 assertEquals(19,zoo.getWidth());
  }

  @Test
  public void testGetLength() {
	Zoo zoo = new Zoo(14,28);
	assertEquals(14,zoo.getLength());
  }

  @Test
  public void testAddEntrance() {
	Zoo zoo = new Zoo(20,20);
	Cell cell = new Cell(' ',3,3);
	zoo.addEntrance(cell);
	assertEquals(1,zoo.nbEntrance());
  }

  @Test
  public void testAddExit() {
	Zoo zoo = new Zoo(20,20);
	Cell cell = new Cell(' ',3,3);
	zoo.addExit(cell);
	assertEquals(1,zoo.nbExit());
  }

  @Test
  public void testGetEntrance() {
	Zoo zoo = new Zoo(20,20);
	Cell cell = new Cell(' ',3,3);
	zoo.addEntrance(cell);
	assertEquals(cell,zoo.getEntrance(0));
  }

  @Test
  public void testGetExit() {
	Zoo zoo = new Zoo(20,20);
	Cell cell = new Cell(' ',3,3);
	zoo.addExit(cell);
	assertEquals(cell,zoo.getExit(0));
  }

  @Test
  public void testNbExit() {
	Zoo zoo = new Zoo(20,20);
	Cell cell = new Cell(' ',3,3);
	zoo.addExit(cell);
	zoo.addExit(cell);
	zoo.addExit(cell);
	assertEquals(3,zoo.nbExit());
  }

  @Test
  public void testNbEntrance() {
	Zoo zoo = new Zoo(20,20);
	Cell cell = new Cell(' ',3,3);
	zoo.addEntrance(cell);
	zoo.addEntrance(cell);
	zoo.addEntrance(cell);
	assertEquals(3,zoo.nbEntrance());
  }
}
