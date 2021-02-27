package tris.networking.server;

import java.io.IOException;

import tris.graphics.game.Game;
import tris.threading.LoadPanel;

public class GameServer implements Runnable {

	public LoadPanel panel;
	
	public GameServer(LoadPanel panel) {
		this.panel = panel;
	}
	
	public void run() {
		String txt = panel.getText().getText();
		int i = 0;
		sleeping(1);
		panel.getApp().getConnessione().setBoolServer(true);
		
		while(!panel.getServer().isInterrupted()) {
			loading(i, txt);
			if(panel.getServer().isAccept()) {
				panel.setVisible(false);
	
				
				panel.getServer().getPw().println(panel.getApp().getConnessione().getNickname());
				
				try {
					String enemy = panel.getServer().getBr().readLine();
					panel.getApp().getConnessione().setEnemy(enemy);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				panel.gameProperty();
				panel.getGame().setVisible(true);
				System.out.println("[JSERVER] connesso!");
				panel.getServer().setAccept(false);
				return;
			}
		}
		panel.getApp().getConnessione().setBoolServer(false);
		panel.getText().setText("Tempo Scaduto.");
		System.out.println("[JSERVER]\t Non ho trovato nessun client disponibile");
		sleeping(3);
		panel.getHome().setVisible(true);
		panel.getHome().getHostGame().setVisible(true);
		panel.setVisible(false);
		System.out.println("[JSERVER] Caricamento terminato");
		panel.setServerOpen(false);
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
