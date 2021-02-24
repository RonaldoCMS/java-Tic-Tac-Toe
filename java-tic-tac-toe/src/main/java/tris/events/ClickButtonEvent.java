package tris.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.w3c.dom.events.MouseEvent;

import tris.graphics.game.panels.Blocco;
import tris.networking.Connection;
import tris.networking.client.JClient;
import tris.networking.server.JServer;

public class ClickButtonEvent implements ActionListener, Runnable {

	private JServer server;
	private JClient client;
	private Timer time;
	private Blocco[] blocco;
	private Blocco b;
	private boolean boolServer;
	private int test;
	private boolean com;
	
	public ClickButtonEvent(JServer server, Blocco[] blocco) {
		this.server = server;
		this.blocco = blocco;
		boolServer = true;
		test = 1;
		com = false;
		
		test();
	}
	
	public ClickButtonEvent(JClient client2, Blocco[] blocco) {
		client = client2;
		this.blocco = blocco;
		boolServer = false;
		test = 2;
		
		test();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Ciao");
		
		b = (Blocco) e.getSource();
		b.setText("Prova");
		com = true;
	}
	
	public void test() {
		Thread t1 = new Thread(this);
		t1.start();
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(test!=1) {
			try {
				int pos = Integer.parseInt(client.getBr().readLine());
				blocco[pos].setText("Ciao");
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		else {
			if(boolServer) {
				if(com) {
					server.getPw().println(b.getPosizione());
					com = false;
					break;
				}
			}
		}
		}
	}
	

	

}
