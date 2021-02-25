package tris.graphics.home.panels.host.panels;
/***
 * 
 * CLASSE OBSOLETA
 * 
 */
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.home.Home;
import tris.networking.Connection;
import tris.networking.server.JServer;
import tris.threading.LoadPanel;
import tris.util.Logo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HostPanel extends JPanel {
	
	private Home home;
	private LoadPanel panel;
	private App app;

	public HostPanel(Home home) {
		this.home = home;
		this.app = home.getApp();
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setBackground(new Color(34, 100, 112));
		
		panelProperty();
	}

	private void panelProperty() {
		panel = new LoadPanel(home);
		panel.avviaServer();
		panel.setBounds(0, 244, 300, 40);
		add(panel);
		
		Logo logo = new Logo();
		logo.logoMax();
		logo.setBounds(10, 11, 280, 222);
		add(logo);
	}

	

	public JServer getServer() {
		return app.getConnessione().getServer();
	}

	/*public void setServer(JServer server) {
		this.server = server;
	}*/
	
}
