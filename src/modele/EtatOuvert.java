package modele;

import java.awt.Image;
import java.awt.Toolkit;


public class EtatOuvert implements EtatBorne {

	@Override
	public Image afficherImage() {
		return Toolkit.getDefaultToolkit().getImage("EtatOuvert.png");
	}

}
