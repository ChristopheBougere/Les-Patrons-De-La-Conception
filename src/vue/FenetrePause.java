package vue;

import javax.swing.WindowConstants;

import controleur.Superviseur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
 * @author SofianeBoukhebelt
 *
 */
public class FenetrePause extends javax.swing.JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Superviseur _s;
	private JPanel _pannel;
	private JButton _pauseButton;
	private JLabel _statutLabel;
	private JButton _relancerButton;
	
	public FenetrePause(Superviseur s) {
		super();
		_s = s;
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				_pannel = new JPanel();
				getContentPane().add(_pannel, "Center");
				_pannel.setLayout(null);
				_pannel.setPreferredSize(new java.awt.Dimension(267, 134));
				_pannel.setBounds(0, 0, 283, 150);
				{
					_pauseButton = new JButton();
					_pannel.add(_pauseButton);
					_pauseButton.setText("Pause");
					_pauseButton.setBounds(28, 54, 89, 41);
					_pauseButton.addActionListener(this);
				}
				{
					_relancerButton = new JButton();
					_pannel.add(_relancerButton);
					_relancerButton.setText("Relancer");
					_relancerButton.setBounds(158, 54, 89, 41);
					_relancerButton.addActionListener(this);
				}
				{
					_statutLabel = new JLabel();
					_pannel.add(_statutLabel);
					_statutLabel.setText("RUNNING");
					_statutLabel.setBounds(106, 12, 124, 16);
				}
			}
			pack();
			this.setSize(289, 180);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _pauseButton) {
			_s.stopperBornes();
			_statutLabel.setText("PAUSED");
		} else if (e.getSource() == _relancerButton) {
			_s.relancerBornes();
			_statutLabel.setText("RUNNING");
		}
	}

}
