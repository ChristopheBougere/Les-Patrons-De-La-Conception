package modele;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class EtatOuvert implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatOuvert.png");
	}

}
