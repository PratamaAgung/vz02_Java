package cage;
import java.util.Vector;

/**
 * @class CageHandler berfungsi memanage cage
 */
public class CageHandler {
	private int nb_cage;
	private Vector<Cage> cage_list;

	public CageHandler() {
		cage_list = new Vector<Cage>();
		nb_cage = 0;
	}
	public Cage getCage(int id) {
		boolean found = false;
		int i=0;
		while((!found) && (i<nb_cage)){
			if(cage_list.elementAt(i).getId() == id)
				found=true;
			else
				i++;
		}
		if(found)
			return cage_list.elementAt(i);
		else
			return null;
	}
	public int getNbCage() {
		return nb_cage;
	}
	public void addCage(Cage cage) {
		cage_list.addElement(cage);
		nb_cage++;
	}
}