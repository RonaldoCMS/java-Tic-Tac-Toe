package tris.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class ButtonTris extends JButton {

	public ButtonTris(String text) {
		setText(text);
		setForeground(Color.WHITE);
		setFont(new Font("Monospaced", Font.PLAIN, 20));
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentAreaFilled(false);
		setFocusable(false);
		setBounds(154, 114, 129, 35);
	}
	
}
