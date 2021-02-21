package tris.panels.internSelectBo.join;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tris.components.TLabel;

public class LoadTextPanel extends JPanel implements Runnable {

	private JLabel text;
	private boolean stop;
	private String textLabel;
	
	public LoadTextPanel() {
		textLabel = "Caricamento in corso";
		this.setBackground(new Color(34, 110, 112));
		this.stop = false;
		setSize(300, 40);
		text = new TLabel(textLabel);
		add(text);
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		
		int j = 0;
		
		while(true) {

			text.setText(textLabel);
			
			for(int i = 0; i <= 3; i++) {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				text.setText(text.getText().concat("."));
			}
			
			if(j == 50) {
				stop = true;
				text.setText("Tempo scaduto");
				Thread.currentThread().stop();
				return;
			}
			j++;
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	
}
