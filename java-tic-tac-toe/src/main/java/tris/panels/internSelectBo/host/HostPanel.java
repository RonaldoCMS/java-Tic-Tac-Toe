package tris.panels.internSelectBo.host;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tris.panels.App;
import tris.panels.networking.server.JServer;

public class HostPanel extends JPanel implements Runnable {
	
	
	private HostTextPanel panel;
	private App app;
	private JServer server;

	public HostPanel(App app) {
		this.app = app;
		server = new JServer();
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setBackground(new Color(34, 100, 112));
		
		panelProperty();
		threading();
	}

	private void threading() {
		Thread thread = new Thread(this);
		thread.start();
	}

	private void panelProperty() {
		panel = new HostTextPanel();
		panel.setBounds(0, 281, 300, 40);
		add(panel);
	}

	public void run() {
		while(Thread.currentThread().isAlive()) {
			if(panel.isStop()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					JOptionPane.showMessageDialog(null, "Errore di sistema");
				}
				app.getSelectBox().setVisible(true);
				this.setVisible(false);
				Thread.currentThread().stop();
			}
		}
	}
	
}
