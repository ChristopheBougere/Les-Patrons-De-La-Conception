package modele;

import javax.swing.ImageIcon;

/**
 * @author elyoussefi Baraa
 * @author Bougère Christophe
 * Cette interface définit le comportement de l'état de la borne.
 */
public interface EtatBorne {

	/**
	 * Méthode abstraite qui sera implementé dans les classes dérivées.
	 * @return ImageIcon une image représentant l'état de la borne .
	 */
	public ImageIcon afficherImage();
}
