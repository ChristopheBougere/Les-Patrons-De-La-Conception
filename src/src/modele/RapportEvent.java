package modele;

import java.util.Date;
import java.util.EventObject;

import modele.Borne.TypeBorne;
import modele.VehiculeEvent.TypePaiement;
import modele.VehiculeEvent.TypeVehicule;

/**
 * @author elyoussefi Baraa
 * @autor   Baouz   Ghita
 * @author  Bougère  Christophe
 * @author Ibarbachane Walid
 * @author El mejjad Yahia
 * @author Boukhebelt Sofiane
 * 
 *Cette classe sert à la gestion de l'évenement rapport qui 
 *est envoyé lorsqu'un véhicule passe dans une borne.
 *
 */
public class RapportEvent extends EventObject {


	private static final long serialVersionUID = 1L;
	private TypeVehicule _typeVehicule; 
	private int _numeroVoie;
	private Date _heure; 
	private double _sommePercue; 
	private TypeBorne _typeBorne;
	private TypePaiement _typePaiement;
	
	/**
	 * @param source 
	 * @param typeVehicule enumeration {Bus,Special,voiture,Camion}
	 * @param numeroVoie   enumeration {1,2,3,4,5,6}
	 * @param heure   
	 * @param sommePercue
	 * @param typeBorne    enumeration {Télépéage,automatique,manuelle}
	 * @param typePaiement	enumeration {carte bancaire,abonnement,monnaie}
	 */
	public RapportEvent(Object source, TypeVehicule typeVehicule,
			int numeroVoie,Date heure,double sommePercue, TypeBorne typeBorne,
			TypePaiement typePaiement) {
		super(source);
		_typeVehicule=typeVehicule;
		_numeroVoie=numeroVoie;
		_heure=heure;
		_sommePercue=sommePercue;
		_typeBorne = typeBorne;
		_typePaiement = typePaiement;
	}
	
	/* (non-Javadoc)
	 * @see java.util.EventObject#toString()
	 */
	@Override
	public String toString() {
		String s1 = "Un(e) " + _typeVehicule.toString().toLowerCase();
		String s2 = " (" + _typePaiement.toString().toLowerCase() + ") ";
		String s3 = "est passé(e) à la borne n° ";
		String typeBorne = _typeBorne.toString().toLowerCase();
		return s1 + s2 + s3 + (_numeroVoie + 1) + " (" + typeBorne + ")";
	}

	/**
	 * accesseur de la donnée membre _numeroVoie.
	 * @return _numeroVoie le numéro de la voie où le véhicule se trouve.
	 */
	public int get_numeroVoie() {
		return _numeroVoie;
	}

	/**
	 * Accesseur de la donnée membre _typeVehicules.
	 * @return _typeVehicule le type du véhicule.
	 */
	public TypeVehicule get_typeVehicule() {
		return _typeVehicule;
	}

	/**
	 * Accesseur de la donnée membre _heure
	 * @return _heure l'heure à laquelle passe un véhicule dans une voie.
	 */
	public Date get_heure() {
		return _heure;
	}

	/**
	 * Accesseur de la donnée membre _sommePercue.
	 * @return _sommePercue la somme payée par chaque passager.
	 */
	public double get_sommePercue() {
		return _sommePercue;
	}

	/**
	 * Accesseur de la donnée membre _typeBorne.
	 * @return _typeBorne le type de la borne par laquelle passe une voiuture.
	 */
	public TypeBorne get_typeBorne() {
		return _typeBorne; 
	}

}
