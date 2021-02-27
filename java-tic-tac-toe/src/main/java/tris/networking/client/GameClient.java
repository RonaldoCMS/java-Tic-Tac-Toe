package tris.networking.client;

import java.io.IOException;

import tris.graphics.game.Game;
import tris.threading.LoadPanel;

public class GameClient implements Runnable {

	public LoadPanel panel;
	
	public GameClient(LoadPanel panel) {
		this.panel = panel;
	}
	
	public void run() {
		String txt = panel.getText().getText();
		int i = 0;
		sleeping(1);
		
		while(!panel.getClient().isInterrupted()) {
			loading(i, txt);
			if(panel.getClient().isAccept()) {
				panel.setVisible(false);

				System.out.println("[JCLIENT] connesso!");
				
				try {
					String enemy = panel.getClient().getBr().readLine();
					panel.getApp().getConnessione().setEnemy(enemy);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				panel.getClient().getPw().println(panel.getApp().getConnessione().getNickname());
				
				panel.gameProperty();
				panel.getGame().setVisible(true);
				panel.getClient().setAccept(false);
				return;
			}
			
		}
		
		panel.getText().setText("Tempo Scaduto.");
		System.out.println("[JCLIENT]\t Nessuno si è connesso al server");
		sleeping(3);
		panel.getApp().getHome().setVisible(true);
		try {
			panel.getApp().getConnessione().getClient().getSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.setVisible(false);
		System.out.println("[JCLIENT] Caricamento terminato");
		panel.setClientOpen(false);
	}
	
	public void sleeping(int delay) {
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void loading(int i, String txt) {
		sleeping(1);
		panel.getText().setText(txt);
		for(int j = 0; j < 3; j++) {
			sleeping(1);
			panel.getText().setText(panel.getText().getText().concat("."));
		}
		if(i >= 3) {
			i = 0;
		}
		i++;
	}	
	
}
