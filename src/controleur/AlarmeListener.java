package controleur;
import modele.AlarmeEvent;
import java.util.EventListener;

/**
 * 
 * @author Ghita BAOUZ
 * @author Baraa EL YOUSSEFI
 * @author Walid Ibarbachane
 *
 */
public interface AlarmeListener extends EventListener {
	void alarmeDeclenchee(AlarmeEvent a,int numeroVoie);
}

