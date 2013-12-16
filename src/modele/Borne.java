package modele;


import modele.AlarmeEvent.TypeAlarme;

import controleur.AlarmeListener;
import controleur.VehiculeListener;

/**
 * 
 * @author Sofiane BOUKHEBELT
 *
 */
public abstract class Borne {
	protected int _numeroVoie;
	protected BarrierePhysique _barriere;
	protected Feu _feu;
	protected Rapport _rapport;
	protected Vehicule _vehicules;
	protected int _compteurVehicules;
	protected VehiculeListener _vehiculeListener = null;
	protected boolean _nouvelleVoiture;
	protected AlarmeListener _alarmeListener;
	protected TypeAlarme _alarme;
	
	public enum TypeBorne {
	    MANUELLE, AUTOMATIQUE, TELEPEAGE
	}
	
	public Borne(int numeroVoie) {
		_numeroVoie = numeroVoie;
		_barriere = new BarrierePhysique();
		_feu = new Feu();
		_rapport = new Rapport();
		_nouvelleVoiture = false;
		_compteurVehicules = 0;
	}
	
	public int getFluxVehicule() {
		return _compteurVehicules;
	}

	public boolean courantEstPasse() {
		return _vehicules.estPasse();
	}

	public int getNumeroVoie() {
		return _numeroVoie;
	}
	
	public void addVehiculeListener(VehiculeListener l) {
		if (_vehiculeListener == null) {
			_vehiculeListener = l;
		}
	}
	
	public void removeVehiculeListener(VehiculeListener l) {
		if (_vehiculeListener != null || _vehiculeListener == l) {
			_vehiculeListener = null;
		}
	}	
	
	public void stepVehicule() {
		if (_nouvelleVoiture) {
			_nouvelleVoiture = false;
			++_compteurVehicules;
			fireVehiculeEvent();
		}
	}
	
	private void fireVehiculeEvent() {
		if (_vehiculeListener != null) {
			VehiculeEvent evt = new VehiculeEvent(this);
			_vehiculeListener.gererVehicule(evt);
		}
	}
	
	public void addAlarmeListener(AlarmeListener l) {
		if (_alarmeListener != null || _alarmeListener == l) {
			_alarmeListener = null;
		}
	}
	
	public void removeAlarmeListener(VehiculeListener l) {
		if (_alarmeListener!= null || _alarmeListener == l) {
			_alarmeListener = null;
		}
	}
	
	private void declencherAlarme(TypeAlarme alarme) {
		if (_alarmeListener != null) {
			AlarmeEvent evt = new AlarmeEvent(this);
			_alarmeListener.alarmeDeclenchee(evt);
		}
	}
	
	
}