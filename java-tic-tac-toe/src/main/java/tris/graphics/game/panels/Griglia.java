package tris.graphics.game.panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import tris.events.ClickClientButtonEvent;
import tris.events.ClickServerButtonEvent;
import tris.graphics.App;
import tris.graphics.game.Game;
import tris.graphics.home.Home;
import tris.networking.Connection;
import tris.util.Elementi;

public class Griglia extends JPanel implements Runnable {

	private Game game;
	private Home home;
	private App app;
	private Connection connessione;
	private Blocco[] blocco;
	private Punteggio punteggio;
	private boolean attivo;

	public Griglia(Game game, Punteggio punteggio) {
		attivo = true;
		
		this.game = game;
		this.home = game.getHome();
		this.connessione = game.getApp().getConnessione();
		this.app = home.getApp();
		this.punteggio = punteggio;
		
		setSize(Elementi.dimensioneGriglia);
		setBackground(Elementi.background);
		setLayout(new GridLayout(0, 3, 0, 0));
		blocco = new Blocco[9];

		inizializzaButton();
		
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	public void inizializzaButton() {
		for (int i = 0; i < 9; i++) {
			blocco[i] = new Blocco(this, i);
			add(blocco[i]);
		}

		for (int i = 0; i < 9; i++) {
			if (connessione.isBoolServer())
				blocco[i].addActionListener(new ClickServerButtonEvent(this));
			else {
				blocco[i].addActionListener(new ClickClientButtonEvent(this));
			}
		}
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

	public void run() {
		while (attivo) {
			if (!connessione.isBoolServer()) {
				clientIterator();
			} else {
				serverIterator();
			}
		}
	}

	private void pareggio() {
		if (connessione.isBoolServer()) {
			connessione.getServer().getPw().println(14);
		} else {
			connessione.getClient().getPw().println(14);
		}

	}

	private void valuta(String s1, String s2, String s3) {
		if (s1.equals(s2) && s2.equals(s3) && !s1.equals("")) {

			if(connessione.isBoolServer()) {
				if (s1.equals("X")) {
					vittoria();
					reset();
				} else if (s1.equals("O")) {
					sconfitta();
					reset();
				}
			}
			else {
				if (s1.equals("O")) {
					vittoria();
					reset();
				} else if (s1.equals("X")) {
					sconfitta();
					reset();
				}
			}
		}
	}

	private void reset() {
		for (int i = 0; i < 9; i++) {
			blocco[i].setText("");
		}
	}

	private void sconfitta() {
		if (connessione.isBoolServer()) {
			connessione.getServer().getPw().println(12);
		} else {
			connessione.getClient().getPw().println(12);
		}

	}

	private void passa(int n) {
		if (connessione.isBoolServer()) {
			connessione.getServer().getPw().println(n);
		} else {
			connessione.getClient().getPw().println(n);
		}
	}

	private void vittoria() {
		if (connessione.isBoolServer()) {
			connessione.getServer().getPw().println(10);
		} else {
			connessione.getClient().getPw().println(10);
		}

	}

	private void valutazione(int pos) {
		if(connessione.isBoolServer())
			blocco[pos].setText("O");
		else
			blocco[pos].setText("X");
		
		valuta(blocco[0].getText(), blocco[1].getText(), blocco[2].getText());
		valuta(blocco[3].getText(), blocco[4].getText(), blocco[5].getText());
		valuta(blocco[6].getText(), blocco[7].getText(), blocco[8].getText());
		valuta(blocco[0].getText(), blocco[3].getText(), blocco[6].getText());
		valuta(blocco[1].getText(), blocco[4].getText(), blocco[7].getText());
		valuta(blocco[2].getText(), blocco[5].getText(), blocco[8].getText());
		valuta(blocco[0].getText(), blocco[4].getText(), blocco[8].getText());
		valuta(blocco[2].getText(), blocco[4].getText(), blocco[6].getText());

		int i = 0;

		for (Blocco s : blocco) {
			if (!s.getText().equals("")) {
				i++;
			}
		}

		if (i == 9) {
			pareggio();
			reset();
		}
	}
	
	private void loggerPunteggio() {
		System.out.println("Punteggio utente:\t" + punteggio.getIo().getText());
		System.out.println("Punteggio avversario:\t" + punteggio.getLui().getText());
	}
	
	private void resetPartita(int stream) {
		passa(stream);
		reset();
		loggerPunteggio();
	}

	/***
	 * 	14 ---> Pacchetto che indica il pareggio
	 * 	12 ---> Pacchetto che indica lavittoria 
	 * 	10 ---> Pacchetto che indica la sconfitta
	 */
	
	public void condizione(int pos) {
		if (pos >= 0 && pos <= 9) {
			valutazione(pos);
			return;
		}
		
		switch(pos) {
			
			//Caso di vittoria
			case 12:
				punteggio.setIoPoints(punteggio.getIoPoints() + 1);
				punteggio.aggiorna();
				resetPartita(20);
				break;
				
			//Caso di pareggio
			case 14:
				reset();
				break;
				
			//Caso di sconfitta
			case 10:
				punteggio.setLuiPoints(punteggio.getLuiPoints() + 1);
				punteggio.aggiorna();
				resetPartita(22);
				break;
			
			case 22:
				punteggio.setIoPoints(punteggio.getIoPoints() + 1);
				punteggio.aggiorna();
				loggerPunteggio();
				break;
			
			case 24:
				loggerPunteggio();
				reset();
				break;
			
			case 20:
				punteggio.setLuiPoints(punteggio.getLuiPoints() + 1);
				punteggio.aggiorna();
				loggerPunteggio();
				reset();
				break;	
			
		}
	}

	private void visibleHome() {
		home.setVisible(true);
		home.getNickGame().setVisible(true);
		home.getHostGame().setVisible(true);
		home.getJoinGame().setVisible(true);

	}

	private void gestisciException() {

		if (connessione.isBoolServer()) {
			attivo = false;
			setVisible(false);
			try {
				connessione.getServer().getSocket().close();
				connessione.setBoolServer(false);
				game.setVisible(false);
				visibleHome();

			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("[SERVER] L'avversario si è disconesso.");
		}

		else {
			attivo = false;
			setVisible(false);
			try {
				connessione.getClient().getSocket().close();
				game.setVisible(false);
				visibleHome();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("[CLIENT] L'avversario si è disconesso.");
		}

	}

	public void serverIterator() {
		int pos = -1;
		try {
			connessione.getServer().getSocket().setSoTimeout(1000 * 30);
			pos = Integer.parseInt(connessione.getServer().getBr().readLine());
			condizione(pos);
			connessione.getServer().setAzione(true);
		} catch (SocketTimeoutException e) {
			System.out.println("[SERVER] Error : SocketTimeroutException");
			System.out.println("[SERVER] L'avversario ha abbandonato la partita");
			gestisciException();
		} catch (NumberFormatException e) {
			System.out.println("[SERVER] NumberFormatException");
			System.out.println("[SERVER] Errore ricevuto nella stream con il client");
			gestisciException();
		} catch (IOException e) {
			System.out.println("[CLIENT] IoException");
			gestisciException();
		}

	}

	public void clientIterator() {
		int pos = -1;
		try {
			connessione.getClient().getSocket().setSoTimeout(1000 * 30);
			pos = Integer.parseInt(connessione.getClient().getBr().readLine());
			condizione(pos);
			connessione.getClient().setAzione(true);
		} catch (SocketTimeoutException e) {

			System.out.println("[CLIENT] SocketTimeroutException");
			System.out.println("[CLIENT] L'avversario ha abbandonato la partita");
			gestisciException();
		} catch (NumberFormatException e) {
			System.out.println("[CLIENT] NumberFormatException");
			System.out.println("[CLIENT] Errore ricevuto nella stream con il client");
			gestisciException();
		} catch (IOException e) {
			System.out.println("[CLIENT] IoException");
			gestisciException();
		}
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Connection getConnessione() {
		return connessione;
	}

	public void setConnessione(Connection connessione) {
		this.connessione = connessione;
	}

	public Blocco[] getBlocco() {
		return blocco;
	}

	public void setBlocco(Blocco[] blocco) {
		this.blocco = blocco;
	}

	public Punteggio getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Punteggio punteggio) {
		this.punteggio = punteggio;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	
}
