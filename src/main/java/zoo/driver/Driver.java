package driver;

import animal.Animal;
import animal.AnimalHandler;
import cage.Cage;
import cage.CageHandler;
import cell.Cell;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import zoo.Zoo;


/**
 * @class untuk mendapatkan data dari file external.
 * @author pratamaagung Iftitakhul Zakiah.
 */
public class Driver {
  private int posisiX;
  private int posisiY;
  private int mapWidth;
  private int mapLength;

  /**
   * Konstruktor untuk kelas Driver.
   */
  public Driver() {
    try {
      FileReader fin = null;
      JSONParser parser = new JSONParser();

      fin = new FileReader("src/main/resource/map.json");
      JSONObject obj = (JSONObject) parser.parse(fin);
      mapWidth = new Long((long) obj.get("ZooWidth")).intValue();
      mapLength = new Long((long) obj.get("ZooLength")).intValue();
      fin.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

  }

  /**
   * Menentukan Animal jenis apa yang akan dibentuk.
   * @param abs posisi abs dari animal.
   * @param ord posis ord dari animal.
   * @param massa massa dari animal.
   * @param nama nama spesies dari animal.
   * @param jinak kejinakan dari animal.
   * @param id is dari animal.
   * @return animal yang telah dibentuk.
   */
  private Animal animalBuilder(int abs, int ord, int massa, String nama, boolean jinak, int id) {
    Animal animalCreated = null;
    if (nama.equals("Elang")) {
      animalCreated = new Animal(abs, ord, massa, '~', nama, "Kaaak!!", jinak, "o", id);
    } else if (nama.equals("Bekantan")) {
      animalCreated = new Animal(abs, ord, massa, 'A', nama, "(climb tree)", jinak, "x", id);
    } else if (nama.equals("BadakCulaSatu")) {
      animalCreated = new Animal(abs, ord, massa, 'B', nama, "(bathing in mud)", jinak, "x", id);
    } else if (nama.equals("Buaya")) {
      animalCreated = new Animal(abs, ord, massa, 'C', nama, "(open mouth)", jinak, "xw", id);
    } else if (nama.equals("Rusa")) {
      animalCreated = new Animal(abs, ord, massa, 'D', nama, "(flaunt horn)", jinak, "x", id);
    } else if (nama.equals("Parkit")) {
      animalCreated = new Animal(abs, ord, massa, 'E', nama, "cuit cuit", jinak, "o", id);
    } else if (nama.equals("Garuda")) {
      animalCreated = new Animal(abs, ord, massa, 'F', nama, "(spread wings)", jinak, "o", id);
    } else if (nama.equals("HarimauSumatra")) {
      animalCreated = new Animal(abs, ord, massa, 'H', nama, "AUUUM!!", jinak, "x", id);
    } else if (nama.equals("Iguana")) {
      animalCreated = new Animal(abs, ord, massa, 'I', nama, "Hisss", jinak, "x", id);
    } else if (nama.equals("Komodo")) {
      animalCreated = new Animal(abs, ord, massa, 'J', nama, "(stick tongue)", jinak, "x", id);
    } else if (nama.equals("Kancil")) {
      animalCreated = new Animal(abs, ord, massa, 'K', nama, "(eat cucumber)", jinak, "x", id);
    } else if (nama.equals("Aligator")) {
      animalCreated = new Animal(abs, ord, massa, 'L', nama, "(crawl)", jinak, "xw", id);
    } else if (nama.equals("Macan")) {
      animalCreated = new Animal(abs, ord, massa, 'M', nama, "(stalk prey)", jinak, "x", id);
    } else if (nama.equals("Nuri")) {
      animalCreated = new Animal(abs, ord, massa, 'N', nama, "(play ball)", jinak, "o", id);
    } else if (nama.equals("Kakatua")) {
      animalCreated = new Animal(abs, ord, massa, 'P', nama, "Hello! Kwak!!", jinak, "o", id);
    } else if (nama.equals("MantaRay")) {
      animalCreated = new Animal(abs, ord, massa, 'Q', nama, "(swim! jump!)", jinak, "w", id);
    } else if (nama.equals("Siamang")) {
      animalCreated = new Animal(abs, ord, massa, 'S', nama, "Ooo Ooo", jinak, "x", id);
    } else if (nama.equals("HiuMartil")) {
      animalCreated = new Animal(abs, ord, massa, 'T', nama, "(move head)", jinak, "w", id);
    } else if (nama.equals("OrangUtan")) {
      animalCreated = new Animal(abs, ord, massa, 'U', nama, "Auooo", jinak, "x", id);
    } else if (nama.equals("HiuKarpet")) {
      animalCreated = new Animal(abs, ord, massa, 'V', nama, "(burying in sand)", jinak, "w", id);
    } else if (nama.equals("StingRay")) {
      animalCreated = new Animal(abs, ord, massa, 'Y', nama, "(move fin)", jinak, "w", id);
    } else if (nama.equals("Zebra")) {
      animalCreated = new Animal(abs, ord, massa, 'Z', nama, "(running)", jinak, "x", id);
    } else if (nama.equals("Banteng")) {
      animalCreated = new Animal(abs, ord, massa, 'A', nama, "(snort)", jinak, "x", id);
    }
    return animalCreated;
  }

  /**
   * MEthod untuk memparsing animal dari file external.
   * @param z zoo.
   * @return animalHandler yang telah terisi animal.
   */
  public AnimalHandler parseAnimal(Zoo z) {
    AnimalHandler animalHandler = new AnimalHandler();
    try {
      FileReader fin = null;
      JSONParser parser = new JSONParser();

      fin = new FileReader("src/main/resource/map.json");
      JSONObject obj = (JSONObject) parser.parse(fin);

      JSONArray animalArray = (JSONArray) obj.get("AnimalList");
      Iterator<JSONObject> allAnimal = animalArray.iterator();

      int abs;
      int ord;
      int massa;
      String nama;
      boolean jinak;
      int id;
      while (allAnimal.hasNext()) {
        JSONObject currAnimal = (JSONObject) allAnimal.next();
        JSONObject lokasi = (JSONObject) currAnimal.get("Lokasi");
        abs = new Long((long) lokasi.get("x")).intValue();
        ord = new Long((long) lokasi.get("y")).intValue();
        nama = (String) currAnimal.get("Spesies");
        massa = new Long((long) currAnimal.get("Massa")).intValue();
        id = new Long((long) currAnimal.get("Id")).intValue();
        jinak = (boolean) currAnimal.get("Jinak");

        Animal animal = animalBuilder(abs, ord, massa, nama, jinak, id);
        animalHandler.addAnimal(animal);
        z.getCell(abs, ord).setAnimal(animal);
        if (z.getCell(abs, ord).getCage() != null) {
          z.getCell(abs, ord).getCage().addAnimal(animal);
        } else {
          System.out.println(abs + " " + ord);
        }
      }
      fin.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return animalHandler;
  }

  /**
   * Method untuk memparsing cage dari file external.
   * @return CageHAndler yang telah terisi.
   */
  public CageHandler parseCage() {
    CageHandler cageHandler= new CageHandler();
    try{
      FileReader fin= null;
      JSONParser parser = new JSONParser();

      fin= new FileReader("src/main/resource/map.json");
      JSONObject obj = (JSONObject) parser.parse(fin);

      JSONArray cageArray= (JSONArray) obj.get("CageList");
      Iterator<JSONObject> allCage = cageArray.iterator();

      char habitat;
      int id;
            while (allCage.hasNext()) {
              JSONObject currCage= (JSONObject) allCage.next();
              habitat= new String((String) currCage.get("Habitat")).charAt(0);
                id= new Long((long) currCage.get("Id")).intValue();

                cageHandler.addCage(new Cage(id,habitat));
            }
            fin.close();
    }
    catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    catch (IOException e) {
            e.printStackTrace();
        }
    catch (ParseException e) {
            e.printStackTrace();
        }
    return cageHandler;
  }

  /**
   * Methos untuk memparsing cell dari file external.
   * @param cageHandler CageHandler.
   * @return Zoo yangtelah terisi cell.
   */
  public Zoo parseCell(CageHandler cageHandler) {
    Zoo z = null;
    try{
      FileReader fin= null;
      JSONParser parser = new JSONParser();

      fin= new FileReader("src/main/resource/map.json");
      JSONObject obj = (JSONObject) parser.parse(fin);

      JSONArray cellArray= (JSONArray) obj.get("CellList");
      Iterator<JSONObject> allCell = cellArray.iterator();

      Cage cage;
      int abs;
      int ord;
      String type;
      boolean entrance, exit;

      z = new Zoo(mapLength,mapWidth);

            while (allCell.hasNext()) {
              JSONObject currCell = (JSONObject) allCell.next();
              JSONObject lokasi = (JSONObject) currCell.get("Lokasi");
              abs = new Long((long) lokasi.get("x")).intValue();
              ord = new Long((long) lokasi.get("y")).intValue();
              type = (String) currCell.get("type");
              int cageID= new Long((long) currCell.get("Cage")).intValue();

              Cell sel = null;

            if(type.equals("water")) {
              sel = new Cell('w',abs,ord);
            } else if(type.equals("land")) {
              sel = new Cell('x',abs,ord);
            } else if(type.equals("air")) {
              sel = new Cell('o',abs,ord);
            } else if(type.equals("road")) {
              entrance = (boolean) currCell.get("entrance");
                  exit = (boolean) currCell.get("exit");
              if(entrance) {
                sel = new Cell(' ',abs,ord);
                z.addEntrance(sel);
              } else if(exit){
                sel = new Cell(' ',abs,ord);
                z.addExit(sel);
              } else {
                sel = new Cell(' ',abs,ord);
              }
            } else if(type.equals("park")) {
              sel = new Cell('*',abs,ord);
            } else if(type.equals("restaurant")) {
              sel = new Cell('R',abs,ord);
            }
            z.setCell(abs,ord,sel);
            if(cageID>0) {
                cage= cageHandler.getCage(cageID);
                cage.addCell(sel.getType());
              }
              else {
                cage=null;
              }
            z.getCell(abs, ord).setCage(cage);
            }
            fin.close();
    }
    catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    catch (IOException e) {
            e.printStackTrace();
        }
    catch (ParseException e) {
            e.printStackTrace();
        }
    return z;
  }

  public int getPosX() {
    return posisiX;
  }

  public int getPosY() {
    return posisiY;
  }
}