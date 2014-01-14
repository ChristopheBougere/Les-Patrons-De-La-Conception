package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modele.Borne;
import modele.Borne.TypeBorne;
import modele.RapportEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Fenêtre principale de l'application
 * @author Christophe Bougère
 *
 */
public class Fenetre extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Borne> _liste_bornes;
	private static ArrayList<JButton> B_bornes;
	private ArrayList<JLabel> L_vehicules;
	private ArrayList<RapportEvent> R_rapports;
	private JButton B_parametres;
	private GridBagLayout GBL_layout;
	private BorderLayout BL_layout;
	private JPanel P_bornes;
	private DetailBorne _db = null;
	
	public Fenetre() {
		super("Simulateur de barrière de péage");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		B_parametres = new JButton("Modifier les paramètres");
		
		BL_layout = new BorderLayout(20, 20);
		this.setLayout(BL_layout);
		this.getContentPane().add(B_parametres, BorderLayout.SOUTH);
		razBornes();
		this.pack();
	}
	
	/**
	 * Permet de générer le texte d'un bouton pour une borne
	 * @param type Type de borne
	 * @param numero Numéro de la borne
	 * @return Retourne la chaine de caractères correspondant à une borne
	 */
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
	
	/**
	 * Permet d'ajouter une borne
	 * @param type Type de borne
	 * @param b La borne modèle
	 */
	public void ajouterBorne(TypeBorne type, Borne b) {
		_liste_bornes.add(b);
		int numero = B_bornes.size() + 1;
		String texte = texteBouton(type, numero);
		
		GridBagConstraints GBC = new GridBagConstraints();
		GBC.gridx = 2 * numero - 2;
		GBC.insets= new Insets(20, 20, 20, 20);
		GBC.gridy = 0;
	    
		JButton bouton = new JButton(texte);
		bouton.addActionListener(this);
		bouton.setPreferredSize(new Dimension(150, 150));
		B_bornes.add(bouton);
		P_bornes.add(bouton, GBC);

		GBC.gridy = 1;
		JLabel label = new JLabel("Aucun véhicule", SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(150, 150));
		L_vehicules.add(label);
		P_bornes.add(label, GBC);
		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Permet de supprimer toutes les bornes
	 */
	public void razBornes() {
		_liste_bornes = new ArrayList<Borne>();
		B_bornes = new ArrayList<JButton>();
		L_vehicules = new ArrayList<JLabel>();
		R_rapports = new ArrayList<RapportEvent>();
		
		GBL_layout = new GridBagLayout();
		P_bornes = new JPanel(GBL_layout);

		this.getContentPane().add(P_bornes, BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public JLabel getLabel(int i) {
		return L_vehicules.get(i);
	}
	
	public JButton getButton(int i) {
		return B_bornes.get(i);
	}
	
	public JButton getB_parametres() {
		return B_parametres;
	}

	/**
	 * Affiche les détails d'une borne
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Quand on clique sur une borne, on veut les détails
		JButton b = (JButton) e.getSource();
		TypeBorne t = TypeBorne.MANUELLE;
		switch(b.getText().charAt(1)) {
		case 'A':
			t = TypeBorne.AUTOMATIQUE;
		case 'T':
			t = TypeBorne.TELEPEAGE;
		}
		int numero = Integer.parseInt(b.getText().substring(3));
		if(_db != null) {
			_db.dispose();
		}
		_db = new DetailBorne(t, numero - 1, R_rapports);
		_db.setLocationRelativeTo(null);
		_db.setVisible(true);
	}
	
	/**
	 * Met à jour le statut des bornes (images)
	 */
	public static void majImages() {
		for(int i = 0; i < _liste_bornes.size(); i++) {
			ImageIcon im = _liste_bornes.get(i).get_etat().afficherImage();
			B_bornes.get(i).setIcon(im);
		}
	}
	
	/**
	 * Méthode appellée dès qu'un rapport est envoyé, on l'ajoute donc à DetailBorne
	 * @param r Le rapport envoyé
	 */
	public void envoiRapport(RapportEvent r) {
		if(r == null) {
			System.out.println("ERREUR LE RAPPORT EST NUL");
		} else {
			R_rapports.add(r);
			if(_db != null && r.get_numeroVoie() == _db.getNumeroVoie()) {
				_db.ajouterRapport(r);
				_db.majInterface();
			}
			L_vehicules.get(r.get_numeroVoie()).setText(r.get_typeVehicule().toString().toLowerCase());
		}
	}
}
