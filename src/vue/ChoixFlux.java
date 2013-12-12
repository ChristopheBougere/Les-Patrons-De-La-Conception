package vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChoixFlux extends JFrame implements ActionListener, ChangeListener {
	private JLabel L_choix, L_pVoitures, L_pCamions, L_pBus, L_pCaravanes, L_pMotos, L_flux, L_erreurSomme;
	private JSpinner S_pVoitures, S_pCamions, S_pBus, S_pCaravanes, S_pMotos, S_flux;
	private JButton B_precedent, B_suivant;
	private JCheckBox CB_aleatoire;
	private BoxLayout BL;
	private JPanel P_voitures, P_camions, P_bus, P_caravanes, P_motos, P_flux, P_boutons;
	
	public ChoixFlux() {
		super("Choix des flux");
		
		L_choix = new JLabel("Choix des flux :");
		L_pVoitures = new JLabel("Pourcentage de voitures");
		L_pCamions = new JLabel("Pourcentage de camions");
		L_pBus = new JLabel("Pourcentage de bus");
		L_pCaravanes = new JLabel("Pourcentage de caravanes");
		L_pMotos = new JLabel("Pourcentage de motos");
		L_flux = new JLabel("Flux (véhicule/minute)");
		L_erreurSomme = new JLabel();
		L_erreurSomme.setForeground(Color.RED);
		
		CB_aleatoire = new JCheckBox("Flux aléatoire");
		CB_aleatoire.addActionListener(this);
		
		S_pVoitures = new JSpinner();
		JSpinner.NumberEditor NE_pVoitures = new JSpinner.NumberEditor(S_pVoitures);
		S_pVoitures.setEditor(NE_pVoitures);
		NE_pVoitures.getModel().setMinimum(0);
		NE_pVoitures.getModel().setMaximum(100);
		NE_pVoitures.getModel().setValue(50);
		S_pVoitures.addChangeListener(this);
		
		S_pCamions = new JSpinner();
		JSpinner.NumberEditor NE_pCamions = new JSpinner.NumberEditor(S_pCamions);
		S_pCamions.setEditor(NE_pCamions);
		NE_pCamions.getModel().setMinimum(0);
		NE_pCamions.getModel().setMaximum(100);
		NE_pCamions.getModel().setValue(10);
		S_pCamions.addChangeListener(this);
		
		S_pBus = new JSpinner();
		JSpinner.NumberEditor NE_pBus = new JSpinner.NumberEditor(S_pBus);
		S_pBus.setEditor(NE_pBus);
		NE_pBus.getModel().setMinimum(0);
		NE_pBus.getModel().setMaximum(100);
		NE_pBus.getModel().setValue(20);
		S_pBus.addChangeListener(this);
		
		S_pCaravanes = new JSpinner();
		JSpinner.NumberEditor NE_pCaravanes = new JSpinner.NumberEditor(S_pCaravanes);
		S_pCaravanes.setEditor(NE_pCaravanes);
		NE_pCaravanes.getModel().setMinimum(0);
		NE_pCaravanes.getModel().setMaximum(100);
		NE_pCaravanes.getModel().setValue(10);
		S_pCaravanes.addChangeListener(this);
		
		S_pMotos = new JSpinner();
		JSpinner.NumberEditor NE_pMotos = new JSpinner.NumberEditor(S_pMotos);
		S_pMotos.setEditor(NE_pMotos);
		NE_pMotos.getModel().setMinimum(0);
		NE_pMotos.getModel().setMaximum(100);
		NE_pMotos.getModel().setValue(10);
		S_pMotos.addChangeListener(this);
		
		S_flux = new JSpinner();
		JSpinner.NumberEditor NE_flux = new JSpinner.NumberEditor(S_flux);
		S_flux.setEditor(NE_flux);
		NE_flux.getModel().setMinimum(0);
		NE_flux.getModel().setMaximum(100);
		NE_flux.getModel().setValue(20);
		
		B_precedent = new JButton("Précédent");
		B_suivant = new JButton("Suivant");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		BL = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
		getContentPane().setLayout(BL);
		
		P_voitures = new JPanel();
		P_voitures.setLayout(new FlowLayout());
		P_voitures.add(L_pVoitures);
		P_voitures.add(S_pVoitures);
		
		P_camions = new JPanel();
		P_camions.setLayout(new FlowLayout());
		P_camions.add(L_pCamions);
		P_camions.add(S_pCamions);
		
		P_bus = new JPanel();
		P_bus.setLayout(new FlowLayout());
		P_bus.add(L_pBus);
		P_bus.add(S_pBus);
		
		P_caravanes = new JPanel();
		P_caravanes.setLayout(new FlowLayout());
		P_caravanes.add(L_pCaravanes);
		P_caravanes.add(S_pCaravanes);
		
		P_motos = new JPanel();
		P_motos.setLayout(new FlowLayout());
		P_motos.add(L_pMotos);
		P_motos.add(S_pMotos);
		
		P_flux = new JPanel();
		P_flux.setLayout(new FlowLayout());
		P_flux.add(L_flux);
		P_flux.add(S_flux);
		
		P_boutons = new JPanel();
		P_boutons.setLayout(new FlowLayout());
		P_boutons.add(B_precedent);
		P_boutons.add(B_suivant);
		
		getContentPane().add(L_choix);
		getContentPane().add(CB_aleatoire);
		getContentPane().add(P_voitures);
		getContentPane().add(P_camions);
		getContentPane().add(P_bus);
		getContentPane().add(P_caravanes);
		getContentPane().add(P_motos);
		getContentPane().add(P_flux);
		getContentPane().add(L_erreurSomme);
		getContentPane().add(P_boutons);
		
		this.pack();
		this.setVisible(true);
		
	}

	public JButton getB_precedent() {
		return B_precedent;
	}

	public JButton getB_suivant() {
		return B_suivant;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == CB_aleatoire) {
			if(CB_aleatoire.isSelected()) {
				S_pVoitures.setEnabled(false);
				S_pCamions.setEnabled(false);
				S_pBus.setEnabled(false);
				S_pCaravanes.setEnabled(false);
				S_pMotos.setEnabled(false);
				S_flux.setEnabled(false);
				
				S_pVoitures.setValue(50);
				S_pCamions.setValue(10);
				S_pBus.setValue(20);
				S_pCaravanes.setValue(10);
				S_pMotos.setValue(10);
				S_flux.setValue(20);
			} else {
				S_pVoitures.setEnabled(true);
				S_pCamions.setEnabled(true);
				S_pBus.setEnabled(true);
				S_pCaravanes.setEnabled(true);
				S_pMotos.setEnabled(true);
				S_flux.setEnabled(true);
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if((int) S_pVoitures.getValue() + (int) S_pCamions.getValue() + (int) S_pBus.getValue() + (int) S_pCaravanes.getValue() + (int) S_pMotos.getValue() != 100) {
			B_suivant.setEnabled(false);
			L_erreurSomme.setText("La somme des pourcentages ne vaut pas 100!");
		} else {
			B_suivant.setEnabled(true);
			L_erreurSomme.setText("");
		}
	}
}
