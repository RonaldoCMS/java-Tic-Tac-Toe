package tris.graphics.game.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import tris.graphics.App;

public class Punteggio extends JPanel {
	
	private App app;
	
	private LabelPunteggio io;
	private LabelPunteggio lui;

	public Punteggio(App app, int server) {
		this.app = app;
		setBackground(new Color(34, 110, 112));
		setBounds(10, 11, 280, 50);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		io = new LabelPunteggio();
		io.setText(app.getConnessione().getNickname() + ": " + 0);
		System.out.println(io.getText());
		lui = new LabelPunteggio();
		
		if(server == 0) {
			addingServer();
		} else if(server == 1) {
			addingClient();
		}
		
		add(io);
		add(lui);
	}

	private void addingServer() {
		try {
			app.getConnessione().getServer().getPw().println(io.getText());
			String textLui = app.getConnessione().getServer().getBr().readLine();
			System.out.println("[GAME] Sei contro" + textLui + "!");
			lui.setText(textLui);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void addingClient() {
		try {
			String textLui = app.getConnessione().getClient().getBr().readLine();
			app.getConnessione().getClient().getPw().println(io.getText());
			System.out.println("[GAME] Sei contro " + textLui + "!");
			lui.setText(textLui);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
