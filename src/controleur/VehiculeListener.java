package controleur;

import java.util.EventListener;

import modele.VehiculeEvent;

/**
 * @autor Sofane BOUKHEBELT
 * @author Walid IBARBACHANE
 *
 */
public abstract class VehiculeListener implements EventListener {
	
	public abstract void gererVehicule(VehiculeEvent evt);
    
	private boolean _active = true;
    
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
}
