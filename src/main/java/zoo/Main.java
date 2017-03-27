import animal.*;
import driver.Driver;

public class Main{
	public static void main (String [] args) {
		Driver driver = new Driver();
		AnimalHandler animalHandler= new AnimalHandler();
		animalHandler=driver.parseAnimal();
		for(int i=0; i<animalHandler.nbAnimal(); i++) {
			System.out.println(animalHandler.getAnimal(i).getSpesies());
		}
	}
}