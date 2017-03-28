package cage;

import animal.Animal;
import java.util.Vector;

/**
 * @class Cage merepresentasikan tempat hidup hewan.
 */
public class Cage {
  private int id;
  private char habitat;
  private int luas;
  private Vector<Animal> animalList;

  /**
   * Constructor.
   */
  public Cage() {
    animalList = new Vector<Animal>();
    luas = 0;
    id = 0;
    habitat = 'x';
  }

  /**
   * Constructor dengan parameter.
   * @param idInput ID dari animal.
   * @param habInput habitat dari hewan.
   */
  public Cage(int idInput, char habInput) {
    animalList = new Vector<Animal>();
    luas = 0;
    id = idInput;
    habitat = habInput;
  }

  /**
   * I.S : Cage terdefinisi.
   * F.S : Cage berisi animal terbaru.
   * @param animal merepresentasikan binatang yang ingin dimasukan cage.
   */
  public void addAnimal(Animal animal) {
    boolean feasible = false;
    int i = 0;

    while ((!feasible) && i < animal.getHabitat().length()) {
      if (animal.getHabitat().charAt(i) == this.getHabitat()) {
        feasible = true;
      } else {
        i++;
      }
    }

    if (feasible) {
      if (animalList.size() == 0) {
        animalList.addElement(animal);
      } else {
        if (animal.isJinak()) {
          if (this.isIsiJinak()) {
            if (this.isAvailable()) {
              animalList.addElement(animal);
            }
          }
        } else {
          if (animalList.elementAt(0).getInisial() == animal.getInisial()) {
            if (this.isAvailable()) {
              animalList.addElement(animal);
            }
          }
        }
      }
    }
  }

  /**
   * @param cell Cell yang menjadi bagian cage.
   */
  public void addCell(char cell) {
    if (cell == this.getHabitat()) {
      luas++;
    }
  }

  /**
   * @return luas Cage.
   */
  public int getLuas() {
    return luas;
  }

  /**
   * @return id cage.
   */
  public int getId() {
    return id;
  }

  /**
   * @return jenis habitat Cage.
   */
  public char getHabitat() {
    return habitat;
  }

  /**
   * @return list animal yang ada di cage.
   */
  public int getNbAnimal() {
    return animalList.size();
  }

  /**
   * @return apakah cage dapat ditempati suatu animal atau tidak.
   */
  public boolean isAvailable() {
    return (getNbAnimal() < ((3 * luas) / 10));
  }

  /**
   * @return apakah binatang dalam hewan bersifat jinak atau tidak.
   */
  public boolean isIsiJinak() {
    boolean found = false;
    int i = 0;
    while ((!found) && i < animalList.size()) {
      if (!(animalList.elementAt(i).isJinak())) {
        found = true;
      } else {
        i++;
      }
    }
    return (!found);
  }
}