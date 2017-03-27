package driver;
import animal.*;

import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Driver{
	public AnimalHandler parseAnimal(){
		AnimalHandler animalHandler= new AnimalHandler();
		try{
			FileReader fin= null;
			JSONParser parser = new JSONParser();
			
			fin= new FileReader("src/main/resource/map.json"); 
			JSONObject obj = (JSONObject) parser.parse(fin);

			JSONArray animalArray= (JSONArray) obj.get("AnimalList");
			Iterator<JSONObject> allAnimal = animalArray.iterator();
		
			int idx=0;
			int absis;
			int ordinat;
			int massa;
			char c;
			String nama;
			String interaksi;
			boolean jinak;
			String Habitat;
			int id;
            while (allAnimal.hasNext()) {
            	JSONObject currAnimal= (JSONObject) allAnimal.next();
            	JSONObject lokasi=(JSONObject) currAnimal.get("Lokasi");
                absis=new Long((long) lokasi.get("x")).intValue();
                ordinat=new Long((long) lokasi.get("y")).intValue();
                nama=(String) currAnimal.get("Spesies");
                massa=new Long((long) currAnimal.get("Massa")).intValue();
                id=new Long((long) currAnimal.get("Id")).intValue();
                jinak=(boolean) currAnimal.get("Jinak");
                
                animalHandler.addAnimal(new Animal(absis, ordinat, massa, 'a', nama, "Auooo", jinak, "Darat", id));
            }
            
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
}