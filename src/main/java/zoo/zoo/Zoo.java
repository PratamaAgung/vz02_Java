package zoo;

import cell.Cell;
import java.util.Vector;

/**
 * Kelas yang merepresentasikan kebun binatang.
 * @author Jehian Norman Saviero.
 */
public class Zoo {
  private Cell[][] cell;
  private Vector<Cell> entrance;
  private Vector<Cell> exit;
  private final int width;
  private final int length;

  /**
   * Konstruktor kelas Zoo.
   * @param l panjang dari zoo.
   * @param w lebar dari zoo.
   */
  public Zoo(int l, int w) {
    length = l;
    width = w;
    cell = new Cell[length][width];
    entrance = new Vector<Cell>(20);
    exit = new Vector<Cell>(20);
  }

  /**
   * Setter untuk data member cell.
   * @param x lokasi absis dari cell.
   * @param y lokasi ordinat dari cell.
   * @param newCell objek cell yang akan dimasukkan.
   */
  public void setCell(int x, int y, Cell newCell) {
    cell[y][x] = newCell;
  }

  /**
   * Getter untuk data member cell.
   * @param x lokasi absis dari cell yang ingin diambil.
   * @param y lokasi ordinat dari cell yang ingin diambil.
   * @return Cell yang dimaksud.
   */
  public Cell getCell(int x, int y) {
    return cell[y][x];
  }

  /**
   * Getter untuk data member width.
   * @return lebar dari zoo.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Getter untuk dat member length.
   * @return panjang dari zoo.
   */
  public int getLength() {
    return length;
  }

  /**
   * Method untuk menambah entrance.
   * @param e entrance yang akan ditambahkan
   */
  public void addEntrance(Cell e) {
    entrance.addElement(e);
  }

  /**
   * Method untuk menambah exit.
   * @param x exit yang akan ditambahkan.
   */
  public void addExit(Cell x) {
    exit.addElement(x);
  }

  /**
   * Getter untuk data entrance.
   * @param i index dari entrance yag ingin diambil.
   * @return entrance yang ditunjuk oleh i.
   */
  public Cell getEntrance(int i) {
    return entrance.elementAt(i);
  }

  /**
   * Getter untuk data exit.
   * @param i indeks dari exit yang ingin diambil.
   * @return exit yang ditunjuk oleh i.
   */
  public Cell getExit(int i) {
    return exit.elementAt(i);
  }

  /**
   * Method untuk mendapatkan banyak entrance.
   * @return banyak entrance.
   */
  public int nbEntrance() {
    return entrance.size();
  }

  /**
   * Method untuk mendapatkan banyak exit.
   * @return banyak exit.
   */
  public int nbExit() {
    return exit.size();
  }
}