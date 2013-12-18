package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import modele.Borne.TypeBorne;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Christophe Bougère
 *
 */
public class Fenetre extends JFrame implements MouseListener {
	private ArrayList<JButton> B_bornes;
	private ArrayList<JLabel> L_vehicules;
	private JButton B_parametres;
	private GridBagLayout GBL_layout;
	private BorderLayout BL_layout;
	private JPanel P_bornes;
	
	public Fenetre() {
		super("Simulateur de barrière de péage");
		
		B_parametres = new JButton("Modifier les paramètres");
		B_parametres.addMouseListener(this);
		
		BL_layout = new BorderLayout(20, 20);
		this.setLayout(BL_layout);
		this.getContentPane().add(B_parametres, BorderLayout.SOUTH);
		razBornes();
		this.pack();
	}
	
	public String texteBouton(TypeBorne type, int numero) {
		String texte = "B";
		switch(type){
		case MANUELLE:
			texte += "M";
			break;
		case AUTOMATIQUE:
			texte += "A";
			break;
		case TELEPEAGE:
			texte += "T";
			break;
		}
		texte += "-" + numero;
		return texte;
	}
	
	public void ajouterBorne(TypeBorne type) {
		int numero = B_bornes.size() + 1;
		String texte = texteBouton(type, numero);
		
		GridBagConstraints GBC = new GridBagConstraints();
		GBC.gridx = 2 * numero - 2;
		GBC.insets= new Insets(20, 20, 20, 20);
		GBC.gridy = 0;
	    
		JButton bouton = new JButton(texte);
		bouton.setPreferredSize(new Dimension(150, 150));
		B_bornes.add(bouton);
		P_bornes.add(bouton, GBC);

		GBC.gridy = 1;
		JLabel label = new JLabel("Aucun véhicule", SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(150, 150));
		L_vehicules.add(label);
		P_bornes.add(label, GBC);
		
		this.pack();
	}
	
	public void retirerBorne(int numero) {
		/*
		// On enlève les éléments du GridBagLayout
		P_bornes.remove(B_bornes.get(numero));
		P_bornes.remove(L_vehicules.get(numero));
		// On supprime le bouton
		B_bornes.remove(numero);
		// On décale les numéros
		for(int i = numero; i < B_bornes.size(); i++) {
			TypeBorne type = TypeBorne.MANUELLE;
			switch(B_bornes.get(i).getText().charAt(1)) {
			case 'M':
				type = TypeBorne.MANUELLE;
				break;
			case 'A':
				type = TypeBorne.AUTOMATIQUE;
				break;
			case 'T':
				type = TypeBorne.TELEPEAGE;
			}
			B_bornes.get(i).setText(texteBouton(type, i + 1));
		}
		// On supprime le label
		L_vehicules.remove(numero);
		// On repack la fenêtre
		this.pack();
		*/
	}
	
	public void razBornes() {
		B_bornes = new ArrayList<JButton>();
		L_vehicules = new ArrayList<JLabel>();
		
		GBL_layout = new GridBagLayout();
		P_bornes = new JPanel(GBL_layout);

		this.getContentPane().add(P_bornes, BorderLayout.CENTER);
		
		this.pack();
	}
	
	public JLabel getLabel(int i) {
		return L_vehicules.get(i);
	}
	
	public JButton getButton(int i) {
		return B_bornes.get(i);
	}
	
	// Méthodes à supprimer (juste pour tester les fonctions) avec le implements mouselistener

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 1) {
			ajouterBorne(TypeBorne.MANUELLE);
		} else {
			razBornes();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
