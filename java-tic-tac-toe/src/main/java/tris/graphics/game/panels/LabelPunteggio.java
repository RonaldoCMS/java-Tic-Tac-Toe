package tris.graphics.game.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelPunteggio extends JLabel {

	public LabelPunteggio() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		setFont(new Font("Tahoma", Font.PLAIN, 17));
	}
	
}
