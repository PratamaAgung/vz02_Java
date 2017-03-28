package animal;
import java.util.*;

/**
 * @author iftitakhul zakiah
 * @class AnimalHandler
 * kelas ini bertujuan untuk mengatur animal-animal pada virtual zoo secara keseluruhan
 */
public class AnimalHandler {
  private Vector<Animal> animallist; //Implementasinya " animalList.addElement(new Animal(lalalalala)); " cmiiw
	private int n;

	/**
	 * Constructor
	 */
	public AnimalHandler() {
		n = 0;
		animallist= new Vector<Animal> (50);
	}
	/**
	 * Fungsi getAnimal bertujuan untuk mendapatkan animal dengan urutan id
	 * @param id adalah nomer id dari animal yang dicari
	 * @return Mengembalikan animal sesuai dengan id
	 */
	public Animal getAnimal(int idx) {
		return animallist.get(idx);
	}
	/**
	 * @return Mengembalikan banyaknya animal dalam virtual zoo
	 */
	public int nbAnimal() {
		return n;
	}
	/**
	 * Menambahkna animal a ke dalam virtual zoo
	 * @param a merupakan animal yang akan dimasukkan ke dalam virtual zoo
	 */
	public void addAnimal(Animal a) {
		animallist.addElement(a);
		n++;
	}
	/**
	 * @return Jumlah makanan dari semua animal yang ada pada virtual zoo dalam satuan gram
	 */
	public int jumlahMakanan() {
		int sum = 0;
		for(int i = 0; i < animallist.size(); i++)
		{
			sum += animallist.get(i).getMakanan();
		}
		return sum;
	}
}