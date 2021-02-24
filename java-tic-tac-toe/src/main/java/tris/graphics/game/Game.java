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
	private Griglia panel_1;
	private Punteggio panel ;
	
	public Game(App app) {
		this.app = app;
		
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(34, 110, 112));
		
		panel = new Punteggio(app);
		panel.setBounds(10, 11, 280, 50);
		add(panel);
		
		
		panel_1 = new Griglia(app.getConnessione());
		panel_1.setBounds(10, 72, 280, 238);
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Griglia getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(Griglia panel_1) {
		this.panel_1 = panel_1;
	}

	public Punteggio getPanel() {
		return panel;
	}

	public void setPanel(Punteggio panel) {
		this.panel = panel;
	}
	
	
}
