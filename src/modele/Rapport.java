package modele;

import java.util.Date;

import modele.Borne.TypeBorne;
import modele.VehiculeEvent.TypeVehicule;

public class Rapport {
	private TypeVehicule _typeVehicule; 
	private int _numeroVole;
	private Date _heure; 
	private int _sommePercue; 
	private TypeBorne _t;
	
	public void faireRapport(TypeVehicule p_typeVehicule,int p_numeroVole,Date p_heure,int p_sommePercue, TypeBorne t){
		_typeVehicule=p_typeVehicule;
		_numeroVole=p_numeroVole;
		_heure=p_heure;
		_sommePercue=p_sommePercue;
		_t = t;
	}
}
