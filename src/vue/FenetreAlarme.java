
/*
 * Ghita & Baraa 
 * */
 
package vue;

import java.awt.BorderLayout;
import javax.swing.*;

public class FenetreAlarme extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel _label;
	private JPanel _panel;
	private String _message;
	
	public FenetreAlarme(String message){
		super();
		initGUI();
		_message=message;
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	private void initGUI() {
		try{
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			_label = new JLabel();
			_panel.add(_label);
			_label.setText("Alarme : "+ _message);
			_label.setBounds(17, 197, 99, 22);
			_label.setFont(new java.awt.Font("Khmer OS",1,12));


			getContentPane().add(_panel,BorderLayout.WEST);
			_panel.setPreferredSize(new java.awt.Dimension(310, 270));

			pack();
			this.setSize(500,300);
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	
}


