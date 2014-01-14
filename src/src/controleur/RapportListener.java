package controleur;

import java.util.EventListener;

import modele.RapportEvent;

/**
 * @author Christophe BOUGERE
 * @author Sofiane BOUKHEBELT
 * 
 * Cette interface permet d'implémenter une classe qui réagit à un RapportEvent ( envoi d'un rapport )
 */
public interface RapportListener extends EventListener {
	public void rapportEnvoye(RapportEvent r);
}