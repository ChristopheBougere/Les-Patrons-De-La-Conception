package controleur;

import java.util.EventListener;

import modele.VehiculeEvent;

/**
 * @autor Sofane BOUKHEBELT
 * @author Walid IBARBACHANE
 *
 */
public interface VehiculeListener extends EventListener {
	
	public abstract void gererVehicule(VehiculeEvent evt);
    
}
