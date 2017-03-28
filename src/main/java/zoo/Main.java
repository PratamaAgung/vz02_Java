import java.util.Scanner;

import animal.*;
import driver.Driver;
import cage.*;
import zoo.Zoo;

public class Main{
	public static void main (String [] args) {
		Driver driver = new Driver();
		boolean finished = false;
		int option;
		
		CageHandler cageHandler = new CageHandler();
		cageHandler = driver.parseCage();
	
		Zoo zoo;
		zoo = driver.parseCell(cageHandler);
		
		AnimalHandler animalHandler= new AnimalHandler();
		animalHandler = driver.parseAnimal(zoo);
		System.out.println("Masukkan option Anda");
		System.out.println("1. Mencetak zoo");
		System.out.println("2. Tour zoo");
		System.out.println("3. Jumlah makanan zoo");
		System.out.println("4. Keluar");
		
		Scanner reader = new Scanner(System.in);
		while (!finished) {
			option = reader.nextInt();
			if(option == 1) {
				driver.displayVirtualZoo(zoo);
			} else if(option == 2) {
				driver.initPosition(zoo);
				driver.tourVirtualZoo(zoo);
				driver.moveAnimal(zoo, animalHandler);
			} else if(option == 3) {
				System.out.println("Jumlah kebutuhan makanan per hari adalah " + animalHandler.jumlahMakanan() + " gram");
			} else if(option == 4) {
				finished = true;
			} else {
				System.out.println("Not an option");
			}
			
		}
	}
}