package modele;


import java.util.Date;
import java.util.Random;

import modele.AlarmeEvent.TypeAlarme;
import modele.VehiculeEvent.TypePaiement;
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
	private int _compteurVehicules;
	private AlarmeListener _alarmeListener;
	private TypeBorne _typeBorne;
	private final int _aleaManqueMonnaie = 50;
	private final int _aleaBoutonAlarme = 50;
	private final int _aleaPaiementRefuse = 50;
	private final int _aleaPlusieursVehicules = 50;
	private final int _aleaBarriereNonLevee = 50;
	private Parametre _p;
	private UsineVehicules _usineVehicules;
	private RapportListener _rapportListener;
	private boolean _active = true;
	private EtatBorne _etat;

	public enum TypeBorne {
		MANUELLE, AUTOMATIQUE, TELEPEAGE
	}

	private class UsineVehicules extends java.lang.Thread {
		private VehiculeListener _vehiculeListener;
		private Parametre _p;
		private boolean _canRun;

		public UsineVehicules(Parametre p) {
			_p = p;
			_canRun = true;
		}

		public void kill() {
			_canRun = false;
		}

		public void relancer() {
			_canRun = true;
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

		/**
		 * Envoie des VehiculeEvent selon les paramètres (variable p)
		 */
		@Override	
		public void run() {
			while (_canRun) {
				if (_vehiculeListener != null) {
					try {
						int tab[] = new int[] { _p.nbVoitures + _p.nbBus + _p.nbCamions
								+ _p.nbCaravanes + _p.nbMotos,
								_p.nbVoitures, _p.nbBus, _p.nbCamions, _p.nbCaravanes, _p.nbMotos };

						while (tab[0] != 0 && _vehiculeListener != null) {
							TypeVehicule typeVehicule = TypeVehicule.getRandom();
							VehiculeEvent vehicule = new VehiculeEvent(this, typeVehicule, _numeroVoie,
									_typeBorne);	
							_vehiculeListener.gererVehicule(vehicule);
							Thread.sleep(60000 / _p.flux);
							tab[0]--;
							switch (typeVehicule) {
							case VOITURE: tab[1]--; break;
							case BUS: tab[2]--; break;
							case CAMION: tab[3]--; break;
							case CARAVANE: tab[4]--; break;
							case MOTO: tab[5]--; break;
							}
						}
					} catch (InterruptedException e) {
						e.getStackTrace();
					}
				} else {
					_canRun = false;
				}
			}
		}

	}

	public Borne(int numeroVoie, TypeBorne typeBorne, Parametre p) {
		_numeroVoie = numeroVoie;
		_barriere = new BarrierePhysique();
		_feu = new Feu();
		_compteurVehicules = 0;
		_typeBorne = typeBorne;
		_p = p;
		_usineVehicules = new UsineVehicules(_p);
		_usineVehicules.addVehiculeListener(this);
		setListenerActive(true);
		_usineVehicules.start();
		_etat = new EtatOuvert();
	}

	public void setListenerActive (boolean active){
		_active = active;
	}
	/**
	 * Methode qui permet de savoir si la borne est disponible
	 * 
	 * @return true si elle l'est.
	 */
	public boolean borneDisponible(){
		return _active;
	}

	public int getFluxVehicule() {
		return _compteurVehicules;
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
			RapportEvent rapport = new RapportEvent(this, vehicule.typeVehicule(), _numeroVoie,
					new Date(), somme, _typeBorne, vehicule.typePaiement());
			_rapportListener.rapportEnvoye(rapport);
			System.out.println(rapport);
		}
	}

	public void relancerUsine() {
		_usineVehicules.relancer();
		setListenerActive(true);
		_etat = new EtatFerme();
	}

	public boolean alea(int alea) {
		return (new Random()).nextInt(alea) == alea - 1;
	}

	public void stopperUsine() {
		_usineVehicules.kill();
		setListenerActive(false);
		_etat = new EtatPanne();
	}

	/**
	 * Attend un temps aléatoire entre 1 et 3s pour simuler le paiement d'un véhicule
	 * 
	 * @throws InterruptedException because the thread is sleeped within this function
	 */
	public void effectuerPaiement() throws InterruptedException {
		Thread.sleep(1000 * ((new Random()).nextInt(3) + 1));
	}

	/**
	 * Procédure de paiement et de passage d'un véhicule
	 */
	@Override
	public synchronized void gererVehicule(VehiculeEvent vehicule) {
		if (borneDisponible()) {
			try {
				effectuerPaiement();
				TypePaiement typePaiement = vehicule.typePaiement();
				if (_typeBorne == TypeBorne.AUTOMATIQUE && alea(_aleaManqueMonnaie)) {
					declencherAlarme(TypeAlarme.PLUS_DE_MONNAIE);
					stopperUsine();
				} else if (alea(_aleaBoutonAlarme)) {
					declencherAlarme(TypeAlarme.BOUTON);
					stopperUsine();
				} else if (typePaiement == TypePaiement.ABONNEMENT && alea(_aleaPaiementRefuse)) {
					declencherAlarme(TypeAlarme.REFUS_PAIEMENT);
					stopperUsine();
				} else if (alea(_aleaPlusieursVehicules)) {
					declencherAlarme(TypeAlarme.PLUSIEURS_VEHICULES);
					stopperUsine();
				} else if (alea(_aleaBarriereNonLevee)) {
					declencherAlarme(TypeAlarme.BARRIERE_NON_LEVEE);
					stopperUsine();
				} else {
					_etat = new EtatOuvert();
					_barriere.leverBarriere();
					envoyerRapport(vehicule);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public EtatBorne get_etat() {
		return _etat;
	}
	
}