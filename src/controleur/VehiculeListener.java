package controleur;

import java.util.EventListener;

import modele.VehiculeEvent;

/**
 * @autor Sofane BOUKHEBELT
 * @author ibarbachane
 *
 */
public abstract class VehiculeListener implements EventListener {
	public abstract void gererVehicule(VehiculeEvent evt);
    private  boolean _active = true;
    public  void setActive (boolean active){
        _active = active;
    }
    public  boolean isActive(){
    	return _active;
    }
}
