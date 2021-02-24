package tris.threading;

import tris.graphics.game.Game;
import tris.networking.client.JClient;
import tris.networking.server.JServer;

public class GameThread implements Runnable {

	private Game game;
	private JServer server;
	private JClient client;
	
	public GameThread(Game game) {
		this.game = game;
		this.server = game.getApp().getConnessione().getServer();
		this.client = game.getApp().getConnessione().getClient();
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		
	}
	
}
