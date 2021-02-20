package tris.panels.networking.host;

import java.awt.Color;

import javax.swing.JPanel;

import tris.panels.App;

public class HostPanel extends JPanel implements Runnable {
	
	private HostTextPanel panel;
	private App app;

	public HostPanel(App app) {
		this.app = app;
		setBounds(0, 29, 300, 321);
		setLayout(null);
		setBackground(new Color(34, 100, 112));
		
		panel = new HostTextPanel();
		panel.setBounds(0, 136, 300, 40);
		add(panel);
		
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {

		while(true) {
			System.out.println("Test");
			if(panel.isStop()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				app.getSelectBox().setVisible(true);
				this.setVisible(false);
				Thread.currentThread().stop();
			}
		}
		
	}
}
