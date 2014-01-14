package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Parametre;
import vue.ChoixBorne;
import vue.ChoixFlux;
import vue.Fenetre;
import vue.FenetrePause;

/**
 * 
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 */
public class Main implements ActionListener {
	private ChoixBorne _cb;
	private ChoixFlux _cf;
	private Fenetre _f;
	
	public Main() {
		_cb = new ChoixBorne();
		_cb.getB_suivant().addActionListener(this);
		_cb.setVisible(true);
		_cb.setLocationRelativeTo(null);
		
		_cf = new ChoixFlux();
		_cf.getB_precedent().addActionListener(this);
		_cf.getB_suivant().addActionListener(this);
		_cf.setLocationRelativeTo(null);
		
		_f = new Fenetre();
		_f.getB_parametres().addActionListener(this);
		_f.setLocationRelativeTo(null);
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
			Parametre p = new Parametre(_cb.getNbMannuelles(), _cb.getNbAutomatiques(), _cb.getNbTelepeages(), _cf.getpVoitures(),
					_cf.getpCamions(), _cf.getpCaravanes(), _cf.getpBus(), _cf.getpMotos(), _cf.getpSpeciaux(), _cf.getFlux());
			_f.razBornes();
			_f.setVisible(true);
			new FenetrePause(new Superviseur(p, _f));

		} else if (e.getSource() == _f.getB_parametres()) {
			_f.setVisible(false);
			_cb.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
