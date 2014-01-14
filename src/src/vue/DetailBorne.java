package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.Borne.TypeBorne;
import modele.RapportEvent;


/**
 * Fenêtre permettant de voir le détail d'une borne, c-à-d les rapports passés.
 * @author Christophe Bougère et Baraa Elyoussefi
 *
 */
public class DetailBorne extends JFrame implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _numero;
	private PanelBorne _panel;
	private JList L_liste;
	private ArrayList<RapportEvent> _rapports;
	private String _vehicules[];
	
	
	public DetailBorne(TypeBorne t, int i, ArrayList<RapportEvent> r) {
		super("Détail de la borne " + (i + 1));
		
		_rapports = new ArrayList<RapportEvent>();
		_numero = i;
		
		_panel = new PanelBorne();
		
		// On remplir l'arraylist avec uniquement les _rapports de cette voie
		if(r.size() > 0) {
			Iterator<RapportEvent> it = r.iterator();
			while (it.hasNext()) {
			       RapportEvent re = it.next();
			       if(re != null && re.get_numeroVoie() == i) {
				       _rapports.add(re);
			       }
			}
		}
		majInterface();
	}
	
	public void ajouterRapport(RapportEvent r) {
		_rapports.add(r);
	}
	
	public int getNumeroVoie() {
		return _numero;
	}
	
	public void majInterface() {
		_vehicules = new String[_rapports.size()];
		
		Iterator<RapportEvent> it = _rapports.iterator();
		int compteur = 0;
		while(it.hasNext()) {
		       RapportEvent re = it.next();
		       _vehicules[compteur] = "" + compteur + ": " + re.get_typeVehicule();
		       compteur++;
		}
		L_liste = new JList<String>(_vehicules);
		L_liste.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		L_liste.setLayoutOrientation(JList.VERTICAL);
		L_liste.setVisibleRowCount(-1);
		L_liste.addListSelectionListener(this);
		JScrollPane listScroller = new JScrollPane(L_liste);
		listScroller.setPreferredSize(new Dimension(150, 250));
		
		//this.getContentPane().setLayout(new BorderLayout(10, 10));
		this.getContentPane().removeAll();
		this.getContentPane().add(listScroller, BorderLayout.WEST);
		this.getContentPane().add(_panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.setSize(450, 250);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList liste = (JList) e.getSource();
		ListSelectionModel lsm = liste.getSelectionModel();
		int minIndex = lsm.getMinSelectionIndex();
        int maxIndex = lsm.getMaxSelectionIndex();
        for(int i = minIndex; i <= maxIndex; i++) {
            if(lsm.isSelectedIndex(i)) {
                int n = Integer.parseInt(((String) L_liste.getModel().getElementAt(i)).split(":")[0]);
                _panel.mettreAJour(_rapports.get(n));
            }
        }
	}
}
