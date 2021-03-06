package modele;

import java.util.Date;
import java.util.EventObject;

import modele.Borne.TypeBorne;
import modele.VehiculeEvent.TypePaiement;
import modele.VehiculeEvent.TypeVehicule;

public class RapportEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypeVehicule _typeVehicule; 
	private int _numeroVoie;
	private Date _heure; 
	private double _sommePercue; 
	private TypeBorne _typeBorne;
	private TypePaiement _typePaiement;
	
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
	
	@Override
	public String toString() {
		String s1 = "Un(e) " + _typeVehicule.toString().toLowerCase();
		String s2 = " (" + _typePaiement.toString().toLowerCase() + ") ";
		String s3 = "est passé(e) à la borne n° ";
		String typeBorne = _typeBorne.toString().toLowerCase();
		return s1 + s2 + s3 + (_numeroVoie + 1) + " (" + typeBorne + ")";
	}

	public int get_numeroVoie() {
		return _numeroVoie;
	}

	public TypeVehicule get_typeVehicule() {
		return _typeVehicule;
	}

	public Date get_heure() {
		return _heure;
	}

	public double get_sommePercue() {
		return _sommePercue;
	}

	public TypeBorne get_typeBorne() {
		return _typeBorne;
	}

}
