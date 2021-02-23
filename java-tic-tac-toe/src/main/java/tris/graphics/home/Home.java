package tris.graphics.home;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.home.panels.host.HostGame;
import tris.graphics.home.panels.join.JoinGame;
import tris.graphics.home.panels.nickname.PanelNickname;
import tris.util.Logo;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home extends JPanel {
	
	private App app;
	private HostGame hostGame;
	private JoinGame joinGame;
	private PanelNickname nickGame;
	private Logo logo;
	private String name;

	public Home(App app) {
		
		this.app = app;
		
		setLayout(null);
		
		setBounds(0, 29, 300, 321);
		setBackground(new Color(34, 110, 112));
		setVisible(true);
		
		hostGame();
		joinGame();
		nickGame();
		logo();
	}

	private void nickGame() {
		nickGame = new PanelNickname();
		nickGame.getTextField().getTextField().setText("Anonimo");
		nickGame.setBounds(0, 166, 300, 38);
		add(nickGame);
	}

	private void logo() {
		logo = new Logo();
		logo.logoMin();
		logo.setBounds(10, 11, 280, 160);
		add(logo);
	}

	private void joinGame() {
		joinGame = new JoinGame(this, app);
		joinGame.setBounds(0, 261, 300, 60);
		add(joinGame);
	}

	private void hostGame() {
		hostGame = new HostGame(this, app);
		hostGame.setBounds(0, 202, 300, 60);
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
	
	
}
