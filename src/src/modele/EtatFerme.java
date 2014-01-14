package modele;

import javax.swing.ImageIcon;

public class EtatFerme implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatFerme.png");
	}

}