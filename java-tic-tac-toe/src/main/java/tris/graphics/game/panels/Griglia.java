package tris.graphics.game.panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class Griglia extends JPanel {

	private Blocco[] blocco;
	
	public Griglia() {
		setSize( 280, 238);
		setBackground(new Color(34, 110, 112));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		blocco = new Blocco[9];
		
		for(int i=0; i<9; i++) {
			blocco[i] = new Blocco();
			add(blocco[i]);
		}
	}

	@Override
    public void paint(Graphics g) {
        super.paint(g);
        dividiTris(g, 0, 80, 280, 3, Color.white);
        dividiTris(g, 0, 155, 280, 3, Color.white);
        dividiTris(g, 90, 0, 3, 250, Color.white);
        dividiTris(g, 185, 0, 3, 250, Color.white);
        g.dispose();
    }

    private void dividiTris(Graphics g, int x, int y, int width, int height, Color c) {
        g.setColor(c);
        g.fillRect(x, y, width, height);

    }
	
}
