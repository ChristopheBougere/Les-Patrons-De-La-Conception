package vue;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import modele.Borne.TypeBorne;
import modele.RapportEvent;


public class DetailBorne extends JFrame {

	private TypeBorne type;
	private int numero;
	private JTextArea TA_texte;
	
	
	public DetailBorne(TypeBorne t, int i, ArrayList<RapportEvent> r) {
		super("Détail de la borne " + i);
		
		type = t;
		numero = i;
		this.setSize(400, 400);
		
		String texte = "";
		
		TA_texte = new JTextArea();
		Iterator<RapportEvent> it = r.iterator();
		 
		while (it.hasNext()) {
		       RapportEvent re = it.next();
		       if(re.get_numeroVoie() == i) {
			       texte += re;   
		       }
		}
		TA_texte.setText(texte);
		this.getContentPane().add(TA_texte);
		this.pack();
		this.setVisible(true);
		this.setSize(800, 400);
	}
}
