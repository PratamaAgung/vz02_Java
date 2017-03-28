package cage;

import java.util.Vector;

/**
 * @author Annisa Muzdalifa.
 * @class CageHandler berfungsi memanage cage.
 */
public class CageHandler {
  private int nbCage;
  private Vector<Cage> cageList;

  /**
   * Konstruktor kelas CageHandler.
   */
  public CageHandler() {
    cageList = new Vector<Cage>();
    nbCage = 0;
  }

  /**
   * Getter untuk data atribut Cage.
   * @param id id dari Cage yang ingin diambil.
   * @return Cage yang.
   */
  public Cage getCage(int id) {
    boolean found = false;
    int i = 0;
    while ((!found) && (i < nbCage)) {
      if (cageList.elementAt(i).getId() == id) {
        found = true;
      } else {
        i++;
      }
    }
    if (found) {
      return cageList.elementAt(i);
    } else {
      return null;
    }
  }

  /**
   * Method untuk mendapatkan banyak elemen cage yang ada.
   * @return banyaknya cage yang ada.
   */
  public int getNbCage() {
    return nbCage;
  }

  /**
   * Method untuk menambahkan cage.
   * @param cage Cage yang ingin ditambahkan.
   */
  public void addCage(Cage cage) {
    cageList.addElement(cage);
    nbCage++;
  }
}