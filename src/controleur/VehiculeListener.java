package controleur;

import java.util.EventListener;

import modele.VehiculeEvent;

public interface VehiculeListener extends EventListener {
	public void gererVehicule(VehiculeEvent evt);
}
