package cell;
import animal.*;


public class Cell{
	private Animal animal;
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

	public char getType() {
		return type;
	}

	public int getAbsis() {
		return absis;
	}

	public int getOrdinat() {
		return ordinat;
	}

	public int getCage() {
		return cage;
	}

	public void setCage(int _cage) {
		cage=_cage;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal _animal) {
		if(_animal==null) {
			animal=null;
		}
		else {
			if(animal==null) {
				animal=_animal;
			}
		}
	}

	public String getHabitat() {
		if(habitat.charAt(0)!='\0'){
			return habitat;
		}
		else{
			return "";
		}
	}

	public void setHabitat(String _habitat) {
		habitat=_habitat;
	}

	public String getFacility() {
		if(facility.charAt(0)!='\0') {
			return facility;
		}
		else{
			return "";
		}
	}

	public void setFacility(String _facility) {
		facility=_facility;
	}

	public void render() {
		if(animal!=null) {
			System.out.print(animal);
		}
		else {
			System.out.print(type);
		}
	}
}