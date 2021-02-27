package tris.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextFieldTris extends JPanel {

	private JTextField textField;
	private JSeparator separatore;
	
	public TextFieldTris() {
		
		setBackground(new Color(34, 110, 112));
		
		textField = new JTextField();
		textField.setDoubleBuffered(true);
		textField.setBounds(10, 0, 190, 38);
		textField.setVisible(true);
		setLayout(null);
		textField.setBorder(null);
		textField.setAutoscrolls(false);
		textField.setInheritsPopupMenu(true);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setForeground(Color.WHITE);
		textField.setOpaque(false);
		add(textField);
		
		separatore = new JSeparator();
		separatore.setBounds(0, 29, 200, 9);
		separatore.setForeground(Color.BLACK);
		add(separatore);
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JSeparator getSeparatore() {
		return separatore;
	}

	public void setSeparatore(JSeparator separatore) {
		this.separatore = separatore;
	}
	
	
	
}
