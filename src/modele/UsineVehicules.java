package modele;

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
	
	public UsineVehicules(Parametre p) {
		_p = p;
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
	 * 
	 * @param percent Le pourcentage de véhicules
	 * @return
	 */
	private int numberOfVehicules(int percent) {
		return _p.flux * percent / 100;
	}
	
	@Override
	public void run() {
		if (_vehiculeListener != null) {
			for (int i = 0; i < numberOfVehicules(_p.pourcentVoitures) ; i++) {
				VehiculeEvent evt = new VehiculeEvent(this, TypeVehicule.VOITURE);
				_vehiculeListener.gererVehicule(evt);
			}
			for (int i = 0; i < numberOfVehicules(_p.pourcentBus); i++) {
				VehiculeEvent evt = new VehiculeEvent(this, TypeVehicule.BUS);
				_vehiculeListener.gererVehicule(evt);
			}
			for (int i = 0; i < numberOfVehicules(_p.pourcentCamions); i++) {
				VehiculeEvent evt = new VehiculeEvent(this, TypeVehicule.CAMION);
				_vehiculeListener.gererVehicule(evt);
			}
			for (int i = 0; i < numberOfVehicules(_p.pourcentCaravanes); i++) {
				VehiculeEvent evt = new VehiculeEvent(this, TypeVehicule.CARAVANE);
				_vehiculeListener.gererVehicule(evt);
			}
			for (int i = 0; i < numberOfVehicules(_p.pourcentMotos); i++) {
				VehiculeEvent evt = new VehiculeEvent(this, TypeVehicule.MOTO);
				_vehiculeListener.gererVehicule(evt);
			}
		}
	}
}
