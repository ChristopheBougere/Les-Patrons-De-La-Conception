package modele;

import javax.swing.ImageIcon;

/**
 * @author elyoussefi Baraa
 * @author Bougère Christophe
 * Cette classe implemente l'interface EtatBorne , et représente l'état où la barrière n'est pas levée.
 * 
 * */
public class EtatFerme implements EtatBorne {

	/* (non-Javadoc)
	 * @see modele.EtatBorne#afficherImage()
	 */
	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatFerme.png");
	}

}