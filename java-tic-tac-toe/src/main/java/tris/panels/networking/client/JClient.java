package tris.panels.networking.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class JClient {

	private Socket socket;
	
	public JClient() {
		try {
			socket = new Socket("localhost", 6789);
			JOptionPane.showMessageDialog(null, "Client Connesso");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
