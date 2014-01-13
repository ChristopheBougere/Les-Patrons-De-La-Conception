package modele;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class EtatPanne implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatPanne.png");
	}

}