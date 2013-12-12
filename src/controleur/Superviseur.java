

/*
 * Ghita & Baraa 
 * */


package controleur;
import modele.Alarme;
import modele.Borne;
import java.util.*;

import vue.FenetreAlarme;

public class Superviseur implements AlarmeListener  {
	
	private List<Alarme> _alarmes;
	private List<Borne> _voies;
	private String _message
	
	public Superviseur(){
		_alarmes= new ArrayList<Alarme>();
		_voies= new ArrayList<Borne>();
		
	}
	
	public int getNbVoiesOuvertes(){
		return _voies.size;
	}

	public void ouvrirVoie(){
		Borne voie= new Borne();
		voie.addAlarmeListener(this);
		_voies.add(voie);
	}
	
	public void fermerVoie(Borne voie){
		_voies.remove(voie)
	}
	
	public void alarmeDeclenchee(Alarme a){
		new FenetreAlarme(a.getMessage());
	}
	
	
	
}
	
	
	
	
	
	

