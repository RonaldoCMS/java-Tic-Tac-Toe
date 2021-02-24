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

import tris.events.ClickButtonEvent;
import tris.networking.Connection;

public class Griglia extends JPanel {

	private Connection connessione;
	private Blocco[] blocco;
	
	public Griglia(Connection connessione) {
		
		setSize( 280, 238);
		setBackground(new Color(34, 110, 112));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		blocco = new Blocco[9];
		
		for(int i=0; i<9; i++) {
			blocco[i] = new Blocco(connessione, i);
			add(blocco[i]);
		}
		
		for(int i=0; i<9;i++) {
			if(connessione.isBoolServer())
				blocco[i].addActionListener(new ClickButtonEvent(connessione.getServer(), blocco));
			else
				blocco[i].addActionListener(new ClickButtonEvent(connessione.getClient(), blocco));
		}
		//System.out.println("Indirizzo Array di Blocchi:\t" + blocco.hashCode());
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
