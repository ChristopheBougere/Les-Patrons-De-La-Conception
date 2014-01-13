package modele;

import java.awt.Image;
import java.awt.Toolkit;


public class EtatFerme implements EtatBorne {

	@Override
	public Image afficherImage() {
		return Toolkit.getDefaultToolkit().getImage("EtatFerme.png");
	}

}