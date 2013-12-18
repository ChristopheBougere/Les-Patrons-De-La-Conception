package modele;


import java.util.Date;
import java.util.Random;

import modele.AlarmeEvent.TypeAlarme;
import modele.VehiculeEvent.TypeVehicule;

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
	protected Vehicule _vehicules;
	protected int _compteurVehicules;
	protected VehiculeListener _vehiculeListener = null;
	protected boolean _nouvelleVoiture;
	protected AlarmeListener _alarmeListener;
	protected TypeAlarme _alarme;
	private TypeBorne _typeBorne;
	private final int _alea = 10;
	private Parametre _p;
	
	public enum TypeBorne {
	    MANUELLE, AUTOMATIQUE, TELEPEAGE
	}
	
	public Borne(int numeroVoie, TypeBorne typeBorne, Parametre p) {
		_numeroVoie = numeroVoie;
		_barriere = new BarrierePhysique();
		_feu = new Feu();
		_nouvelleVoiture = false;
		_compteurVehicules = 0;
		_typeBorne = typeBorne;
		_p = p;
		UsineVehicules u = new UsineVehicules(_p);
		u.addVehiculeListener(this);
		u.start();
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
	
	public void declencherAlarme(TypeAlarme typeAlarme) {
		if (_alarmeListener != null) {
			AlarmeEvent evt = new AlarmeEvent(this, typeAlarme);
			_alarmeListener.alarmeDeclenchee(evt);
		}
	}
	
	public TypeBorne getType() {
		return _typeBorne;
	}
	
	/**
	 * Procédure de paiement et de passage d'un véhicule
	 */
	@Override
	public synchronized void gererVehicule(VehiculeEvent vehicule) {
		try {
			Thread.sleep(2000);
			if (new Random().nextInt(_alea) == _alea - 1) {
				declencherAlarme(TypeAlarme.REFUS_PAIEMENT);
			} else {
				Rapport r = new Rapport(vehicule.typeVehicule(), _numeroVoie,
						new Date(), 0, _typeBorne);
				System.out.println(r);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}