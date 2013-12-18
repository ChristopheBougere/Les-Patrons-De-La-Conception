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

	public AlarmeEvent(Object source, TypeAlarme t) {
		super(source);
		switch(t) {
		case BOUTON: _message = "Alarme bouton";
		break;
		case PLUS_DE_MONNAIE: _message = "Plus de monnaie";
		break;
		case PLUSIEURS_VEHICULES: _message = "Plusieurs vehicules";
		break;
		case REFUS_PAIEMENT: _message = "Refus paiement";
		break;
		case BARRIERE: _message = "Barrière";
		break;
		default: _message = "Alarme";
		}
	}

}
