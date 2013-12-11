package vue;

import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class ChoixBorne extends JFrame implements AdjustmentListener {
	
	private JLabel L_choix, L_nbManuelles, L_nbTelepeage, L_nbAutomatiques;
	private JScrollBar SB_nbManuelles, SB_nbTelepeage, SB_nbAutomatiques;
	private JTextField TF_nbManuelles, TF_nbTelepeage, TF_nbAutomatiques;
	private JButton B_suivant;
	private BoxLayout BL;
	private JPanel P_nbManuelles, P_nbTelepeage, P_nbAutomatiques;
	
	public ChoixBorne() {
		super("Choix des bornes");

		L_choix = new JLabel("Choix des bornes :");
		L_nbManuelles = new JLabel("Nombre de bornes manuelles : ");
		L_nbTelepeage = new JLabel("Nombre de bornes télépéage : ");
		L_nbAutomatiques = new JLabel("Nombre de bornes automatiques : ");
		
		// Utiliser Spinner
		SB_nbManuelles = new JScrollBar(JScrollBar.VERTICAL, 2, 0, 0, 9);
		SB_nbManuelles.addAdjustmentListener(this);
		SB_nbTelepeage = new JScrollBar(JScrollBar.VERTICAL, 2, 0, 0, 9);
		SB_nbTelepeage.addAdjustmentListener(this);
		SB_nbAutomatiques = new JScrollBar(JScrollBar.VERTICAL, 2, 0, 0, 9);
		SB_nbAutomatiques.addAdjustmentListener(this);
		
		TF_nbManuelles = new JTextField("2");
		TF_nbManuelles.setEditable(false);
		TF_nbTelepeage = new JTextField("2");
		TF_nbTelepeage.setEditable(false);
		TF_nbAutomatiques = new JTextField("2");
		TF_nbAutomatiques.setEditable(false);
		
		B_suivant = new JButton("Suivant");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		BL = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
		getContentPane().setLayout(BL);
		
		P_nbManuelles = new JPanel();
		P_nbManuelles.setLayout(new FlowLayout());
		P_nbManuelles.add(L_nbManuelles);
		P_nbManuelles.add(TF_nbManuelles);
		P_nbManuelles.add(SB_nbManuelles);
		
		P_nbTelepeage = new JPanel();
		P_nbTelepeage.setLayout(new FlowLayout());
		P_nbTelepeage.add(L_nbTelepeage);
		P_nbTelepeage.add(TF_nbTelepeage);
		P_nbTelepeage.add(SB_nbTelepeage);
		
		P_nbAutomatiques = new JPanel();
		P_nbAutomatiques.setLayout(new FlowLayout());
		P_nbAutomatiques.add(L_nbAutomatiques);
		P_nbAutomatiques.add(TF_nbAutomatiques);
		P_nbAutomatiques.add(SB_nbAutomatiques);
		
		getContentPane().add(L_choix);
		getContentPane().add(P_nbManuelles);
		getContentPane().add(P_nbTelepeage);
		getContentPane().add(P_nbAutomatiques);
		getContentPane().add(B_suivant);
		
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getSource() == SB_nbManuelles) {
			TF_nbManuelles.setText(String.valueOf(SB_nbManuelles.getValue()));
		} else if(e.getSource() == SB_nbTelepeage) {
			TF_nbTelepeage.setText(String.valueOf(SB_nbTelepeage.getValue()));
		} else if(e.getSource() == SB_nbAutomatiques) {
			TF_nbAutomatiques.setText(String.valueOf(SB_nbAutomatiques.getValue()));
		}
		
	}
}
