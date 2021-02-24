package tris.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.threading.LoadPanel;

public class PlayEvent implements MouseListener{

	private boolean server;
	private JPanel panel;
	private String nickname;
	private App app;
	
	public PlayEvent(App app, JPanel panel, boolean server) {
		this.app = app;
		this.panel = panel;
		this.server = server;
	}


	public void mouseClicked(MouseEvent e) {
		this.nickname = this.app.getSelectBox().getNickGame().getTextField().getTextField().getText();
		
		app.getConnessione().setNickname(nickname);
		System.out.println("[APP] Sei loggato con " + nickname);
		
		loadPanel();
		app.getSelectBox().setVisible(false);
		panel.setVisible(false);
		
	}
	
	private void loadPanel() {
		LoadPanel load = new LoadPanel(app);
		
		if(server)
			load.avviaServer();
		else
			load.avviaClient();
		
		load.setBounds(0, 244, 300, 40);
		app.add(load);
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
