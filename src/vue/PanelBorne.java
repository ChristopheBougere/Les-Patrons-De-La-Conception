package vue;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import modele.RapportEvent;
/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class PanelBorne extends JPanel {
	private JLabel typeVehicule;
	private JLabel NumBorne;
	private JTextField JtextSomme;
	private JLabel Somme;
	private JTextField JtextTypeBorne;
	private JLabel TypeBorne;
	private JTextField JTextHeure;
	private JLabel Heure;
	private JTextField JtextNumBorne;
	private JTextField JtextType;

	public PanelBorne() {
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)this);
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(310, 238));
			{
				typeVehicule = new JLabel();
				typeVehicule.setText("Type du véhicule  :");
				typeVehicule.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				JtextType = new JTextField();
			}
			{
				NumBorne = new JLabel();
				NumBorne.setText("Numéro de la borne :");
				NumBorne.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				JtextNumBorne = new JTextField();
			}
			{
				Heure = new JLabel();
				Heure.setText("Heure:");
				Heure.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				JTextHeure = new JTextField();
			}
			{
				TypeBorne = new JLabel();
				TypeBorne.setText("Type de la borne:");
				TypeBorne.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				JtextTypeBorne = new JTextField();
			}
			{
				Somme = new JLabel();
				Somme.setText("Somme perçue:");
				Somme.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				JtextSomme = new JTextField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(JtextType, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(typeVehicule, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(JtextNumBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(NumBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(JTextHeure, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(Heure, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(JtextTypeBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(TypeBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(22)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(JtextSomme, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				    .addComponent(Somme, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(23, 23));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGap(7)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(Somme, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(41))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(TypeBorne, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(26))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(Heure, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
				        .addGap(38))
				    .addComponent(NumBorne, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(typeVehicule, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(JtextSomme, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(JtextTypeBorne, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(JTextHeure, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(JtextNumBorne, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(JtextType, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(46, Short.MAX_VALUE));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mettreAJour( RapportEvent r){
		
		JtextType.setText(r.get_typeVehicule().toString());
		JtextNumBorne.setText(String.valueOf(r.get_numeroVoie()));
		JtextSomme.setText(String.valueOf(r.get_sommePercue()));
		JTextHeure.setText(r.get_heure().toString());
		JtextTypeBorne.setText(r.get_typeBorne().toString());
		
	}


}