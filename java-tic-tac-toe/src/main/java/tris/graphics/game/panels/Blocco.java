package tris.graphics.game.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import tris.networking.Connection;

public class Blocco extends JButton{

	private Connection connessione;
	private int posizione;
	
	public Blocco(final Connection connessione, int posizione) {
		this.connessione = connessione;
		this.posizione = posizione;
		
		setFont(new Font("Monospaced", Font.PLAIN, 18));
		setForeground(Color.WHITE);
		setBorder(null);
		
		setBackground(Color.DARK_GRAY);
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
