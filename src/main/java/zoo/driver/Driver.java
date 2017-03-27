package driver;
import animal.*;
import cage.*;
import cell.*;
import zoo.*;

import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Driver{
	private Animal animalBuilder(int absis, int ordinat, int massa, String nama, boolean jinak, int id) {
		Animal animalCreated = null;
		if(nama.equals("Elang")) {
			animalCreated = new Animal(absis, ordinat, massa, '~', nama, "Kaaak!!", jinak, "o", id);
		}
		else if(nama.equals("Bekantan")) {
			animalCreated = new Animal(absis, ordinat, massa, 'A', nama, "(climb tree)", jinak, "x", id);
		}
		else if(nama.equals("BadakCulaSatu")) {
			animalCreated = new Animal(absis, ordinat, massa, 'B', nama, "(bathing in mud)", jinak, "x", id);
		}
		else if(nama.equals("Buaya")) {
			animalCreated = new Animal(absis, ordinat, massa, 'C', nama, "(open mouth)", jinak, "xw", id);
		}
		else if(nama.equals("Rusa")) {
			animalCreated = new Animal(absis, ordinat, massa, 'D', nama, "(flaunt horn)", jinak, "x", id);
		}
		else if(nama.equals("Parkit")) {
			animalCreated = new Animal(absis, ordinat, massa, 'E', nama, "cuit cuit", jinak, "o", id); 
		}
		else if(nama.equals("Garuda")) {
			animalCreated = new Animal(absis, ordinat, massa, 'F', nama, "(spread wings)", jinak, "o", id);
		}
		else if(nama.equals("HarimauSumatra")) {
			animalCreated = new Animal(absis, ordinat, massa, 'H', nama, "AUUUM!!", jinak, "x", id);
		}
		else if(nama.equals("Iguana")) {
			animalCreated = new Animal(absis, ordinat, massa, 'I', nama, "Hisss", jinak, "x", id);
		}
		else if(nama.equals("Komodo")) {
			animalCreated = new Animal(absis, ordinat, massa, 'J', nama, "(stick tongue)", jinak, "x", id);
		}
		else if(nama.equals("Kancil")) {
			animalCreated = new Animal(absis, ordinat, massa, 'K', nama, "(eat cucumber)", jinak, "x", id);
		}
		else if(nama.equals("Aligator")) {
			animalCreated = new Animal(absis, ordinat, massa, 'L', nama, "(crawl)", jinak, "xw", id);
		}
		else if(nama.equals("Macan")) {
			animalCreated = new Animal(absis, ordinat, massa, 'M', nama, "(stalk prey)", jinak, "x", id);
		}
		else if(nama.equals("Nuri")) {
			animalCreated = new Animal(absis, ordinat, massa, 'N', nama, "(play ball)", jinak, "o", id);
		}
		else if(nama.equals("Kakatua")) {
			animalCreated = new Animal(absis, ordinat, massa, 'P', nama, "Hello! Kwak!!", jinak, "o", id);
		}
		else if(nama.equals("MantaRay")) {
			animalCreated = new Animal(absis, ordinat, massa, 'Q', nama, "(swim! jump!)", jinak, "w", id);
		}
		else if(nama.equals("Siamang")) {
			animalCreated = new Animal(absis, ordinat, massa, 'S', nama, "Ooo Ooo", jinak, "x", id);
		}
		else if(nama.equals("HiuMartil")) {
			animalCreated = new Animal(absis, ordinat, massa, 'T', nama, "(move head)", jinak, "w", id);
		}
		else if(nama.equals("OrangUtan")) {
			animalCreated = new Animal(absis, ordinat, massa, 'U', nama, "Auooo", jinak, "x", id);
		}
		else if(nama.equals("HiuKarpet")) {
			animalCreated = new Animal(absis, ordinat, massa, 'V', nama, "(burying in sand)", jinak, "w", id);
		}
		else if(nama.equals("StingRay")) {
			animalCreated = new Animal(absis, ordinat, massa, 'Y', nama, "(move fin)", jinak, "w", id);
		}
		else if(nama.equals("Zebra")) {
			animalCreated = new Animal(absis, ordinat, massa, 'Z', nama, "(running)", jinak, "x", id);
		}
		else if(nama.equals("Banteng")) {
			animalCreated = new Animal(absis, ordinat, massa, 'A', nama, "(snort)", jinak, "x", id);
		}
		return animalCreated;
	}
	
	public AnimalHandler parseAnimal(){
		AnimalHandler animalHandler= new AnimalHandler();
		try{
			FileReader fin= null;
			JSONParser parser = new JSONParser();
			
			fin= new FileReader("src/main/resource/map.json"); 
			JSONObject obj = (JSONObject) parser.parse(fin);

			JSONArray animalArray= (JSONArray) obj.get("AnimalList");
			Iterator<JSONObject> allAnimal = animalArray.iterator();
		
			int absis;
			int ordinat;
			int massa;
			String nama;
			boolean jinak;
			int id;
            while (allAnimal.hasNext()) {
            	JSONObject currAnimal = (JSONObject) allAnimal.next();
            	JSONObject lokasi = (JSONObject) currAnimal.get("Lokasi");
                absis = new Long((long) lokasi.get("x")).intValue();
                ordinat = new Long((long) lokasi.get("y")).intValue();
                nama = (String) currAnimal.get("Spesies");
                massa = new Long((long) currAnimal.get("Massa")).intValue();
                id = new Long((long) currAnimal.get("Id")).intValue();
                jinak = (boolean) currAnimal.get("Jinak");
                
                animalHandler.addAnimal(animalBuilder(absis, ordinat, massa, nama, jinak, id));
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
		return animalHandler;
	}
	
	public CageHandler parseCage(){
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
			int absis;
			int ordinat;
			String type;
			int panjang, lebar;
			boolean entrance, exit;
			

			panjang = new Long((long) obj.get("ZooLength")).intValue();
			lebar = new Long((long) obj.get("ZooWidth")).intValue();
			z = new Zoo(panjang,lebar);
			
            while (allCell.hasNext()) {
            	JSONObject currCell = (JSONObject) allCell.next();
            	JSONObject lokasi = (JSONObject) currCell.get("Lokasi");
            	absis = new Long((long) lokasi.get("x")).intValue();
            	ordinat = new Long((long) lokasi.get("y")).intValue();
            	type = (String) currCell.get("type");
            	int cageID= new Long((long) currCell.get("Cage")).intValue();
            	if(cageID>0) {
            		cage= cageHandler.getCage(cageID);
            	}
            	else {
            		cage=null;
            	}
            	Cell sel = null;
            	
        		if(type.equals("water")) {
        			sel = new Cell('w',absis,ordinat);
        		} else if(type.equals("land")) {
        			sel = new Cell('x',absis,ordinat);
        		} else if(type.equals("air")) {
        			sel = new Cell('o',absis,ordinat);
        		} else if(type.equals("road")) {
        			entrance = (boolean) currCell.get("entrance");
                	exit = (boolean) currCell.get("exit");
        			if(entrance) {
        				sel = new Cell(' ',absis,ordinat);
        				z.addEntrance(sel);
        			} else if(exit){
        				sel = new Cell(' ',absis,ordinat);
        				z.addExit(sel);
        			} else {
        				sel = new Cell(' ',absis,ordinat);
        			}
        		} else if(type.equals("park")) {
        			sel = new Cell('*',absis,ordinat);
        		} else if(type.equals("restaurant")) {
        			sel = new Cell('R',absis,ordinat);
        		}
        		z.setCell(absis,ordinat,sel);            	
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
	
	public void displayVirtualZoo(Zoo z) {
		int left, right, up, down;
		System.out.println("Input left position : ");
		Scanner reader = new Scanner(System.in);
		left = reader.nextInt();
		System.out.println("Input up position : ");
		up = reader.nextInt();
		System.out.println("Input right position : ");
		right = reader.nextInt();
		System.out.println("Input down position : ");
		down = reader.nextInt();
		System.out.println("==================================================");
		System.out.println("              V I R T U A L  Z O O");
		System.out.println("==================================================");
		if(left >= 0 && up >= 0 && right < z.getWidth() && down < z.getLength()){
			for (int i = up; i <= down; i++) {
				for (int j = left; j<= right; j++) {
					z.getCell(j,i).render();
				}
				System.out.println();
			}
		}
	}
	
}