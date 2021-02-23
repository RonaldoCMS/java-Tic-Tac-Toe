package tris.graphics.game.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Blocco extends JButton{

	public Blocco() {
		setFont(new Font("Monospaced", Font.PLAIN, 13));
		setForeground(Color.WHITE);
		setBorder(null);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setText("TesTest");
			}
		});
		setBackground(Color.DARK_GRAY);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setHorizontalTextPosition(SwingConstants.CENTER);
	}
	
}
