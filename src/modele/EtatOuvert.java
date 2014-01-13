package modele;

import javax.swing.ImageIcon;

public class EtatOuvert implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatOuvert.png");
	}

}
