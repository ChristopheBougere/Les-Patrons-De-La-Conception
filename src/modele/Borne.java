package modele;


import java.util.Date;
import java.util.Random;

import modele.AlarmeEvent.TypeAlarme;

import controleur.AlarmeListener;
import controleur.VehiculeListener;

/**
 * 
 * @author Sofiane BOUKHEBELT
 *
 */
public class Borne implements VehiculeListener {
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
	protected final int _alea = 10;
	private TypeBorne _t;
	
	public enum TypeBorne {
	    MANUELLE, AUTOMATIQUE, TELEPEAGE
	}
	
	public Borne(int numeroVoie, TypeBorne t) {
		_numeroVoie = numeroVoie;
		_barriere = new BarrierePhysique();
		_feu = new Feu();
		_rapport = new Rapport();
		_nouvelleVoiture = false;
		_compteurVehicules = 0;
		_t = t;
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
	
	
	public void addAlarmeListener(AlarmeListener l) {
		if (_alarmeListener == null) {
			_alarmeListener = l;
		}
	}
	
	public void removeAlarmeListener(VehiculeListener l) {
		if (_alarmeListener!= null || _alarmeListener == l) {
			_alarmeListener = null;
		}
	}
	
	private void declencherAlarme(TypeAlarme alarme) {
		if (_alarmeListener != null) {
			AlarmeEvent evt = new AlarmeEvent(this, alarme);
			_alarmeListener.alarmeDeclenchee(evt);
		}
	}
	
	@Override
	public synchronized void gererVehicule(VehiculeEvent evt) {
		try {
			Thread.sleep(2000);
			if (new Random().nextInt(_alea) == _alea - 1) {
				declencherAlarme(TypeAlarme.REFUS_PAIEMENT);
			} else {
				_rapport.faireRapport(evt.getType(), _numeroVoie, new Date(), 0, _t);
				System.out.println("Vehicule passé");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}