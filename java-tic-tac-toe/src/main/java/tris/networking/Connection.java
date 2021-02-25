package tris.networking;

import tris.networking.client.JClient;
import tris.networking.server.JServer;

public class Connection {

	private boolean boolServer;
	private JServer server;
	private JClient client;
	private String nickname;
	private String enemy;
	
	public Connection(JServer server, JClient client, String nickname) {
		super();
		boolServer = false;
		this.server = server;
		this.client = client;
	}
	
	public Connection() {
		boolServer = false;
		server = new JServer();
		client = new JClient();
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isBoolServer() {
		return boolServer;
	}

	public void setBoolServer(boolean boolServer) {
		this.boolServer = boolServer;
	}

	public String getEnemy() {
		return enemy;
	}

	public void setEnemy(String enemy) {
		this.enemy = enemy;
	}
	
	
	
}
