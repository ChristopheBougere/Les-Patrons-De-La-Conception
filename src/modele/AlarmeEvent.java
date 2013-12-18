package modele;

import java.util.EventObject;
/**
 * 
 * @author IBARBACHANE Walid
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 *
 */
public class AlarmeEvent extends EventObject {
	private String _message;

	public enum TypeAlarme {
		BOUTON, PLUS_DE_MONNAIE, PLUSIEURS_VEHICULES, REFUS_PAIEMENT,
		BARRIERE
	}
	
	public String getMessage(){
		return _message;
	}

	public AlarmeEvent(Object source, TypeAlarme typeAlarme) {
		super(source);
		_message = typeAlarme.toString().toLowerCase();
		Borne voie = (Borne)source;
		_message += " à la borne n° " + voie.getNumeroVoie();
		_message += " (" + voie.getType().toString().toLowerCase() + ")";
	}

}
