package modele;


import javax.swing.ImageIcon;


/**
 * @author elyoussefi Baraa
 * @author Bougère Christophe
 * Cette classe implemente l'interface EtatBorne , et représente l'état de la borne lorqu'une alarme est déclenchée.
 * 
 * */
public class EtatPanne implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatPanne.png");
	}

}