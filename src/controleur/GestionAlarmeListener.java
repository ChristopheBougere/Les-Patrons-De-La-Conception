package controleur;

import java.util.EventListener;
/**
 * 
 * @author ibarbachane
 *
 */
public interface GestionAlarmeListener extends EventListener {
	public void gererAlarme(GestionAlarmeEvent e,int numeroVoie);
}
