package tris.panels.networking.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class JServer implements Runnable {
	
	private ServerSocket server;
	private Socket socket;
	
	public JServer() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		try {
			server = new ServerSocket(6789);
			System.out.println("Eccomi");
			socket = server.accept();
		
			server.close();
			
			JOptionPane.showMessageDialog(null, "Server Connesso");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
