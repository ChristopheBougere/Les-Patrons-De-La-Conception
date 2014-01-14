package modele;
import java.util.EventObject;
import java.util.Random;

import modele.Borne.TypeBorne;
/**
 * 
 * @author IBARBACHANE Walid
 * @author Sofiane BOUKHEBELT
 * 
 * Cette classe sert à la gestion de l'évenement vehicule qui 
 * est envoyé lorsqu'on crée un véhicule.
 */
public class VehiculeEvent extends EventObject {

	private static final long serialVersionUID = 1L;


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

	/**
	 * @param source
	 * @param typeVehicule
	 * @param numeroVoie
	 * @param typeBorne
	 */
	public VehiculeEvent(Object source, TypeVehicule typeVehicule,
			int numeroVoie, TypeBorne typeBorne) {
		super(source);
		_typeVehicule = typeVehicule;
		_typePaiement = genererPaiement(typeBorne);
		_numeroVoie = numeroVoie;
	}
	
	/**
	 * Permet de générer un type de paiement selon le type de borne.
	 * On considère que les vehicules ne se trompent pas.
	 * 
	 * @return Le type de paiement généré
	 */
	public TypePaiement genererPaiement(TypeBorne typeBorne) {
		if (typeBorne == TypeBorne.TELEPEAGE)
			return TypePaiement.ABONNEMENT;
		
		return aleaTypePaiement();
	}
	
	/**
	 * @return Un type de paiement tiré pseudo aléatoirement
	 */
	private TypePaiement aleaTypePaiement() {
		switch (new Random().nextInt(3)) {
		case 0 : return TypePaiement.CARTE;
		case 1 : return TypePaiement.MONNAIE;
		case 2 : return TypePaiement.ABONNEMENT;
		default : return TypePaiement.CARTE;
		}
	}

	/**
	 * Accesseur
	 * @return le type de vehicule
	 */
	public TypeVehicule typeVehicule() {
		return _typeVehicule;
	}
	
	/**
	 * Accesseur
	 * @return le type de paiement
	 */
	public TypePaiement typePaiement() {
		return _typePaiement;
	}
	
	/**
	 * Accesseur
	 * @return le numero de voie
	 */
	public int getNumeroVoie() {
		return _numeroVoie;
	}

}
