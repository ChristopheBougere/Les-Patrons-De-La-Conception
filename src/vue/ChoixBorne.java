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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChoixBorne extends JFrame {
	
	private JLabel L_choix, L_nbManuelles, L_nbTelepeage, L_nbAutomatiques;
	private JSpinner S_nbManuelles, S_nbTelepeage, S_nbAutomatiques;
	private JButton B_suivant;
	private BoxLayout BL;
	private JPanel P_nbManuelles, P_nbTelepeage, P_nbAutomatiques;
	
	public ChoixBorne() {
		super("Choix des bornes");
		
		L_choix = new JLabel("Choix des bornes :");
		L_nbManuelles = new JLabel("Nombre de bornes manuelles : ");
		L_nbTelepeage = new JLabel("Nombre de bornes télépéage : ");
		L_nbAutomatiques = new JLabel("Nombre de bornes automatiques : ");
		
		S_nbManuelles = new JSpinner();
		JSpinner.NumberEditor NE_nbManuelles = new JSpinner.NumberEditor(S_nbManuelles);
		S_nbManuelles.setEditor(NE_nbManuelles);
		NE_nbManuelles.getModel().setMinimum(0);
		NE_nbManuelles.getModel().setMaximum(9);
		NE_nbManuelles.getModel().setValue(2);
		S_nbTelepeage = new JSpinner();
		JSpinner.NumberEditor NE_nbTelepeage = new JSpinner.NumberEditor(S_nbTelepeage);
		S_nbTelepeage.setEditor(NE_nbTelepeage);
		NE_nbTelepeage.getModel().setMinimum(0);
		NE_nbTelepeage.getModel().setMaximum(9);
		NE_nbTelepeage.getModel().setValue(2);
		S_nbAutomatiques = new JSpinner();
		JSpinner.NumberEditor NE_nbAutomatiques = new JSpinner.NumberEditor(S_nbAutomatiques);
		S_nbAutomatiques.setEditor(NE_nbAutomatiques);
		NE_nbAutomatiques.getModel().setMinimum(0);
		NE_nbAutomatiques.getModel().setMaximum(9);
		NE_nbAutomatiques.getModel().setValue(2);
		
		B_suivant = new JButton("Suivant");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		BL = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
		getContentPane().setLayout(BL);
		
		P_nbManuelles = new JPanel();
		P_nbManuelles.setLayout(new FlowLayout());
		P_nbManuelles.add(L_nbManuelles);
		P_nbManuelles.add(S_nbManuelles);
		
		P_nbTelepeage = new JPanel();
		P_nbTelepeage.setLayout(new FlowLayout());
		P_nbTelepeage.add(L_nbTelepeage);
		P_nbTelepeage.add(S_nbTelepeage);
		
		P_nbAutomatiques = new JPanel();
		P_nbAutomatiques.setLayout(new FlowLayout());
		P_nbAutomatiques.add(L_nbAutomatiques);
		P_nbAutomatiques.add(S_nbAutomatiques);
		
		getContentPane().add(L_choix);
		getContentPane().add(P_nbManuelles);
		getContentPane().add(P_nbTelepeage);
		getContentPane().add(P_nbAutomatiques);
		getContentPane().add(B_suivant);
		
		this.pack();
		this.setVisible(true);
		
	}

	public JButton getB_suivant() {
		return B_suivant;
	}
}
