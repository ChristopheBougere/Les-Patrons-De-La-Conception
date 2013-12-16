package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Parametre;

import vue.ChoixBorne;
import vue.ChoixFlux;

/**
 * 
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 */
public class Main implements ActionListener {
	private ChoixBorne _cb;
	private ChoixFlux _cf;
	private Superviseur _s;
	
	
	public Main() {
		_cb = new ChoixBorne();
		_cb.getB_suivant().addActionListener(this);
		_cb.setVisible(true);
		_cf = new ChoixFlux();
		_cf.getB_precedent().addActionListener(this);
		_cf.getB_suivant().addActionListener(this);
	}
	
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == _cb.getB_suivant()) {
			_cb.setVisible(false);
			_cf.setVisible(true);
		} else if(e.getSource() == _cf.getB_precedent()) {
			_cf.setVisible(false);
			_cb.setVisible(true);
		} else if(e.getSource() == _cf.getB_suivant()) {
			_cf.setVisible(false);
			_s = new Superviseur(new Parametre(_cb.getNbMannuelles(), _cb.getNbAutomatiques(), _cb.getNbTelepeages(), _cf.getpVoitures(),
					_cf.getpCamions(), _cf.getpCaravanes(), _cf.getpBus(), _cf.getpMotos(), _cf.getFlux()));
		}
	}

}
