package tris.threading;

import java.awt.Color;
import java.awt.Font;

import javax.management.timer.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.game.Game;
import tris.networking.client.JClient;
import tris.networking.server.JServer;
import tris.util.LabelTris;
import tris.util.TLabel;

public class LoadPanel extends JPanel implements Runnable {
	
	private App app;
	
	//Accorciare il codice
	private JServer server;
	private JClient client;
	
	private JLabel nickname;
	private JLabel text;
	private String textLabel;
	
	private Game game;
	
	private boolean stop;
	private boolean serverOpen;
	private boolean clientOpen;
	
	/**
	 * @wbp.parser.constructor
	 */
	public LoadPanel(App app) {
		property(app);
		this.server = app.getConnessione().getServer();
		this.client = app.getConnessione().getClient();
		serverOpen = false;
		clientOpen = false;
	}
	
	public void gameProperty(int n) {
		game = new Game(app, n);
		game.setVisible(false);
		app.add(game);
		game.setBounds(0, 29, 300, 321);
	}
	
	private void property(App app) {
		this.app = app;
		textLabel = "Caricamento in corso";
		text = new LabelTris(textLabel);
		this.setBackground(new Color(34, 110, 112));
		setSize(300, 40);
		add(text);
		threadProperty();
	}

	private void threadProperty() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void avviaServer() {
		serverOpen = true;
		server.avvia();
		threadProperty();
		
	}
	
	public void avviaClient() {
		clientOpen = true;
		client.avvia();
		threadProperty();
		
	}
	
	private boolean serverInterrupted() {
		return server.isInterrupted();
	}
	
	private boolean clientInterrupted() {
		return client.isInterrupted();
	}
	
	private void running() {
		if(serverOpen) {
			whileServer();
			serverOpen=false;
		}
		else if(clientOpen) {
			whileClient();
			clientOpen=false;
		}
	}
	
	private void loading(int i, String txt) {
		sleeping(1);
		getText().setText(txt);
		for(int j = 0; j < 3; j++) {
			sleeping(1);
			getText().setText(getText().getText().concat("."));
		}
		if(i >= 3) {
			i = 0;
		}
		i++;
	}	

	private void whileClient() {
		String txt = getText().getText();
		int i = 0;
		sleeping(1);
		
		while(!client.isInterrupted()) {
			loading(i, txt);
			if(client.isAccept()) {
				setVisible(false);
				gameProperty(1);
				game.setVisible(true);
				System.out.println("[JCLIENT] connesso!");
				return;
			}
			
		}
		
		
		getText().setText("Tempo Scaduto.");
		System.out.println("[JCLIENT]\t Nessuno si è connesso al server");
		sleeping(3);
		app.getSelectBox().setVisible(true);
		this.setVisible(false);
		System.out.println("[JCLIENT] Caricamento terminato");
		
	}


	private void whileServer() {
		String txt = getText().getText();
		int i = 0;
		sleeping(1);
		
		while(!server.isInterrupted()) {
			loading(i, txt);
			if(server.isAccept()) {
				setVisible(false);
				gameProperty(0);
				game.setVisible(true);
				System.out.println("[JSERVER] connesso!");
				return;
			}
		}
		getText().setText("Tempo Scaduto.");
		System.out.println("[JSERVER]\t Non ho trovato nessun client disponibile");
		sleeping(3);
		app.getSelectBox().setVisible(true);
		this.setVisible(false);
		System.out.println("[JSERVER] Caricamento terminato");
	}

	public void run() {
		running();
	}
	
	public void sleeping(int delay) {
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public JLabel getText() {
		return text;
	}

	public void setText(JLabel text) {
		this.text = text;
	}

	public JLabel getNickname() {
		return nickname;
	}

	public void setNickname(JLabel nickname) {
		this.nickname = nickname;
	}
	
	
	
	
	
}
