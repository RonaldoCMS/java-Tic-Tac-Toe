package tris.graphics.home.panels.join.panels;

import java.awt.Color;

import javax.swing.JPanel;

import tris.util.Elementi;
import tris.util.LabelTris;
import tris.util.TextFieldTris;

public class PanelJoinIP extends JPanel {

	private LabelTris text;
	private TextFieldTris textField;
	
	public PanelJoinIP() {
		setLayout(null);
		
		text = new LabelTris("INDIRIZZO");
		text.setBounds(0, 0, 139, 30);
		add(text);
		
		textField = new TextFieldTris();
		textField.setBounds(146, 0, 154, 30);
		text.setBounds(0, 0, 300, 30);
		add(textField);
		
		setBackground(Elementi.background);
		setSize(300, 30);
		
		textField.setVisible(true);
		setVisible(true);
	}

	public LabelTris getText() {
		return text;
	}

	public void setText(LabelTris text) {
		this.text = text;
	}

	public TextFieldTris getTextField() {
		return textField;
	}

	public void setTextField(TextFieldTris textField) {
		this.textField = textField;
	}
	
	
	
}
