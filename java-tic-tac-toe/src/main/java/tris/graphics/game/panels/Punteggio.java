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

public class Punteggio extends JPanel {
	
	private App app;
	
	private String ioTxt;
	private String luiTxt;
	
	private int ioPoints;
	private int luiPoints;
	
	private LabelPunteggio io;
	private LabelPunteggio lui;

	public Punteggio(App app) {
		this.app = app;
		
		ioPoints = 0;
		luiPoints = 0;
		
		setBackground(new Color(34, 110, 112));
		setBounds(10, 11, 280, 50);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		io = new LabelPunteggio();
		lui = new LabelPunteggio();
				
		if(app.getConnessione().isBoolServer()) {
			server();
		} else {
			client();
		}
		
		add(io);
		add(lui);
	}
	
	//Cambiare punteggio
	private void streamServer() {
		
	mioPunteggio();
		
		try {
			
			app.getConnessione().getServer().getPw().println(io.getText());
			String textLui = app.getConnessione().getServer().getBr().readLine();
			System.out.println("[GAME] Sei contro " + textLui + "!");
			
			luiTxt = textLui;
			lui.setText(textLui);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	
	private void streamClient() {
	
	mioPunteggio();
		
		try {
			String textLui = app.getConnessione().getClient().getBr().readLine();
			app.getConnessione().getClient().getPw().println(io.getText());
			System.out.println("[GAME] Sei contro " + textLui + "!");
			lui.setText(textLui);
			luiTxt = textLui;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void mioPunteggio() {
		io.setText(app.getConnessione().getNickname() + ": " + ioPoints);
		System.out.println(io.getText());
	}

	private void server() {
		streamServer();
	}

	private void client() {
		streamClient();
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
