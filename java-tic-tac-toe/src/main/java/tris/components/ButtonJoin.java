package tris.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class ButtonJoin extends JButton {

	public ButtonJoin(String text) {
		setText(text);
		setForeground(Color.WHITE);
		setFont(new Font("Tahoma", Font.PLAIN, 19));
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentAreaFilled(false);
		setFocusable(false);
		setBounds(154, 114, 129, 35);
	}
	
}
