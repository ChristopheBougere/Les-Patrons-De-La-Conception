package modele;


import javax.swing.ImageIcon;


public class EtatPanne implements EtatBorne {

	@Override
	public ImageIcon afficherImage() {
		return new ImageIcon("images/EtatPanne.png");
	}

}