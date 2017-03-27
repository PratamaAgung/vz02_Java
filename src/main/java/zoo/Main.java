import animal.*;
import driver.Driver;
import cage.*;
import zoo.*;

public class Main{
	public static void main (String [] args) {
		Driver driver = new Driver();
		AnimalHandler animalHandler= new AnimalHandler();
		animalHandler=driver.parseAnimal();
//		for(int i=0; i<animalHandler.nbAnimal(); i++) {
//			System.out.println(animalHandler.getAnimal(i).getSpesies());
//		}
		
		CageHandler cageHandler= new CageHandler();
		cageHandler= driver.parseCage();
//		for(int i=1; i<=cageHandler.getNbCage(); i++) {
//			System.out.println(cageHandler.getCage(i).getHabitat());
//		}
		
		Zoo zoo = null;
		zoo = driver.parseCell(cageHandler);
//		for(int i=0; i<zoo.getLength(); i++) {
//			for(int j=0; j<zoo.getWidth(); j++) {
//				System.out.println(zoo.getCell(j, i).getAbsis());
//			}
//		}
		driver.displayVirtualZoo(zoo);
	}
}