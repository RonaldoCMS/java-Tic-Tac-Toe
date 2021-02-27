package tris.graphics.game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.game.panels.Griglia;
import tris.graphics.game.panels.Punteggio;
import tris.graphics.home.Home;
import tris.util.Elementi;

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
		setBackground(Elementi.background);

		punteggio = new Punteggio(this);
		punteggio.setBounds(10, 11, 280, 50);
		add(punteggio);

		griglia = new Griglia(this, punteggio);
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

	public Griglia getGriglia() {
		return griglia;
	}

	public void setGriglia(Griglia panel_1) {
		this.griglia = panel_1;
	}

	public Punteggio getPanel() {
		return punteggio;
	}

	public void setPanel(Punteggio panel) {
		this.punteggio = panel;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Punteggio getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Punteggio punteggio) {
		this.punteggio = punteggio;
	}

}
