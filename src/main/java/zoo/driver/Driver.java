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
	private int curr_x;
	private int curr_y;
	private boolean visited[][];
	private int map_width;
	private int map_length;
	
	public Driver() {
		try {
			FileReader fin= null;
			JSONParser parser = new JSONParser();
			
			fin = new FileReader("src/main/resource/map.json"); 
			JSONObject obj = (JSONObject) parser.parse(fin);
			map_width = new Long((long) obj.get("ZooWidth")).intValue();
			map_length = new Long((long) obj.get("ZooLength")).intValue();
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
		
		visited = new boolean[map_length][map_width];
	}
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
	
	public AnimalHandler parseAnimal(Zoo z){
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
                
                Animal animal = animalBuilder(absis, ordinat, massa, nama, jinak, id);
                animalHandler.addAnimal(animal);
                z.getCell(absis, ordinat).setAnimal(animal);
                if(z.getCell(absis, ordinat).getCage() != null)
                	z.getCell(absis, ordinat).getCage().addAnimal(animal);
                else 
                	System.out.println(absis + " "+ ordinat);
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
			boolean entrance, exit;
			
			z = new Zoo(map_length,map_width);
			
            while (allCell.hasNext()) {
            	JSONObject currCell = (JSONObject) allCell.next();
            	JSONObject lokasi = (JSONObject) currCell.get("Lokasi");
            	absis = new Long((long) lokasi.get("x")).intValue();
            	ordinat = new Long((long) lokasi.get("y")).intValue();
            	type = (String) currCell.get("type");
            	int cageID= new Long((long) currCell.get("Cage")).intValue();
            	
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
        		if(cageID>0) {
            		cage= cageHandler.getCage(cageID);
            		cage.addCell(sel.getType());
            	}
            	else {
            		cage=null;
            	}
        		z.getCell(absis, ordinat).setCage(cage);
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
	
	public void initPosition(Zoo z){
		Random rand = new Random(System.currentTimeMillis());
		int idx = rand.nextInt(z.nbEntrance());
		curr_x = z.getEntrance(idx).getAbsis();
		curr_y = z.getEntrance(idx).getOrdinat();
		
		for(int i = 0; i < z.getLength(); i++) {
			for(int j = 0; j < z.getWidth(); j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public int getPosX() {
		return curr_x;
	}
	
	public int getPosY() {
		return curr_y;
	}
	
	public void tourVirtualZoo(Zoo z) {
		Random rand = new Random(System.currentTimeMillis());
		boolean finish = false;
		
		System.out.println("==================================================");
		System.out.println("                 VIRTUAL ZOO TOUR");
		System.out.println("==================================================");
		
		while(!finish) {
			int init = rand.nextInt(4);
			boolean found = false;
			int i = 0;
			
			while(!found && i < 4) {
				if(init == 0){
					if((curr_y-1 >= 0) && (z.getCell(curr_x, curr_y-1).getType() ==' ') && (!visited[curr_y-1][curr_x])) {
						found = true;
						visited[curr_y][curr_x] = true;
						curr_y--;
					}
					else
						init++;
				}
				else if(init == 1){
					if((curr_x+1 < z.getWidth()) && (z.getCell(curr_x+1, curr_y).getType() ==' ') && (!visited[curr_y][curr_x+1])) {
						found = true;
						visited[curr_y][curr_x] = true;
						curr_x++;
					}
					else
						init++;
				}
				else if(init == 2){
					if((curr_y+1 < z.getLength()) && (z.getCell(curr_x, curr_y+1).getType() ==' ') && (!visited[curr_y+1][curr_x])) {
						found = true;
						visited[curr_y][curr_x] = true;
						curr_y++;
					}
					else
						init++;
				}
				else if(init == 3){
					if((curr_x-1 >= 0) && (z.getCell(curr_x-1, curr_y).getType() ==' ') && (!visited[curr_y][curr_x-1])) {
						found=true;
						visited[curr_y][curr_x]=true;
						curr_x--;
					}
					else
						init=0;
				}
				if(!found) {
					i++;
				}
			}
			if(!found) {
				finish=true;
				System.out.println("No next move found");
			} else {
				System.out.println("You're in: "+ curr_x + " " + curr_y);
				if(curr_y-1 >= 0 && z.getCell(curr_x, curr_y-1).getAnimal() != null){
					z.getCell(curr_x, curr_y-1).getAnimal().interact();
				}
				if(curr_x-1 >= 0 && z.getCell(curr_x-1, curr_y).getAnimal() != null){
					z.getCell(curr_x-1, curr_y).getAnimal().interact();
				}
				if(curr_y+1 < z.getLength() && z.getCell(curr_x, curr_y+1).getAnimal() != null){
					z.getCell(curr_x, curr_y+1).getAnimal().interact();
				}
				if(curr_x+1 < z.getWidth() && z.getCell(curr_x+1, curr_y).getAnimal() != null){
					z.getCell(curr_x+1, curr_y).getAnimal().interact();
				}
				for(i = 0; i < z.nbExit(); i++){
					if(z.getExit(i).getAbsis() == curr_x && z.getExit(i).getOrdinat() == curr_y){
						finish = true;
						System.out.println("You are in an exit!");
					}
				}
			}
		}
	}
	
	public void moveAnimal(Zoo z, AnimalHandler ah) {
		Random rand = new Random(System.currentTimeMillis());
		for(int i=0; i<ah.nbAnimal(); i++){
			int init = rand.nextInt(4);
			int x = ah.getAnimal(i).getPosisiX();
			int y = ah.getAnimal(i).getPosisiY();
			int cage= z.getCell(x, y).getCage().getId();

			if(init == 0){
				if(y-1 >= 0 && z.getCell(x, y-1).getCage() != null && z.getCell(x, y-1).getCage().getId() == cage && z.getCell(x, y-1).getAnimal() == null) {
					ah.getAnimal(i).setY(y-1);
					z.getCell(x, y).setAnimal(null);
					z.getCell(x, y-1).setAnimal(ah.getAnimal(i));
				}
			}
			else if(init == 1){
				if(x+1 < z.getWidth() && z.getCell(x+1, y).getCage() != null && z.getCell(x+1, y).getCage().getId() == cage && z.getCell(x+1, y).getAnimal() == null) {
					ah.getAnimal(i).setX(x+1);
					z.getCell(x, y).setAnimal(null);
					z.getCell(x+1, y).setAnimal(ah.getAnimal(i));
				}
			}
			else if(init == 2){
				if(y+1 < z.getLength() && z.getCell(x, y+1).getCage() != null && z.getCell(x, y+1).getCage().getId() == cage && z.getCell(x, y+1).getAnimal() == null) {
					ah.getAnimal(i).setY(y+1);
					z.getCell(x, y).setAnimal(null);
					z.getCell(x, y+1).setAnimal(ah.getAnimal(i));
				}
			}
			else if(init == 3){
				if(x-1 >= 0 && z.getCell(x-1, y).getCage() != null && z.getCell(x-1, y).getCage().getId() == cage && z.getCell(x-1, y).getAnimal() == null) {
					ah.getAnimal(i).setX(x-1);
					z.getCell(x, y).setAnimal(null);
					z.getCell(x-1, y).setAnimal(ah.getAnimal(i));
				}
			}
		} 
	}
}