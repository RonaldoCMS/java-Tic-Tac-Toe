package tris.graphics.game.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import tris.graphics.App;
import tris.graphics.game.Game;
import tris.util.Elementi;

public class Punteggio extends JPanel {

	private App app;

	private String ioTxt;
	private String luiTxt;

	private int ioPoints;
	private int luiPoints;

	private LabelPunteggio io;
	private LabelPunteggio lui;

	public Punteggio(Game game) {
		this.app = game.getApp();

		ioPoints = 0;
		luiPoints = 0;

		setBackground(Elementi.background);
		setBounds(10, 11, 280, 50);
		setLayout(new GridLayout(0, 1, 0, 0));

		io = new LabelPunteggio();
		lui = new LabelPunteggio();

		aggiorna();

		add(io);
		add(lui);
	}

	public void aggiorna() {
		if(app.getConnessione().isBoolServer()) {
			io.setText("[X] " + app.getConnessione().getNickname() + " : " + ioPoints);
			lui.setText("[O] " + app.getConnessione().getEnemy() + " : " + luiPoints);
		}
		else {
			io.setText("[O] " + app.getConnessione().getNickname() + " : " + ioPoints);
			lui.setText("[X] " + app.getConnessione().getEnemy() + " : " + luiPoints);
		}
		
	}

	public String getIoTxt() {
		return ioTxt;
	}

	public void setIoTxt(String ioTxt) {
		this.ioTxt = ioTxt;
	}

	public String getLuiTxt() {
		return luiTxt;
	}

	public void setLuiTxt(String luiTxt) {
		this.luiTxt = luiTxt;
	}

	public int getIoPoints() {
		return ioPoints;
	}

	public void setIoPoints(int ioPoints) {
		this.ioPoints = ioPoints;
	}

	public int getLuiPoints() {
		return luiPoints;
	}

	public void setLuiPoints(int luiPoints) {
		this.luiPoints = luiPoints;
	}

	public LabelPunteggio getIo() {
		return io;
	}

	public void setIo(LabelPunteggio io) {
		this.io = io;
	}

	public LabelPunteggio getLui() {
		return lui;
	}

	public void setLui(LabelPunteggio lui) {
		this.lui = lui;
	}

}
