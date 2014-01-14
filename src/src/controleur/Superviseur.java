package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import modele.AlarmeEvent;
import modele.Borne;
import modele.Parametre;
import modele.RapportEvent;
import modele.Borne.TypeBorne;


import vue.Fenetre;
import vue.FenetreAlarme;

/**
 * @author Ghita BAOUZ
 * @author Baraa EL YOUSSEFI
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 * @author Walid IBARBACHANE
 *
 * Cette classe décide de l'ouverture d'une voie
 * et de sa fermeture. Elle reçoit et traite les 
 * alarmes également. 
 *
 **/
public class Superviseur implements AlarmeListener, RapportListener, ActionListener {
	
	private Fenetre _f;
	private HashMap<FenetreAlarme, Integer> _fa;
	private ArrayList<Borne> _voies;
	private Parametre _p;
	
	/**
	 * Permet de savoir si la simulation est en pause ou non
	 */
	private boolean _pause;

	
	/**
	 * Constucteur 
	 * @param p
	 * @param f
	 */
	public Superviseur(Parametre p, Fenetre f){
		_p = p;
		_f = f;
		_fa = new HashMap<FenetreAlarme, Integer>();
		
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
		
		_pause = false;
	}

	
	/**
	 * Accesseur 
	 * @return _voies.size
	 */
	public int getNbVoiesOuvertes(){
		return _voies.size();
	}

	
	/**
	 * @param t
	 * Ouvrir une voie
	 */
	public void ouvrirVoie(TypeBorne t) {
		Borne voie = new Borne(_voies.size(), t, _p);

		voie.addAlarmeListener(this);
		voie.addRapportListener(this);
		_voies.add(voie);
		_f.ajouterBorne(t, voie);
	}
	
	/**
	 * @param Voie
	 * Ferme une voie
	 */
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
	
	/**
	 * @param event
	 * @param numeroVoie
	 * 
	 * On ouvre une fenêtre pour indiquer qu'une alarme a été déclenchée
	 * Puis on ajoute l'actionListener pour détecter l'appuie sur le bouton "OK"
	 */
	public void ajouterEtAfficherFenetre(AlarmeEvent event, int numeroVoie) {
		FenetreAlarme fa = new FenetreAlarme(event.getMessage());
		fa.get_jButtonOK().addActionListener(this);
		_fa.put(fa, numeroVoie);
	}
	
	/**
	 * @param e
	 * @param numVoie
	 * Affiche une fenêtre d'alarme avec son message lorsque celle-ci est déclenchée
	 */
	@Override
	public void alarmeDeclenchee(AlarmeEvent e, int numVoie) {
		Fenetre.majImages();
		final AlarmeEvent event = e;
		final int numeroVoie = numVoie;
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ajouterEtAfficherFenetre(event, numeroVoie);
			}
		});
		
	}
	/**
	 * Accesseur de la donnée membre _p
	 * @return _p
	 */
	public Parametre getParametres() {
		return _p;
	}


	
	/**
	 * @param r
	 * Envoie un rapport lorsqu'un event est détecté
	 */
	@Override
	public void rapportEnvoye(RapportEvent r) {
		_f.envoiRapport(r);
	}

	
	/**
	 * @param e
	 * Procédure qui relance une borne en arrêt par une alarme 
	 * et qui ferme la fenêtre de l'alarme en appuyant sur "OK"
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for ( FenetreAlarme fa : _fa.keySet() ) {
			if( e.getSource() == fa.get_jButtonOK() ){
				_voies.get(_fa.get(fa)).relancerUsine();
				fa.dispose();
				_fa.remove(fa);
				Fenetre.majImages();
				break;
			}
		}
	}

	/**
	 * Procédure mettant en pause la simulation si elle ne l'est pas déjà. Ne fait rien sinon.
	 */
	public void stopperBornes() {
		if (_pause)
			return;
		
		_pause = true;
		for (int i = 0; i < _voies.size(); i++) {
			_voies.get(i).stopperUsine();
		}
		Fenetre.majImages();
	}
	
	/**
	 * Procédure relançant l'usine si la simulation est déjà en pause. Ne fait rien sinon.
	 */
	public void relancerBornes() {
		if (!_pause)
			return;
		
		_pause = false;
		for (int i = 0; i < _voies.size(); i++) {
			_voies.get(i).relancerUsine();
		}
		Fenetre.majImages();
	}
	
}
