package tris.graphics.game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.game.panels.Griglia;
import tris.graphics.game.panels.Punteggio;
import tris.graphics.home.Home;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Game extends JPanel {
	
	private Home home;
	private App app;
	private Griglia griglia;
	private Punteggio punteggio;
	
	public Game(Home home) {
		this.home = home;
		this.app = home.getApp();
		
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(34, 110, 112));
		
		punteggio = new Punteggio(app);
		punteggio.setBounds(10, 11, 280, 50);
		add(punteggio);
		
		
		griglia = new Griglia(home, punteggio, app.getConnessione());
		griglia.setBounds(10, 72, 280, 238);
		add(griglia);
		griglia.setLayout(new GridLayout(0, 3, 0, 0));
		
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Griglia getPanel_1() {
		return griglia;
	}

	public void setPanel_1(Griglia panel_1) {
		this.griglia = panel_1;
	}

	public Punteggio getPanel() {
		return punteggio;
	}

	public void setPanel(Punteggio panel) {
		this.punteggio = panel;
	}
	
	
}
