package vue;

import java.text.SimpleDateFormat;

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
/**
 * Cette classe permet d'afficher le détail d'un rapoprt de manière graphique.
 * @author christophe
 *
 */
public class PanelBorne extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel _typeVehicule;
	private JLabel _numBorne;
	private JTextField _jTextSomme;
	private JLabel _somme;
	private JTextField _jTextTypeBorne;
	private JLabel _typeBorne;
	private JTextField _jTextHeure;
	private JLabel _heure;
	private JTextField _jTextNumBorne;
	private JTextField _jTextType;

	public PanelBorne() {
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)this);
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(310, 238));
			{
				_typeVehicule = new JLabel();
				_typeVehicule.setText("Type du véhicule  :");
				_typeVehicule.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				_jTextType = new JTextField();
			}
			{
				_numBorne = new JLabel();
				_numBorne.setText("Numéro de la borne :");
				_numBorne.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				_jTextNumBorne = new JTextField();
			}
			{
				_heure = new JLabel();
				_heure.setText("Heure:");
				_heure.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				_jTextHeure = new JTextField();
			}
			{
				_typeBorne = new JLabel();
				_typeBorne.setText("Type de la borne:");
				_typeBorne.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				_jTextTypeBorne = new JTextField();
			}
			{
				_somme = new JLabel();
				_somme.setText("Somme perçue:");
				_somme.setFont(new java.awt.Font("Dialog",1,12));
			}
			{
				_jTextSomme = new JTextField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(_jTextType, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(_typeVehicule, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(_jTextNumBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(_numBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(_jTextHeure, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(_heure, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(_jTextTypeBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(_typeBorne, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(22)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(_jTextSomme, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				    .addComponent(_somme, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(23, 23));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGap(7)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(_somme, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(41))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(_typeBorne, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(26))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(_heure, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
				        .addGap(38))
				    .addComponent(_numBorne, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(_typeVehicule, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(_jTextSomme, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(_jTextTypeBorne, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(_jTextHeure, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(_jTextNumBorne, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(_jTextType, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(46, Short.MAX_VALUE));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Met à jour le panel avec un nouveau rapport
	 * @param r Le rapport d'origine.
	 */
	public void mettreAJour( RapportEvent r){
		_jTextType.setText(r.get_typeVehicule().toString());
		_jTextNumBorne.setText(String.valueOf(r.get_numeroVoie() + 1));
		_jTextSomme.setText(String.valueOf(r.get_sommePercue()));
		_jTextHeure.setText(new SimpleDateFormat("dd/MM/yyyy, Ka").format(r.get_heure()));
		_jTextTypeBorne.setText(r.get_typeBorne().toString());
		
	}


}