package tris.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TLabel extends JLabel {
	
	public TLabel(String text) {
		setText(text);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setForeground(Color.white);
	}

}
