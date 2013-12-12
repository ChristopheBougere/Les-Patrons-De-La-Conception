package modele;

import imagePanel.ImageChangeEvent;
import imagePanel.ImageChangeListener;

import java.util.Stack;

/**
 * 
 * @author Sofiane BOUKHEBELT
 *
 */
public abstract class Borne {
	protected int _numeroVoie;
	protected Barriere _barriere;
	protected Feu _feu;
	protected Rapport _rapport;
	protected Stack<Vehicule> _vehicules;
	protected VehiculeListener _vehiculeListener = null;
	protected boolean _nouvelleVoiture;
	protected Alarme _alarme;
	
	public Borne() {
		_numeroVoie = numeroVoie;
		_barriere = new Barriere();
		_feu = new Feu();
		_rapport = new Rapport();
		_vehicules = new Stack<Vehicule>();
		_nouvelleVoiture = false;
	}
	
	public int getFluxVehicule() {
		return _vehicules.size();
	}

	public boolean courantEstPasse() {
		return _vehicules.estPassee();
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
			fireVehiculeEvent();
		}
	}
	
	private void fireVehiculeEvent() {
		if (_vehiculeListener != null) {
			VehiculeEvent evt = new VehiculeEvent(this);
			_vehiculeListener.gererVoiture(evt);
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
	
	public void stepAlarme() {

	}
	
	private void fireAlarmeEvent() {
		if (_alarmeListener != null) {
			AlarmeEvent evt = new AlarmeEvent(this);
			_alarmeListener.alarmeDeclenchee(evt); // REVOIR AC GHITA
		}
	}
	
	
}