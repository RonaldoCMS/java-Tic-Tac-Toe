package tris.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import tris.graphics.App;
import tris.graphics.game.panels.Blocco;
import tris.networking.Connection;

public class ClickClientButtonEvent implements ActionListener {

	private App app;
	private Connection connessione;
	private Blocco[] blocchi;
	private Blocco blocco;
	private Thread thread;
	
	public ClickClientButtonEvent(App app, Blocco[] blocchi) {
		this.app = app;
		this.connessione = app.getConnessione();
		this.blocchi = blocchi;
	}
	
	public ClickClientButtonEvent(App app, Blocco[] blocchi, boolean first) {
		this.app = app;
		this.connessione = app.getConnessione();
		this.blocchi = blocchi;
	}
	
	public void actionPerformed(ActionEvent e) {
		blocco = (Blocco) e.getSource();
		if(connessione.getClient().isAzione()) {
			occupato();
		}
	}
	
	private void occupato() {
		if(blocco.getText().equals("")) {
			connessione.getClient().setAzione(false);
			blocco.setText(connessione.getNickname());
			connessione.getClient().getPw().println(blocco.getPosizione());
		}
	}
}
