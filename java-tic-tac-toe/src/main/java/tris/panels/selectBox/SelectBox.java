package tris.panels.selectBox;

import javax.swing.JPanel;

import tris.panels.App;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class SelectBox extends JPanel {
	
	private JPanel hostGame;
	private JPanel joinGame;

	public SelectBox(App app) {
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setBackground(new Color(34, 110, 112));
		
		hostGame = new HostGame(this, app);
		hostGame.setBounds(0, 202, 300, 60);
		add(hostGame);
		
		joinGame = new JoinGame(this, app);
		joinGame.setBounds(0, 261, 300, 60);
		add(joinGame);
		setVisible(true);
		
	}
}
