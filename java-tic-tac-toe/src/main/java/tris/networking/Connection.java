package tris.networking;

import tris.networking.client.JClient;
import tris.networking.server.JServer;

public class Connection {

	private JServer server;
	private JClient client;
	private String nickname;
	
	public Connection(JServer server, JClient client, String nickname) {
		super();
		this.server = server;
		this.client = client;
	}
	
	public Connection() {
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
	
}
