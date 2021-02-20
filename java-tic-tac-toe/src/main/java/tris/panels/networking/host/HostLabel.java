package tris.panels.networking.host;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class HostLabel extends JLabel {
	
	public HostLabel() {
		setText("Caricamento in corso...");
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setForeground(Color.white);
	}

}
