package vue;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTextField;

import modele.Borne.TypeBorne;
import modele.RapportEvent;


public class DetailBorne extends JFrame {

	private TypeBorne type;
	private int numero;
	private JTextField TF_texte;
	
	
	public DetailBorne(TypeBorne t, int i, ArrayList<RapportEvent> r) {
		super("Détail de la borne " + i);
		
		type = t;
		numero = i;
		this.setSize(400, 400);
		
		String texte = "";
		
		TF_texte = new JTextField();
		Iterator<RapportEvent> it = r.iterator();
		 
		while (it.hasNext()) {
		       RapportEvent re = it.next();
		       texte += re;
		}
		TF_texte.setText(texte);
		this.getContentPane().add(TF_texte);
		this.pack();
		this.setVisible(true);
		this.setSize(400, 400);
	}
}
