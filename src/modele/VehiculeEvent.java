package modele;
import java.util.EventObject;

import modele.VehiculeEvent.TypeVehicule;
/**
 * 
 * @author IBARBACHANE Walid
 * @author Sofiane BOUKHEBELT
 *
 */

public class VehiculeEvent extends EventObject {
	
	public enum TypeVehicule {
		VOITURE, CAMION, BUS, VEHICULE_SPECIAL, CARAVANE, MOTO
	}
	
	public enum TypePaiement {
		CARTE, MONNAIE, ABONNEMENT
	}

	private TypeVehicule _t;
	private TypePaiement _p;
	
	public TypeVehicule getType() {
		return _t;
	}
	
	public TypePaiement getPaiement() {
		return _p;
	}
	
	public VehiculeEvent(Object source, TypeVehicule t) {
		super(source);
		_t = t;
	}

}
