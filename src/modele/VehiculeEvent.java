package modele;
import java.util.EventObject;
import java.util.Random;

import modele.Borne.TypeBorne;
import modele.VehiculeEvent.TypeVehicule;
/**
 * 
 * @author IBARBACHANE Walid
 * @author Sofiane BOUKHEBELT
 *
 */

public class VehiculeEvent extends EventObject {
	
	public enum TypeVehicule {
		VOITURE, CAMION, BUS, SPECIAL, CARAVANE, MOTO;
		public static TypeVehicule getRandom() {
	        return values()[(int) (Math.random() * values().length)];
	    }
	}
	
	public enum TypePaiement {
		CARTE, MONNAIE, ABONNEMENT
	}
	
	private TypeVehicule _typeVehicule;
	private TypePaiement _typePaiement;
	private int _numeroVoie;
	
	public VehiculeEvent(Object source, TypeVehicule typeVehicule, int numeroVoie) {
		super(source);
		_typeVehicule = typeVehicule;
		_numeroVoie = numeroVoie;
		_typePaiement = aleaTypePaiement();
	}

	/**
	 * 
	 * @return Un type de paiement tiré pseudo aléatoirement
	 */
	private TypePaiement aleaTypePaiement() {
		int r = new Random().nextInt(3);
		TypePaiement typePaiement;
		switch (r) {
		case 0 : typePaiement = TypePaiement.CARTE;
		break;
		case 1 : typePaiement = TypePaiement.MONNAIE;
		break;
		case 2 : typePaiement = TypePaiement.ABONNEMENT;
		break;
		default: typePaiement = TypePaiement.CARTE;
		}
		return typePaiement;
	}
	
	public TypeVehicule typeVehicule() {
		return _typeVehicule;
	}
	
	public TypePaiement typePaiement() {
		return _typePaiement;
	}
	
	public int getNumeroVoie() {
		return _numeroVoie;
	}

}
