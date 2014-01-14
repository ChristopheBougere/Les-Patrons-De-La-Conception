package modele;

import javax.swing.ImageIcon;


/**
 * @author elyoussefi Baraa
 * @author Bougère Christophe
 * Cette classe implemente l'interface EtatBorne , et représente l'état où la barrière est  levée.
 * 
 * */
public class EtatOuvert implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatOuvert.png");
	}

}
