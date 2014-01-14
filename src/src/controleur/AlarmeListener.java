package controleur;
import modele.AlarmeEvent;
import java.util.EventListener;

/**
 * 
 * @author Ghita BAOUZ
 * @author Baraa EL YOUSSEFI
 * @author Walid Ibarbachane
 *
 * Cette interface permet d'implémenter une classe qui réagit à un AlarmeEvent ( déclenchement d'une alarme )
 */
public interface AlarmeListener extends EventListener {
	void alarmeDeclenchee(AlarmeEvent a,int numeroVoie);
}
