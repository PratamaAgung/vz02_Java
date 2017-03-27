package zoo;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import animal.*;
import cage.*;
import cell.*;

public class Zoo
{
	private Cell[][] c;
	private Vector<Cell> entrance;
	private Vector<Cell> exit;
	private final int width;
	private final int length;

	public Zoo(int l, int w) {
		length = l;
		width = w;
		c = new Cell[length][width];
		entrance = new Vector<Cell> (20);
		exit = new Vector<Cell> (20);
	}

	public void setCell(int x, int y, Cell cell) {
		c[y][x] = cell;
	}

	public Cell getCell(int x, int y) {
		return c[y][x];
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public void addEntrance(Cell e) {
		entrance.addElement(e);
	}

	public void addExit(Cell x) {
		exit.addElement(x);
	}

	public Cell getEntrance(int i) {
		return entrance.elementAt(i);
	}

	public Cell getExit(int i) {
		return exit.elementAt(i);
	}

	public int nbEntrance() {
		return entrance.size();
	}

	public int nbExit() {
		return exit.size();
	}
}