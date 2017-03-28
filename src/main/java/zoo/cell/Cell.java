package cell;

import animal.Animal;
import cage.Cage;

/**
 * @class Cell merepresentasikan unit-unit pembangun virtual zoo.
 */
public class Cell {
  private Animal animal;
  private Cage cage;
  private String facility;
  public String habitat;
  public final char type;
  public final int absis;
  public final int ordinat;

  /**
   * Constructor.
   * @param c merepresentasikan type dari cell.
   * @param x absis lokasi cell.
   * @param y ordinat lokasi cell.
   */
  public Cell(char c, int x, int y) {
    type = c;
    absis = x;
    ordinat = y;
  }

  /**
   * Getter untuk data atribut type.
   * @return type dari cell.
   */
  public char getType() {
    return type;
  }

  /**
   * Getter untuk data atribut absis.
   * @return absis dari cell.
   */
  public int getAbsis() {
    return absis;
  }

  /**
   * Getter untuk data atribut ordinat.
   * @return ordinat dari cell.
   */
  public int  getOrdinat() {
    return ordinat;
  }

  /**
   * Getter untuk data atribut cage.
   * @return cage dari cell.
   */
  public Cage getCage() {
    return cage;
  }

  /**
   * Setter untuk data atribut cage.
   * @param cageInput objek Cage yang meliputi Cell.
   */
  public void setCage(Cage cageInput) {
    cage = cageInput;
  }

  /**
   * Getter untuk data atribut animal.
   * @return animal yang ada pada cell.
   */
  public Animal getAnimal() {
    return animal;
  }

  /**
   * Setter untuk data atribut animal.
   * @param animalInput animal yang akan dimasukkan ke dalam cell.
   */
  public void setAnimal(Animal animalInput) {
    animal = animalInput;
  }

  /**
   * Method untuk menghapus keberadaan animal pada suatu cell.
   */
  public void eraseAnimal() {
    animal = null;
  }

  /**
   * Getter untuk data atribut habitat.
   * @return jenis habitat dari cell.
   */
  public String getHabitat() {
    if (habitat.charAt(0) != '\0') {
      return habitat;
    } else {
      return "";
    }
  }

  /**
   * Setter untuk data atribut habitat.
   * @param habInput habitat dari cell.
   */
  public void setHabitat(String habInput) {
    habitat = habInput;
  }

  /**
   * Getter untuk data atribut facility.
   * @return fasilitas yang ada pada cell.
   */
  public String getFacility() {
    if (facility.charAt(0) != '\0') {
      return facility;
    } else {
      return "";
    }
  }

  /**
   * setter untuk data atribut facility.
   * @param facInput fasilitas yang ada pada cell.
   */
  public void setFacility(String facInput) {
    facility = facInput;
  }

  /**
   * method untuk mencetak isi dari cell ke layar.
   * @return character yang akan dicetak untuk di layar.
   */
  public char render() {
    if (animal == null) {
      return type;
    } else {
      return animal.render();
    }
  }
}