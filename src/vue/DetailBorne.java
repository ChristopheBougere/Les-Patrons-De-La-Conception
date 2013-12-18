package vue;

import javax.swing.JFrame;

import modele.Borne.TypeBorne;


public class DetailBorne extends JFrame {

	private TypeBorne type;
	private int numero;
	
	public DetailBorne(TypeBorne t, int i) {
		super("Détail de la borne " + i);
		
		type = t;
		numero = i;
		this.setSize(400, 400);
	}
}
