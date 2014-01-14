package modele;

import java.util.EventObject;
/**
 * 
 * @author IBARBACHANE Walid
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 * @author Yahia EL MEJJAD
 * 
 * Cette classe permet de gérer les messages d'alarme à afficher suivant le type d'alarme
 */
public class AlarmeEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _message;

	/**
	 * Cette méthode permet de spécifier le type d'alarme
	 * @author elmejjad
	 *
	 */
	public enum TypeAlarme {
		BOUTON, PLUS_DE_MONNAIE, PLUSIEURS_VEHICULES, REFUS_PAIEMENT,
		BARRIERE_NON_LEVEE
	}
	
	public String getMessage() {
		return _message;
	}

	/**
	 * Message à afficher suivant le type d'alarme
	 * @param source
	 * @param typeAlarme
	 */
	public AlarmeEvent(Object source, TypeAlarme typeAlarme) {
		super(source);
		_message = typeAlarme.toString().toLowerCase();
		Borne voie = (Borne)source;
		_message += " à la borne n° " + (voie.getNumeroVoie() + 1);
		_message += " (" + voie.getType().toString().toLowerCase() + ")";
	}

}