package modele;


import java.util.Date;
import java.util.Random;

import modele.AlarmeEvent.TypeAlarme;
import modele.VehiculeEvent.TypeVehicule;
import controleur.AlarmeListener;
import controleur.RapportListener;
import controleur.VehiculeListener;

/**
 * 
 * @author Sofiane BOUKHEBELT
 * @author Ghita Baouz
 *
 */
public class Borne implements VehiculeListener {
	private int _numeroVoie;
	private BarrierePhysique _barriere;
	private Feu _feu;
	private Vehicule _vehicules;
	private int _compteurVehicules;
	private VehiculeListener _vehiculeListener = null;
	private boolean _nouvelleVoiture;
	private AlarmeListener _alarmeListener;
	private TypeAlarme _alarme;
	private TypeBorne _typeBorne;
	private final int _alea = 10;
	private Parametre _p;
	private UsineVehicules _usineVehicules;
	private RapportListener _rapportListener;
	
	
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
		 _usineVehicules = new UsineVehicules(_p);
		_usineVehicules.addVehiculeListener(this);
		_usineVehicules.start();
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
	
	public void addRapportListener(RapportListener l){
		if (_rapportListener == null) {
			_rapportListener = l;
		}
	}
	
	public void removeRapportListener(RapportListener l) {
		if (_rapportListener!= null || _rapportListener == l) {
			_rapportListener = null;
		}
	}
	
	public void envoyerRapport(VehiculeEvent vehicule){
		if(_rapportListener != null){
			RapportEvent event = new RapportEvent(this, vehicule.typeVehicule(), _numeroVoie,
					new Date(), 0, _typeBorne);
			_rapportListener.rapportEnvoye(event);
		}
	}
	
	
	
	
	
	
	/**
	 * Procédure de paiement et de passage d'un véhicule
	 */
	@Override
	public synchronized void gererVehicule(VehiculeEvent vehicule) {
		Random rand = new Random();
		try {
			Thread.sleep(1000 * (rand.nextInt(3) + 1)); // paiement
			if (new Random().nextInt(_alea) == _alea - 1) {
				declencherAlarme(TypeAlarme.REFUS_PAIEMENT);
				_usineVehicules.kill();
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