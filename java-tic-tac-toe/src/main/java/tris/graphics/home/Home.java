package tris.graphics.home;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.home.panels.host.HostGame;
import tris.graphics.home.panels.join.JoinGame;
import tris.graphics.home.panels.nickname.PanelNickname;
import tris.util.Elementi;
import tris.util.LabelTris;
import tris.util.Logo;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingConstants;

public class Home extends JPanel {
	
	private App app;
	
	private HostGame hostGame;
	private JoinGame joinGame;
	private PanelNickname nickGame;
	private LabelTris crediti;
	
	private Logo logo;
	
	private String name;

	public Home(App app) {
		this.app = app;
		homeProperty();
	}
	
	public void homeProperty() {
		setLayout(null);
		
		setBounds(0, 29, 300, 321);
		setBackground(Elementi.background);
		setVisible(true);
		
		hostGame();
		joinGame();
		nickGame();
		logo();
		creditiProperty();
	}

	private void creditiProperty() {
		crediti = new LabelTris("Copyright © - Fabio Danubbio - 2021");
		crediti.setHorizontalAlignment(SwingConstants.CENTER);
		crediti.setFont(new Font("Monospaced", Font.PLAIN, 12));
		crediti.setBounds(0, 300, 300, 21);
		crediti.setVisible(true);
		add(crediti);
		
	}

	private void nickGame() {
		nickGame = new PanelNickname();
		nickGame.getTextField().getTextField().setText("Fabio");
		nickGame.setBounds(0, 149, 300, 38);
		add(nickGame);
	}

	private void logo() {
		logo = new Logo();
		logo.logoMin();
		logo.setBounds(10, 11, 280, 142);
		add(logo);
	}

	private void joinGame() {
		joinGame = new JoinGame(this, app);
		joinGame.setBounds(0, 239, 300, 60);
		add(joinGame);
	}

	private void hostGame() {
		hostGame = new HostGame(this, app);
		hostGame.setBounds(0, 187, 300, 60);
		add(hostGame);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PanelNickname getNickGame() {
		return nickGame;
	}

	public void setNickGame(PanelNickname nickGame) {
		this.nickGame = nickGame;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public HostGame getHostGame() {
		return hostGame;
	}

	public void setHostGame(HostGame hostGame) {
		this.hostGame = hostGame;
	}

	public JoinGame getJoinGame() {
		return joinGame;
	}

	public void setJoinGame(JoinGame joinGame) {
		this.joinGame = joinGame;
	}

	public Logo getLogo() {
		return logo;
	}

	public void setLogo(Logo logo) {
		this.logo = logo;
	}
	
	
	
}
