package modele;

import java.util.EventObject;
/**
 * 
 * @author IBARBACHANE Walid
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
	public AlarmeEvent(Object source) {
		super(source);
	}

}
