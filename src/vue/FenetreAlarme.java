

package vue;

import java.awt.BorderLayout;
import javax.swing.*;


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
 * 
 * @author Ghita BAOUZ
 * @author Baraa EL YOUSSEFI
 * @author Sofiane BOUKHEBELT
 *
 */
public class FenetreAlarme extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel _label;
	private JButton _jButtonOK;
	private JPanel _panel;
	private String _message;
	
	public FenetreAlarme(String message){
		super();
		_message=message;
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
		initGUI();
	}
	
	private void initGUI() {
		try{
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			_panel = new JPanel();

			getContentPane().add(_panel, "West");
			_panel.setBounds(0, 0, 490, 76);
			_panel.setLayout(null);
			{
				_label = new JLabel();
				_panel.add(_label);
				_label.setText("Alarme : "+ _message);
				_label.setBounds(78, 26, 373, 25);
				_label.setFont(new java.awt.Font("Khmer OS",1,12));
			}
			{
				_jButtonOK = new JButton();
				_panel.add(_jButtonOK);
				_jButtonOK.setText("Ok");
				_jButtonOK.setBounds(421, 33, 30, 22);
			}
			pack();
			this.setSize(492, 117);
		} catch (Exception e){
			e.printStackTrace();
		}	
	}

	public JButton get_jButtonOK() {
		return _jButtonOK;
	}
	
}


