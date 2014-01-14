package controleur;

import java.util.EventListener;

import modele.VehiculeEvent;

/**
 * @autor Sofane BOUKHEBELT
 * @author Walid IBARBACHANE
 * 
 * Cette interface permet d'implémenter une classe qui réagit à un VehiculeEvent ( arrivée/passage d'une voiture )
 */
public interface VehiculeListener extends EventListener {
	
	public abstract void gererVehicule(VehiculeEvent evt);
    
}
