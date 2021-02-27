package tris.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.w3c.dom.events.MouseEvent;

import tris.graphics.App;
import tris.graphics.game.panels.Blocco;
import tris.graphics.game.panels.Griglia;
import tris.networking.Connection;
import tris.networking.client.JClient;
import tris.networking.server.JServer;

public class ClickServerButtonEvent implements ActionListener {

	private App app;
	private Connection connessione;
	private Blocco[] blocchi;
	private Blocco blocco;
	
	public ClickServerButtonEvent(Griglia griglia) {
		this.app = griglia.getApp();
		this.connessione = app.getConnessione();
		this.blocchi = griglia.getBlocco();
	}

	public void actionPerformed(ActionEvent e) {
		blocco = (Blocco) e.getSource();
		if(connessione.getServer().isAzione()) {
			occupato();
		}
	}
	

	private void occupato() {
		if(blocco.getText().equals("")) {
			connessione.getServer().setAzione(false);
			blocco.setText(connessione.getNickname());
			blocco.setText("X");
			connessione.getServer().getPw().println(blocco.getPosizione());
		}
	}
	
	
}
