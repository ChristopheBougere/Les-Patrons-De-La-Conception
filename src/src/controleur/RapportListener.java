package controleur;

import java.util.EventListener;

import modele.RapportEvent;

public interface RapportListener extends EventListener {
	public void rapportEnvoye(RapportEvent r);
}
