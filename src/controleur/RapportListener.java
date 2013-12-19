package controleur;

import modele.Rapport;
import modele.RapportEvent;

public interface RapportListener {
	public void rapportEnvoye(RapportEvent r);
}
