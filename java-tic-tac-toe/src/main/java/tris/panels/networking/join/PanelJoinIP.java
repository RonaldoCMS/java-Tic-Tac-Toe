package tris.panels.networking.join;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class PanelJoinIP extends JPanel {

	private JoinLabel text;
	private JoinTextField textField;
	
	public PanelJoinIP() {
		setLayout(null);
		
		text = new JoinLabel("INDIRIZZO");
		text.setBounds(0, 0, 139, 30);
		add(text);
		
		textField = new JoinTextField();
		textField.setBounds(146, 0, 154, 30);
		text.setBounds(0, 0, 300, 30);
		add(textField);
		
		setVisible(true);
		setBackground(Color.red);
		setSize(300, 30);
	}
	
}
