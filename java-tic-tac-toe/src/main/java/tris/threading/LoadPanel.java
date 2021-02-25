package tris.threading;

import java.awt.Color;
import java.awt.Font;

import javax.management.timer.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.game.Game;
import tris.graphics.home.Home;
import tris.networking.client.GameClient;
import tris.networking.client.JClient;
import tris.networking.server.GameServer;
import tris.networking.server.JServer;
import tris.util.LabelTris;
import tris.util.TLabel;

public class LoadPanel extends JPanel {
	
	private Home home;
	private App app;
	
	private Game game;
	
	//Accorciare il codice
	private JServer server;
	private JClient client;
	
	private JLabel nickname;
	private JLabel text;
	private String textLabel;
	
	private boolean stop;
	private boolean serverOpen;
	private boolean clientOpen;
	
	/**
	 * @wbp.parser.constructor
	 */
	public LoadPanel(Home home) {
		this.home = home;
		this.app = home.getApp();
		property(app);
		this.server = app.getConnessione().getServer();
		this.client = app.getConnessione().getClient();
		serverOpen = false;
		clientOpen = false;
	}
	
	public void gameProperty() {
		game = new Game(home);
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
	}

	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void avviaServer() {
		Thread thread = new Thread(new GameServer(this));
		serverOpen = true;
		thread.start();
		server.avvia();	
		
	}
	
	public void avviaClient() {
		Thread thread = new Thread(new GameClient(this));	
		clientOpen = true;
		thread.start();	
		client.avvia();	
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

	public JServer getServer() {
		return server;
	}

	public void setServer(JServer server) {
		this.server = server;
	}

	public JClient getClient() {
		return client;
	}

	public void setClient(JClient client) {
		this.client = client;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public String getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(String textLabel) {
		this.textLabel = textLabel;
	}


	public boolean isServerOpen() {
		return serverOpen;
	}

	public void setServerOpen(boolean serverOpen) {
		this.serverOpen = serverOpen;
	}

	public boolean isClientOpen() {
		return clientOpen;
	}

	public void setClientOpen(boolean clientOpen) {
		this.clientOpen = clientOpen;
	}
	
	private boolean serverInterrupted() {
		return server.isInterrupted();
	}
	
	private boolean clientInterrupted() {
		return client.isInterrupted();
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	
	
}
