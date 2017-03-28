package animal;

/**
 * @author Iftitakhul Zakiah.
 * @class Animal merepresentasikan atribut dan method apa saja dari animal yang
   berada dalam virtual zoo.
 */
public class Animal {
  private int abs;
  private int ord;
  private int massa;
  private boolean jinak;
  private String type;
  private int id;
  private char inisial;
  private String nama;
  private String interaksi;
  private int ratio = 30;

  /**
   * Konstruktor untuk kelas Animal.
   * @param absis lokasi absis untuk kelas animal.
   * @param ordinat lokasi ordinat untuk kelas animal.
   * @param m massa dari animal.
   * @param c karakter print dari animal.
   * @param nama nama spesies dari animal.
   * @param interaksi interaksi yang diberikan oleh animal.
   * @param jinak apakah animal tersebut jinak.
   * @param habitat habitat dari animal.
   * @param idInput id dari animal.
   */
  public Animal(int absis, int ordinat, int m, char c, String nama, String interaksi,
      boolean jinak, String habitat, int idInput) {
    inisial = c;
    this.nama = nama;
    this.interaksi = interaksi;
    this.jinak = jinak;
    id = idInput;
    type = habitat;
    abs = absis;
    ord = ordinat;
    massa = m;
  }

  /**
   * Methos untuk menentukan kejinakan suatu hewan.
   * @param jinakInput merepresentasikan apakah suatu object jinak atau tidak.
   */
  public void setJinak(boolean jinakInput) {
    jinak = jinakInput;
  }

  /**
   * Getter dari data elemen jinak.
   * @return Mengembalikan true pada atribut jinak jika suatu object jinak.
   */
  public boolean isJinak() {
    return jinak;
  }

  /**
   * Getter dari data member inisial.
   * @return Mengembalikan inisial dari suatu object.
   */
  public char getInisial() {
    return inisial;
  }

  /**
   * Getter untuk data member ID.
   * @return Mengembalikan nilai ID dari suatu object.
   */
  public int getId() {
    return id;
  }

  /**
   * Getter untuk data member massa.
   * @return Mengembalikan nilai massa dari suatu object Animal.
   */
  public int getMassa() {
    return massa;
  }

  /**
   * Getter untuk data member absis.
   * @return Mengembalikan nilai koordinat object pada sumbu X.
   */
  public int getPosisiX() {
    return abs;
  }

  /**
   * Getter untuk data member ordinat.
   * @return Mengembalikan nilai koordinat object pada sumbu Y.
   */
  public int getPosisiY() {
    return ord;
  }

  /**
   * Getter untuk data memebr type.
   * @return Mengembalikan type dari object sesuai dengan habitat hidupnya.
   */
  public String getType() {
    return type;
  }

  /**
   * Setter untuk data member massa.
   * @param kg merepresentasikan massa dari sebuah objcet Animal.
   */
  public void setMassa(int kg) {
    massa = kg;
  }

  /**
   * Setter untuk data member absis.
   * @param absInput merepresentasikan posisi object pada sumbu X.
   */
  public void setX(int absInput) {
    abs = absInput;
  }

  /**
   * Setter untuk data member.
   * @param ordInput merepresentasikan posisi object pada sumbu y.
   */
  public void setY(int ordInput) {
    ord = ordInput;
  }

  /**
   * Method render() berfungsi untuk menampilkan inisial dari object ke layar.
   * @return mengembalikan character simbol hewan yang akan dicetak ke layar.
   */
  public char render() {
    return inisial;
  }

  /**
   * Getter untuk data member habitat.
   * @return Mengembalikan habitat dari object Animal.
   */
  public String getHabitat() {
    return type;
  }

  /**
   * Setter untuk data member habitat.
   * @param c merupakan habitat dari object Animal.
   */
  public void addHabitat(char c) {
    type += c;
  }

  /**
   * Mendapatkan data banyak makanan.
   * @return Mengembalikan nilai makanan yang dibutuhkan object per hari.
   */
  public int getMakanan() {
    return massa / ratio;
  }

  /**
   * Method interact() bertujuan untuk menampilkan hasil interaksi object dengan pengunjung.
   * @return mengembalikan string interaksi animal yang akan dicetak ke layar.
   */
  public String interact() {
    return interaksi;
  }

  /**
   * Getter untuk data member spesies.
   * @return Fungsi getSpesies() bertujuan untuk mengembalikan nama spesies dari sebuah object.
   */
  public String getSpesies() {
    return nama;
  }
}