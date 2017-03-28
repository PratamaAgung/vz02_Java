package cage;

import animal.*;
import java.util.Vector;

/**
 * @class Cage merepresentasikan tempat hidup hewan.
 */
public class Cage {
  private int id;
  private char habitat;
  private int luas;
  private Vector<Animal> animal_list;

  /**
   * Constructor.
   */
  public Cage() {
    animal_list = new Vector<Animal>();
    luas = 0;
    id = 0;
    habitat = 'x';
  }
  /**
   * Constructor dengan parameter.
   */
  public Cage(int _id, char _habitat) {
    animal_list = new Vector<Animal>();
    luas = 0;
    id = _id;
    habitat = _habitat;

  }
  /**
   * I.S : Cage terdefinisi.
   * F.S : Cage berisi animal terbaru.
   * @param animal merepresentasikan binatang yang ingin dimasukan cage.
   */
  public void addAnimal(Animal animal) {
     boolean feasible = false;
     int i=0;

     while((!feasible) && i<animal.getHabitat().length()) {
       if(animal.getHabitat().charAt(i) == this.getHabitat())
         feasible=true;
       else
         i++;
     }

     if(feasible) {
       if(animal_list.size()==0) {
         animal_list.addElement(animal);
       }
       else{
         if(animal.isJinak()){
           if(this.isIsiJinak()){
             if(this.isAvailable())
               animal_list.addElement(animal);
           }
         }
        else{
           if(animal_list.elementAt(0).getInisial() == animal.getInisial()){
             if(this.isAvailable())
               animal_list.addElement(animal);  
           }
         }  
       }
     }
     
  }
  /**
   * @param cell Cell yang menjadi bagian cage.
   */
  public void addCell(char cell) {
    if(cell==this.getHabitat())
      luas++;
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
    return animal_list.size();
  }
  /**
   * @return apakah cage dapat ditempati suatu animal atau tidak.
   */
  public boolean isAvailable() {
    return(getNbAnimal() < ((3*luas)/10));
  }
  /**
   * @return apakah binatang dalam hewan bersifat jinak atau tidak.
   */
  public boolean isIsiJinak() {
    boolean found = false;
     int i = 0;
     while((!found) && i<animal_list.size()){
       if(!(animal_list.elementAt(i).isJinak()))
         found=true;
       else
        i++;
     }
     return (!found);
  }
  
}