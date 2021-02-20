package tris.panels.networking.join;

import java.awt.Color;

import javax.swing.JPanel;

import tris.panels.App;
import java.awt.BorderLayout;

public class JoinPanel extends JPanel {
	
	private PanelJoinIP ip;
	private PanelJoinPort port;
	
	public JoinPanel(App app) {
		
		port = new PanelJoinPort();
		port.setBounds(0, 71, 300, 57);
		port.setVisible(true);
		setLayout(null);
		this.add(port);
		port.setLayout(null);
		
		ip = new PanelJoinIP();
		ip.setBounds(0, 129, 300, 45);
		this.add(ip);
		ip.setVisible(true);
		ip.setLayout(null);
		
		setBounds(0, 29, 300, 321);
		setBackground(Color.BLUE);
		
	}

}
