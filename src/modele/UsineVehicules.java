package modele;

import java.util.Random;


import modele.VehiculeEvent.TypeVehicule;
import controleur.VehiculeListener;

/**
 * 
 * @author Sofiane BOUKHEBELT
 * @author Ghita BAOUZ
 *
 */
public class UsineVehicules extends java.lang.Thread {
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

	public boolean isStopped(){
		return !_canRun;
	
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
			//System.out.println("Usine en route");
			if (_vehiculeListener != null) {
			try {
					Random r = new Random();
					
					int tab[] = new int[] { _p.nbVoitures + _p.nbBus + _p.nbCamions
							+ _p.nbCaravanes + _p.nbMotos,
							_p.nbVoitures, _p.nbBus, _p.nbCamions, _p.nbCaravanes, _p.nbMotos };
					
					while (tab[0] != 0 && _vehiculeListener != null) {
						TypeVehicule typeVehicule = TypeVehicule.getRandom();
						VehiculeEvent evt = new VehiculeEvent(this, typeVehicule, r.nextInt(_p.nbVoies));
						_vehiculeListener.gererVehicule(evt);
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
