

/*
 * Ghita & Baraa 
 * */

package controleur;
import modele.AlarmeEvent;
import java.util.EventListener;

public interface AlarmeListener extends EventListener {
	void alarmeDeclenchee(AlarmeEvent a);
}

