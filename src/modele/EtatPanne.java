package modele;

import java.awt.Image;
import java.awt.Toolkit;


public class EtatPanne implements EtatBorne {

	@Override
	public Image afficherImage() {
		return Toolkit.getDefaultToolkit().getImage("EtatPanne.png");
	}

}