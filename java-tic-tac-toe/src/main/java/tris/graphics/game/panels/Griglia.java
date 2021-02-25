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
import tris.graphics.home.Home;
import tris.networking.Connection;

public class Griglia extends JPanel implements Runnable {

	private Home home;
	private App app;
	private Connection connessione;
	private Blocco[] blocco;
	private Punteggio punteggio;
	private boolean attivo;

	public Griglia(Home home, Punteggio punteggio, Connection connessione) {
		attivo = true;
		this.home = home;
		this.app = home.getApp();
		this.punteggio = punteggio;
		this.connessione = app.getConnessione();
		setSize(280, 238);
		setBackground(new Color(34, 110, 112));
		setLayout(new GridLayout(0, 3, 0, 0));
		blocco = new Blocco[9];

		for (int i = 0; i < 9; i++) {
			blocco[i] = new Blocco(connessione, i);
			add(blocco[i]);
		}

		for (int i = 0; i < 9; i++) {
			if (connessione.isBoolServer())
				blocco[i].addActionListener(new ClickServerButtonEvent(app, blocco));
			else {
				blocco[i].addActionListener(new ClickClientButtonEvent(app, blocco));
			}
		}
		// System.out.println("Indirizzo Array di Blocchi:\t" + blocco.hashCode());

		Thread t1 = new Thread(this);
		t1.start();
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

			if (s1.equals(connessione.getNickname())) {
				vittoria();
				reset();
			} else if (s1.equals(connessione.getEnemy())) {
				sconfitta();
				reset();
			}
		}
	}

	private void reset() {
		for (int i = 0; i < 9; i++) {
			blocco[i].setText("");
		}
	}

	/***
	 * 14 ---> Pacchetto che indica il pareggio
	 * 12 ---> Pacchetto che indica la vittoria
	 * 10 ---> Pacchetto che indica la sconfitta
	 */

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
		blocco[pos].setText(connessione.getEnemy());
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
	
	public void condizione(int pos) {
		System.out.println(pos);
		if (pos == 12) {
			System.out.println("Vittoria");
			
			punteggio.setIoPoints(punteggio.getIoPoints() + 1);
			punteggio.aggiorna();
			

			passa(20);
			System.out.println(punteggio.getIo().getText());
			System.out.println(punteggio.getLui().getText());
			reset();
		}

		else if (pos == 14) {
			System.out.println("Pareggio");
			reset();
		}

		else if (pos == 10) {
			System.out.println("Sconfitta");

			punteggio.setLuiPoints(punteggio.getLuiPoints() + 1);
			punteggio.aggiorna();
			
			passa(22);
			System.out.println(punteggio.getIo().getText());
			System.out.println(punteggio.getLui().getText());
			reset();
		}
		else if (pos == 22) {
			System.out.println("Vittoria");
			
			punteggio.setIoPoints(punteggio.getIoPoints() + 1);
			punteggio.aggiorna();
			
			System.out.println(punteggio.getIo().getText());
			System.out.println(punteggio.getLui().getText());
			reset();
		}

		else if (pos == 24) {
			System.out.println("Pareggio");
			reset();
		}

		else if (pos == 20) {
			System.out.println("Sconfitta");
			punteggio.setLuiPoints(punteggio.getLuiPoints() + 1);
			punteggio.aggiorna();


			System.out.println(punteggio.getIo().getText());
			System.out.println(punteggio.getLui().getText());
			reset();
		}

		if (pos >= 0 && pos <= 9) {
			valutazione(pos);
		}
	}
	
	private void gestisciException() {
		
		if(connessione.isBoolServer()) {
			attivo = false;
			setVisible(false);
			try {
				connessione.getServer().getSocket().close();
				app.getSelectBox().setVisible(true);
				home.getHostGame().setVisible(true);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("[SERVER] L'avversario si � disconesso.");
		}
		else {
			attivo = false;
			setVisible(false);
			try {
				connessione.getClient().getSocket().close();
				app.getSelectBox().setVisible(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("[CLIENT] L'avversario si � disconesso.");
		}
		
	}

	public void serverIterator() {
		int pos = -1;
			try {
				connessione.getServer().getSocket().setSoTimeout(1000 * 30);
				pos = Integer.parseInt(connessione.getServer().getBr().readLine());
				condizione(pos);
				connessione.getServer().setAzione(true);
			} 
			catch (SocketTimeoutException e) {
				System.out.println("[SERVER] SocketTimeroutException");
				gestisciException();
			} 
			catch (NumberFormatException e) {
				System.out.println("[SERVER] NumberFormatException");
				gestisciException();
			} 
			catch (IOException e) {
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
		}
		catch (SocketTimeoutException e) {

			System.out.println("[CLIENT] SocketTimeroutException");
			gestisciException();
		} 
		catch (NumberFormatException e) {
			System.out.println("[CLIENT] NumberFormatException");
			gestisciException();
		} 
		catch (IOException e) {
			System.out.println("[CLIENT] IoException");
			gestisciException();
		}
	}

}
