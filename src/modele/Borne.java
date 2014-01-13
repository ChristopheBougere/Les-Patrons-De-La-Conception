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
public class Borne extends VehiculeListener {
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
	private final int _alea1 = 50;
	private final int _alea2 = 50;
	private Parametre _p;
	private UsineVehicules _usineVehicules;
	private RapportListener _rapportListener;


	public enum TypeBorne {
		MANUELLE, AUTOMATIQUE, TELEPEAGE
	}

	public Borne(int numeroVoie, TypeBorne typeBorne, Parametre p) {
		System.out.println("Nouvelle borne n°" + numeroVoie);
		_numeroVoie = numeroVoie;
		_barriere = new BarrierePhysique();
		_feu = new Feu();
		_nouvelleVoiture = false;
		_compteurVehicules = 0;
		_typeBorne = typeBorne;
		_p = p;
		_usineVehicules = new UsineVehicules(_p);
		_usineVehicules.addVehiculeListener(this);
		setListenerActive(true);
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
			_alarmeListener.alarmeDeclenchee(evt,_numeroVoie);
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
			double prixParKm =0;
			switch(vehicule.typeVehicule()) {
			case CAMION:
				prixParKm=0.2;
				break;
			case BUS:
				prixParKm=0.15;
				break;
			case CARAVANE:
				prixParKm=0.13;
				break;
			case MOTO:
				prixParKm=0.08;
				break;
			case VOITURE:
				prixParKm=0.12;
				break;
			case SPECIAL:
				prixParKm=0;
				break;
			}
			int nombreKm=(new Random()).nextInt(500)+1;
			double coeff = 1.0;
			if(_typeBorne == TypeBorne.TELEPEAGE) {
				coeff = 0.75;
			}
			double somme=coeff*prixParKm*nombreKm;
			RapportEvent event = new RapportEvent(this, vehicule.typeVehicule(), _numeroVoie,
					new Date(), somme, _typeBorne);
			System.out.println(event);
			_rapportListener.rapportEnvoye(event);
		}
	}

	public void relancerUsine(){
		_usineVehicules.relancer();
		setListenerActive(true);
		//_usineVehicules.addVehiculeListener(this);
	}
	
	/** 
	 * Cette méthode permet de dire si la borne automatique manque de monnaie ou pas
	 */
	public boolean manqueMonnaie(){
		Random rand = new Random();

		return rand.nextInt(_alea1)+1==_alea1;
	}
	
	/** 
	 * Cette méthode permet de dire si le guichetier a appuyé sur le bouton alarme ou pas
	 */
	public boolean boutonAlarme(){
		Random rand = new Random();

		return rand.nextInt(_alea2)+1==_alea2;
	}
	
	public void stopperUsine() {
		if(!_usineVehicules.kill())
			System.out.println("Usine arretee (borne)");
		setListenerActive(false);
	}

	/**
	 * Procédure de paiement et de passage d'un véhicule
	 */
	@Override
	public synchronized void gererVehicule(VehiculeEvent vehicule) {
		//while(!borneDisponible()) 
			//System.out.println("la borne n'est pas disponible");
		if(borneDisponible()) {
			System.out.println("la borne est disponible");
			Random rand = new Random();
			try {
				Thread.sleep(1000 * (rand.nextInt(3) + 1)); // paiement
				/*if (new Random().nextInt(_alea) == _alea - 1) {
					declencherAlarme(TypeAlarme.REFUS_PAIEMENT);
					//_usineVehicules.removeVehiculeListener(this);
				}*/
				if (_typeBorne==TypeBorne.AUTOMATIQUE && manqueMonnaie()) {
					declencherAlarme(TypeAlarme.PLUS_DE_MONNAIE);
					stopperUsine();
				} else if(_barriere.barriereLevee()){
					declencherAlarme(TypeAlarme.BARRIERE_NON_LEVEE);
					stopperUsine();
				} else if(boutonAlarme()){
					declencherAlarme(TypeAlarme.BOUTON);
					stopperUsine();
				} else {
					envoyerRapport(vehicule);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}