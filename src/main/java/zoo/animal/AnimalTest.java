package animal;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {

  @Test
  public void testAnimal() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals(1,animal1.getPosisiX());
    assertEquals(2,animal1.getPosisiY());
    assertEquals(50,animal1.getMassa());
    assertEquals('O',animal1.getInisial());
    assertEquals("OrangUtan",animal1.getSpesies());
    assertEquals(true,animal1.isJinak());
    assertEquals("X",animal1.getType());
    assertEquals(1,animal1.getID());
  }

  @Test
  public void testSetJinak() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    animal1.setJinak(false);
    assertEquals(false,animal1.isJinak());
  }

  @Test
  public void testIsJinak() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals(true,animal1.isJinak());
  }

  @Test
  public void testGetInisial() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals('O',animal1.getInisial());
  }

  @Test
  public void testGetID() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals(1,animal1.getID());
  }

  @Test
  public void testGetMassa() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals(50,animal1.getMassa());
  }

  @Test
  public void testGetPosisiX() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals(1,animal1.getPosisiX());
  }

  @Test
  public void testGetPosisiY() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals(2,animal1.getPosisiY());
  }

  @Test
  public void testGetType() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals("X",animal1.getType());
  }

  @Test
  public void testSetMassa() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    animal1.setMassa(45);
    assertEquals(45,animal1.getMassa());
  }

  @Test
  public void testSetX() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    animal1.setX(9);
    assertEquals(9,animal1.getPosisiX());
  }

  @Test
  public void testSetY() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    animal1.setY(5);
    assertEquals(5,animal1.getPosisiY());
  }

  @Test
  public void testGetHabitat() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals("X",animal1.getHabitat());
  }

  @Test
  public void testAddHabitat() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    animal1.addHabitat('W');
    assertEquals("XW",animal1.getHabitat());
  }

  @Test
  public void testGetMakanan() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    int makanan = 50/30;
    assertEquals(makanan,animal1.getMakanan());
  }

  @Test
  public void testGetSpesies() {
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    assertEquals("OrangUtan",animal1.getSpesies());
  }

}
