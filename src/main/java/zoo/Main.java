import animal.AnimalHandler;
import cage.CageHandler;
import cell.Cell;
import driver.Driver;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import zoo.Zoo;

public class Main {

  private JFrame frame;
  private JTextArea [][] map;
  private JButton btnMap;
  private JButton btnTour;
  private JButton btnFood;
  private JButton btnExit;
  private JLabel labelInteract;
  private JTextArea textInteract;
  private JLabel title;
  private int posisiX;
  private int posisiY;
  private boolean[][] visited;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    Driver driver = new Driver();
    CageHandler cageHandler = new CageHandler();
    cageHandler = driver.parseCage();

    Zoo zoo;
    zoo = driver.parseCell(cageHandler);

    AnimalHandler animalHandler;
    animalHandler = driver.parseAnimal(zoo);

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main(zoo, animalHandler);
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Main(Zoo zoo, AnimalHandler animalHandler) {
    initialize(zoo, animalHandler);
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize(Zoo zoo, AnimalHandler animalHandler) {
    frame = new JFrame("VZ19 Zoo");
    frame.setBounds(100, 100, 1000, 750);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    visited = new boolean[zoo.getLength()][zoo.getWidth()];
    map = new JTextArea [20][20];
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
        map[i][j] = new JTextArea();
        map[i][j].setBounds(50 + i * 25, 100 + j * 25, 25, 25);
        map[i][j].setBackground(Color.lightGray);
        map[i][j].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        map[i][j].setEditable(false);
        frame.getContentPane().add(map[i][j]);
      }
    }

    btnMap = new JButton("Zoo Map");
    btnMap.setBounds(50, 700, 225, 25);
    btnMap.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        displayZoo(zoo);
      }
    });
    frame.getContentPane().add(btnMap);

    btnTour = new JButton("Tour Zoo");
    btnTour.setBounds(275, 700, 225, 25);
    btnTour.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        displayZoo(zoo);
        initPosition(zoo);
        tourVirtualZoo(zoo);
        moveAnimal(zoo, animalHandler);
      }
    });
    frame.getContentPane().add(btnTour);

    btnFood = new JButton("Food");
    btnFood.setBounds(500, 700, 225, 25);
    btnFood.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textInteract.setText("Makanan yang dibutuhkan sebanyak "
            + Integer.toString(animalHandler.jumlahMakanan()));
      }
    });
    frame.getContentPane().add(btnFood);

    btnExit = new JButton("Exit");
    btnExit.setBounds(725, 700, 225, 25);
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
      }
    });
    frame.getContentPane().add(btnExit);


    labelInteract = new JLabel("Console:");
    labelInteract.setBounds(600, 100, 100, 10);
    frame.getContentPane().add(labelInteract);

    textInteract = new JTextArea();
    textInteract.setBounds(600, 125, 300, 250);
    textInteract.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    frame.getContentPane().add(textInteract);

    title = new JLabel("Virtual Zoo");
    title.setFont(new Font("Courier New", Font.PLAIN, 33));
    title.setBounds(425, 25, 300, 25);
    frame.getContentPane().add(title);
  }

  /**
   * Method untuk menampilkan zoo ke layar.
   * @param zoo Zoo yang akan ditampilkan.
   */
  private void displayZoo(Zoo zoo) {
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
        map[j][i].setText(Character.toString(zoo.getCell(j, i).render()));
        map[j][i].setBackground(getCellColor(zoo.getCell(j, i)));
      }
    }
  }

  /**
   * Mengambil warna cell sesuai dengan jenisnya.
   * @param cell Cell yang akan ditentukan warnanya.
   * @return warna dari cell tersebut.
   */
  private Color getCellColor(Cell cell) {
    if (cell.getType() == 'w') {
      return Color.BLUE;
    } else if (cell.getType() == 'x') {
      return Color.ORANGE;
    } else if (cell.getType() == 'o') {
      return Color.WHITE;
    } else if (cell.getType() == 'R') {
      return Color.YELLOW;
    } else if (cell.getType() == '*') {
      return Color.GREEN;
    } else {
      return Color.GRAY;
    }
  }

  /**
   * Method untuk mengisnisiasi tour.
   * @param z Zoo yang akan dilakukan tour.
   */
  public void initPosition(Zoo z) {
    Random rand = new Random(System.currentTimeMillis());
    int idx = rand.nextInt(z.nbEntrance());
    posisiX = z.getEntrance(idx).getAbsis();
    posisiY = z.getEntrance(idx).getOrdinat();

    for (int i = 0; i < z.getLength(); i++) {
      for (int j = 0; j < z.getWidth(); j++) {
        visited[i][j] = false;
      }
    }

    textInteract.setText("");
  }

  /**
   * Method untuk melakukan tour virtual zoo.
   * @param z Zoo yang akan dilakukan tour.
   */
  public void tourVirtualZoo(Zoo z) {
    Random rand = new Random(System.currentTimeMillis());
    boolean finish = false;

    while (!finish) {
      int init = rand.nextInt(4);
      boolean found = false;
      int i = 0;

      while (!found && i < 4) {
        if (init == 0) {
          if ((posisiY - 1 >= 0) && (z.getCell(posisiX, posisiY - 1).getType() == ' ')
              && (!visited[posisiY - 1][posisiX])) {
            found = true;
            visited[posisiY][posisiX] = true;
            posisiY--;
          } else {
            init++;
          }
        } else if (init == 1) {
          if ((posisiX + 1 < z.getWidth()) && (z.getCell(posisiX + 1, posisiY).getType() == ' ')
              && (!visited[posisiY][posisiX + 1])) {
            found = true;
            visited[posisiY][posisiX] = true;
            posisiX++;
          } else {
            init++;
          }
        } else if (init == 2) {
          if ((posisiY + 1 < z.getLength()) && (z.getCell(posisiX, posisiY + 1).getType() == ' ')
              && (!visited[posisiY + 1][posisiX])) {
            found = true;
            visited[posisiY][posisiX] = true;
            posisiY++;
          } else {
            init++;
          }
        } else if (init == 3) {
          if ((posisiX - 1 >= 0) && (z.getCell(posisiX - 1, posisiY).getType() == ' ')
              && (!visited[posisiY][posisiX - 1])) {
            found = true;
            visited[posisiY][posisiX] = true;
            posisiX--;
          } else {
            init = 0;
          }
        }
        if (!found) {
          i++;
        }
      }
      if (!found) {
        finish = true;
        textInteract.append("No next move found!\n");
      } else {
        textInteract.append("You're in: " + posisiX + " " + posisiY + "\n");
        if (posisiY - 1 >= 0 && z.getCell(posisiX, posisiY - 1).getAnimal() != null) {
          textInteract.append(z.getCell(posisiX, posisiY - 1).getAnimal().interact() + "\n");
        }
        if (posisiX - 1 >= 0 && z.getCell(posisiX - 1, posisiY).getAnimal() != null) {
          textInteract.append(z.getCell(posisiX - 1, posisiY).getAnimal().interact() + "\n");
        }
        if (posisiY + 1 < z.getLength() && z.getCell(posisiX, posisiY + 1).getAnimal() != null) {
          textInteract.append(z.getCell(posisiX, posisiY + 1).getAnimal().interact() + "\n");
        }
        if (posisiX + 1 < z.getWidth() && z.getCell(posisiX + 1, posisiY).getAnimal() != null) {
          textInteract.append(z.getCell(posisiX + 1, posisiY).getAnimal().interact() + "\n");
        }
        for (i = 0; i < z.nbExit(); i++) {
          if (z.getExit(i).getAbsis() == posisiX && z.getExit(i).getOrdinat() == posisiY) {
            finish = true;
            visited[posisiY][posisiX] = true;
            textInteract.append("You are in an exit!");
          }
        }
      }
    }
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
        if (visited[i][j]) {
          map[j][i].setBackground(Color.red);
        }
      }
    }
  }

  /**
   * Method untuk melakukan perpindahan animal.
   * @param z Zoo tempat animal berada.
   * @param ah animalHandler.
   */
  public void moveAnimal(Zoo z, AnimalHandler ah) {
    Random rand = new Random(System.currentTimeMillis());
    for (int i = 0; i < ah.nbAnimal(); i++) {
      int init = rand.nextInt(4);
      int x = ah.getAnimal(i).getPosisiX();
      int y = ah.getAnimal(i).getPosisiY();
      int cage = z.getCell(x, y).getCage().getId();

      if (init == 0) {
        if (y - 1 >= 0 && z.getCell(x, y - 1).getCage() != null
            && z.getCell(x, y - 1).getCage().getId() == cage
            && z.getCell(x, y - 1).getAnimal() == null) {
          ah.getAnimal(i).setY(y - 1);
          z.getCell(x, y).setAnimal(null);
          z.getCell(x, y - 1).setAnimal(ah.getAnimal(i));
        }
      } else if (init == 1) {
        if (x + 1 < z.getWidth() && z.getCell(x + 1, y).getCage() != null
            && z.getCell(x + 1, y).getCage().getId() == cage
            && z.getCell(x + 1, y).getAnimal() == null) {
          ah.getAnimal(i).setX(x + 1);
          z.getCell(x, y).setAnimal(null);
          z.getCell(x + 1, y).setAnimal(ah.getAnimal(i));
        }
      } else if (init == 2) {
        if (y + 1 < z.getLength() && z.getCell(x, y + 1).getCage() != null
            && z.getCell(x, y + 1).getCage().getId() == cage
            && z.getCell(x, y + 1).getAnimal() == null) {
          ah.getAnimal(i).setY(y + 1);
          z.getCell(x, y).setAnimal(null);
          z.getCell(x, y + 1).setAnimal(ah.getAnimal(i));
        }
      } else if (init == 3) {
        if (x - 1 >= 0 && z.getCell(x - 1, y).getCage() != null
            && z.getCell(x - 1, y).getCage().getId() == cage
            && z.getCell(x - 1, y).getAnimal() == null) {
          ah.getAnimal(i).setX(x - 1);
          z.getCell(x, y).setAnimal(null);
          z.getCell(x - 1, y).setAnimal(ah.getAnimal(i));
        }
      }
    }
  }
}
