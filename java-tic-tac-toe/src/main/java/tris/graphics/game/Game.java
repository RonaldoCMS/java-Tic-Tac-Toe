package tris.graphics.game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.game.panels.Griglia;
import tris.graphics.game.panels.Punteggio;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Game extends JPanel {
	
	private App app;
	Griglia panel_1;
	Punteggio panel ;
	
	public Game(App app, int server) {
		this.app = app;
		
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(34, 110, 112));
		
		if(server == 0) {
			panel = new Punteggio(app, 0);
			
		}
		else if(server == 1) {
			panel = new Punteggio(app, 1);
		}
		panel.setBounds(10, 11, 280, 50);
		add(panel);
		
		
		panel_1 = new Griglia();
		panel_1.setBounds(10, 72, 280, 238);
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
	}
}
