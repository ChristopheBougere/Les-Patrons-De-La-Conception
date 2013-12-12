

/*
 * Ghita & Baraa 
 * */

package controleur;
import modele.Alarme;
import java.util.EventListener;

public interface AlarmeListener extends EventListener {
	void alarmeDeclenchee(Alarme a);
}

