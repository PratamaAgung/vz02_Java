package cage;
import java.util.Vector;

/**
 * @author Annisa Muzdalifa.
 * @class CageHandler berfungsi memanage cage.
 */
public class CageHandler {
  private int nb_cage;
  private Vector<Cage> cage_list;

  /**
   * Konstruktor kelas CageHandler
   */
  public CageHandler() {
    cage_list = new Vector<Cage>();
    nb_cage = 0;
  }

  /**
   * Getter untuk data atribut Cage.
   * @param id id dari Cage yang ingin diambil.
   * @return Cage yang.
   */
  public Cage getCage(int id) {
    boolean found = false;
    int i=0;
    while((!found) && (i<nb_cage)){
      if(cage_list.elementAt(i).getId() == id)
        found=true;
      else
        i++;
    }
    if(found)
      return cage_list.elementAt(i);
    else
      return null;
  }

  /**
   * Method untuk mendapatkan banyak elemen cage yang ada.
   * @return banyaknya cage yang ada.
   */
  public int getNbCage() {
    return nb_cage;
  }

  /**
   * Method untuk menambahkan cage.
   * @param cage Cage yang ingin ditambahkan.
   */
  public void addCage(Cage cage) {
    cage_list.addElement(cage);
    nb_cage++;
  }
}