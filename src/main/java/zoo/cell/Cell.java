package cell;

import java.util.*;

public class Cell{
	private int animal;
	private int cage;
	private String facility;
	public String habitat;
	public final char type;
	public final int absis;
	public final int ordinat;

	public Cell(char c, int x, int y) {
		type=c;
		absis=x;
		ordinat=y;
	}

	public char GetType() {
		return type;
	}

	public int GetAbsis() {
		return absis;
	}

	public int GetOrdinat() {
		return ordinat;
	}

	public int GetCage() {
		return cage;
	}

	public void SetCage(int _cage) {
		cage=_cage;
	}

	public int GetAnimal() {
		return animal;
	}

	public void SetAnimal(int _animal) {
		if(_animal==0) {
			animal=0;
		}
		else {
			if(animal==0) {
				animal=_animal;
			}
		}
	}

	public String GetHabitat() {
		if(habitat.charAt(0)!='\0'){
			return habitat;
		}
		else{
			return "";
		}
	}

	public void SetHabitat(String _habitat) {
		habitat=_habitat;
	}

	public String GetFacility() {
		if(facility.charAt(0)!='\0') {
			return facility;
		}
		else{
			return "";
		}
	}

	public void SetFacility(String _facility) {
		facility=_facility;
	}

	public void Render() {
		if(animal!=0) {
			System.out.print(animal);
		}
		else {
			System.out.print(type);
		}
	}
}