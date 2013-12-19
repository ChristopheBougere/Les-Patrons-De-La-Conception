package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingUtilities;

import modele.AlarmeEvent;
import modele.Borne;
import modele.Parametre;
import modele.RapportEvent;
import modele.Borne.TypeBorne;


import modele.Rapport;
import vue.Fenetre;
import vue.FenetreAlarme;

/**
 * @author Ghita BAOUZ
 * @author Baraa EL YOUSSEFI
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 * @author Walid IBARBACHANE
 *
 */
public class Superviseur implements AlarmeListener, RapportListener, ActionListener {
	
	private Fenetre _f;
	private ArrayList<FenetreAlarme> _fa;
	private ArrayList<Borne> _voies;
	private Parametre _p;

	public Superviseur(Parametre p, Fenetre f){
		_p = p;
		_f = f;
		_fa = new ArrayList<FenetreAlarme>();
		
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
		Borne voie = new Borne(_voies.size(), t, _p);

		voie.addAlarmeListener(this);
		voie.addRapportListener(this);
		_voies.add(voie);
		_f.ajouterBorne(t);
	}
	
	public void fermerVoie(Borne voie){
		_voies.remove(voie);
	}
	
	/**
	 * 
	 * @param numeroVoie
	 * @return La borne n° numeroVoie
	 */
	public Borne getBorne(int numeroVoie) {
		return _voies.get(numeroVoie);
	}
	
	private void ajouterActionListener(){
		_fa.get(_fa.size() - 1).get_jButtonOK().addActionListener(this);
	}
	/**
	 * Affiche une fenêtre d'alarme avec son message lorsque celle-ci est déclenchée
	 */
	@Override
	public void alarmeDeclenchee(AlarmeEvent e, int numeroVoie) {
		//final int numeroVoieAlarme = numeroVoie;
		final AlarmeEvent cpy = e;
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				_fa.add(new FenetreAlarme(cpy.getMessage()));
				ajouterActionListener();
			}
		});
		
	}
	
	public Parametre getParametres() {
		return _p;
	}

	@Override
	public void rapportEnvoye(RapportEvent r) {
		System.out.println("rapport envoye");
		_f.envoiRapport(r);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < _fa.size(); i++) {
			if( e.getSource() == _fa.get(i).get_jButtonOK()){
				System.out.println("plop");
				_fa.get(i).dispose();
				_voies.get(i).relancerUsine();
			}
		}
	}
	
}
	
	
	
	
	
	

