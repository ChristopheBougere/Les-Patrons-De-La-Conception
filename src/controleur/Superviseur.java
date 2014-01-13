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
 */
public class Superviseur implements AlarmeListener, RapportListener, ActionListener {
	
	private Fenetre _f;
	private HashMap<FenetreAlarme, Integer> _fa;
	private ArrayList<Borne> _voies;
	private Parametre _p;

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
	}

	public int getNbVoiesOuvertes(){
		return _voies.size();
	}

	public void ouvrirVoie(TypeBorne t) {
		Borne voie = new Borne(_voies.size(), t, _p);

		voie.addAlarmeListener(this);
		voie.addRapportListener(this);
		_voies.add(voie);
		_f.ajouterBorne(t, voie);
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
	
	/**
	 * On ouvre une fenêtre pour notifier de l'alarme
	 * Puis on ajoute l'actionListener pour détecter l'appuie sur le bouton "OK"
	 */
	public void ajouterEtAfficherFenetre(AlarmeEvent event, int numeroVoie) {
		FenetreAlarme fa = new FenetreAlarme(event.getMessage());
		fa.get_jButtonOK().addActionListener(this);
		_fa.put(fa, numeroVoie);
	}
	
	/**
	 * Affiche une fenêtre d'alarme avec son message lorsque celle-ci est déclenchée
	 */
	@Override
	public void alarmeDeclenchee(AlarmeEvent e, int numVoie) {
		final AlarmeEvent event = e;
		final int numeroVoie = numVoie;
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				if( _fa.size() < 6){
					ajouterEtAfficherFenetre(event, numeroVoie);
				}
			}
		});
		
	}
	
	public Parametre getParametres() {
		return _p;
	}

	@Override
	public void rapportEnvoye(RapportEvent r) {
		_f.envoiRapport(r);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for ( FenetreAlarme fa : _fa.keySet() ) {
			if( e.getSource() == fa.get_jButtonOK() ){
				_voies.get(_fa.get(fa)).relancerUsine();
				fa.dispose();
				_fa.remove(fa);
				break;
			}
		}
	}

}
