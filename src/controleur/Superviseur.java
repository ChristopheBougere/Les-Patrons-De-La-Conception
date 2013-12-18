package controleur;
import java.util.ArrayList;
import java.util.List;

import modele.AlarmeEvent;
import modele.Borne;
import modele.BorneAutomatique;
import modele.Parametre;
import modele.Telepeage;
import modele.Borne.TypeBorne;
import modele.BorneManuelle;


import vue.Fenetre;
import vue.FenetreAlarme;

/**
 * @author Ghita BAOUZ
 * @author Baraa EL YOUSSEFI
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 *
 */
public class Superviseur implements AlarmeListener  {
	
	private Fenetre _f;
	private List<Borne> _voies;
	private Parametre _p;

	public Superviseur(Parametre p, Fenetre f){
		_p = p;
		_f = f;
		_voies= new ArrayList<Borne>();

		try {
			for (int i = 0; i < p.nbManuelles; i++) {
				ouvrirVoie(TypeBorne.MANUELLE);
			}
			for (int i = 0; i < p.nbAutomatiques; i++) {
				ouvrirVoie(TypeBorne.AUTOMATIQUE);
			}
			for (int i = 0; i < p.nbTelepeages; i++) {
				ouvrirVoie(TypeBorne.TELEPEAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public int getNbVoiesOuvertes(){
		return _voies.size();
	}

	public void ouvrirVoie(TypeBorne t) throws Exception{
		Borne voie = new Borne(_voies.size(), t);

		voie.addAlarmeListener(this);
		_voies.add(voie);
		_f.ajouterBorne(t);
	}
	
	public void fermerVoie(Borne voie){
		_voies.remove(voie);
	}
	
	@Override
	public void alarmeDeclenchee(AlarmeEvent e) {
		new FenetreAlarme(e.getMessage());

	}
	
}
	
	
	
	
	
	

