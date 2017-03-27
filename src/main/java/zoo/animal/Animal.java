package animal;
import java.util.*;

/**
 * @class Animal merepresentasikan atribut dan method apa saja dari animal yang berada dalam virtual zoo
 */
public class Animal{
	private int x;
	private int y;
	private int massa;
	private boolean jinak;
	private String type;
	private int ID;
	private char inisial;
	private String nama;
	private String interaksi;
	private int ratio=30;
	/**
	 * Constructor
	 */
	public Animal(int absis, int ordinat, int m, char c, String nama, String interaksi, boolean jinak, String habitat, int i) {
		inisial = c;
		this.nama = nama;
		this.interaksi = interaksi;
		this.jinak = jinak;
		ID = i;
		type = habitat;
		x = absis;
		y = ordinat;
		massa = m;
	}
	/**
	 * @param _jinak merepresentasikan apakah suatu object jinak atau tidak
	 */
	public void setJinak(boolean _jinak) {
		jinak = _jinak;
	}
	/**
	 * @return Mengembalikan true pada atribut jinak jika suatu object jinak
	 */
	public boolean isJinak() {
		return jinak;
	}
	/**
	 * @return Mengembalikan inisial dari suatu object
	 */
	public char getInisial() {
		return inisial;
	}
	/**
	 * @return Mengembalikan nilai ID dari suatu object
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @return Mengembalikan nilai massa dari suatu object Animal
	 */
	public int getMassa() {
		return massa;
	}
	/**
	 * @return Mengembalikan nilai koordinat object pada sumbu X
	 */
	public int getPosisiX() {
		return x;
	}
	/**
	 * @return Mengembalikan nilai koordinat object pada sumbu Y
	 */
	public int getPosisiY() {
		return y;
	}
	/**
	 * @return Mengembalikan type dari object sesuai dengan habitat hidupnya
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param kg merepresentasikan massa dari sebuah objcet Animal
	 */
	public void setMassa(int kg) {
		massa = kg;
	}
	/**
	 * @param _x merepresentasikan posisi object pada sumbu X
	 */
	public void setX(int _x) {
		x = _x;
	}
	/**
	 * @param _y merepresentasikan posisi object pada sumbu y
	 */
	public void setY(int _y) {
		y = _y;
	}
	/**
	 * Method render() berfungsi untuk menampilkan inisial dari object ke layar
	 */
	public void render() {
		System.out.println("\033[1;31m" + inisial + ' '+ "\033[0m"); 
	}
	/**
	 * @return Mengembalikan habitat dari object Animal
	 */
	public String getHabitat() {
		return type;
	}
	/**
	 * @param c merupakan habitat dari object Animal
	 */
	public void addHabitat(char c) {
		type += c;
	}
	/**
	 * @return Mengembalikan nilai makanan yang dibutuhkan object per hari
	 */
	public int getMakanan() {
		return massa/ratio;
	}
	/**
	 * Method interact() bertujuan untuk menampilkan hasil interaksi object dengan pengunjung
	 */
	public void interact() {
		System.out.println(nama + ": " + interaksi);
	}
	/**
	 * @return Fungsi getSpesies() bertujuan untuk mengembalikan nama spesies dari sebuah object
	 */
	public String getSpesies() {
		return nama;
	}
}