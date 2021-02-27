package tris.graphics.game.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import tris.networking.Connection;
import tris.util.Elementi;

public class Blocco extends JButton{

	private Griglia griglia;
	private Connection connessione;
	private int posizione;
	
	public Blocco(Griglia griglia, int posizione) {
		this.griglia = griglia;
		this.connessione = griglia.getConnessione();
		this.posizione = posizione;
		
		property();
	}

	private void property() {
		setFont(new Font("Monospaced", Font.PLAIN, 60));
		setForeground(Color.WHITE);
		setBorder(null);
		
		setBackground(Elementi.background);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setHorizontalTextPosition(SwingConstants.CENTER);
	}

	public Connection getConnessione() {
		return connessione;
	}

	public void setConnessione(Connection connessione) {
		this.connessione = connessione;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}
	
	
	
}
