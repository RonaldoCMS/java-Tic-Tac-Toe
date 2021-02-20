package tris.panels.networking.host;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HostTextPanel extends JPanel implements Runnable {

	private JLabel text;
	private boolean stop;
	
	public HostTextPanel() {
		this.setBackground(new Color(34, 110, 112));
		this.stop = false;
		setSize(300, 40);
		text = new HostLabel();
		add(text);
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		
		int i = 0;
		int j = 0;
		
		while(true) {
			
			i++;
			j++;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch(i) {
			case 1:
				text.setText("Caricamento in corso.");
				break;
			case 2:
				text.setText("Caricamento in corso..");
				break;
			case 3:
				text.setText("Caricamento in corso...");
				break;
			}
			
			if (i==3) {
				i = 0;
			}
			
			if(j == 10) {
				stop = true;
				text.setText("Tempo scaduto");
				Thread.currentThread().stop();
				return;
			}
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	
}
