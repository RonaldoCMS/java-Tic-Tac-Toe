package tris.util;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class LabelTris extends JLabel {
	
	public LabelTris(String text) {
		setText(text);
		setForeground(Color.WHITE);
		setFont(new Font("Monospaced", Font.PLAIN, 21));
		setVisible(true);
	}

}
