package tris.util;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Logo extends JLabel {

	public Logo() {
		setText("");
		setVisible(true);
	}
	
	public void logoMax() {
		setIcon(new ImageIcon(".\\images\\bg1.png"));
	}
	
	public void logoMin() {
		setIcon(new ImageIcon(".\\images\\bg2.png"));
	}
	
}
