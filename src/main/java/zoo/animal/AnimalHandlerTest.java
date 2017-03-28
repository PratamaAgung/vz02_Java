package animal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalHandlerTest {

  @Test
  public void testGetAnimal() {
    AnimalHandler anhand = new AnimalHandler();
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    Animal animal2 = new Animal(3,4,55,'O',"OrangUtan","Auuuooo",true,"X",2);
    anhand.addAnimal(animal1);
    anhand.addAnimal(animal2);
    assertEquals(animal2,anhand.getAnimal(1));
  }

  @Test
  public void testNbAnimal() {
    AnimalHandler anhand = new AnimalHandler();
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    Animal animal2 = new Animal(3,4,55,'O',"OrangUtan","Auuuooo",true,"X",2);
    anhand.addAnimal(animal1);
    anhand.addAnimal(animal2);
    assertEquals(2,anhand.nbAnimal());
  }

  @Test
  public void testAddAnimal() {
    AnimalHandler anhand = new AnimalHandler();
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    Animal animal2 = new Animal(3,4,55,'O',"OrangUtan","Auuuooo",true,"X",2);
    anhand.addAnimal(animal1);
    anhand.addAnimal(animal2);
    assertEquals(animal1,anhand.getAnimal(0));
  }

  @Test
  public void testJumlahMakanan() {
    AnimalHandler anhand = new AnimalHandler();
    Animal animal1 = new Animal(1,2,50,'O',"OrangUtan","Auuuooo",true,"X",1);
    anhand.addAnimal(animal1);
    int makanan = anhand.getAnimal(0).getMassa() / 30;
    assertEquals(makanan,anhand.jumlahMakanan());

  }

}
