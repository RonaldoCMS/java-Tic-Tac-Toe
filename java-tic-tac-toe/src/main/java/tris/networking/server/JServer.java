package tris.networking.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JServer implements Runnable {
	
	private InputStreamReader isr;
	private OutputStreamWriter osw;
	private BufferedReader br;
	private BufferedWriter bw;
	private PrintWriter pw;
	private ServerSocket server;
	private Socket socket;
	private boolean accept;
	private boolean interrupted;
	private boolean azione;
	
	public JServer() {
		azione = true;
		accept = false;
		interrupted = false;

	}
	
	public void avvia() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		connetti();
	}
	
	private void connetti() {
		try {
			server = new ServerSocket(6789);
			System.out.println("[JSERVER] Avviato il server");
			server.setSoTimeout(10000 * 10);
			socket = server.accept();
			
			isr = new InputStreamReader(socket.getInputStream());
			osw = new OutputStreamWriter(socket.getOutputStream());
			
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);
			
			pw = new PrintWriter(bw, true);
			accept = true;
			
			server.close();
		} 
		catch(SocketTimeoutException sok) {	
			System.out.println("[JSERVER] server non associato a nessun client");
			disconetti();
		}
		catch(SocketException e) {
			System.out.println(e.toString());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void disconetti() {
		try {
			server.close();
			interrupted = true;
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public boolean isInterrupted() {
		return interrupted;
	}

	public void setInterrupted(boolean interrupted) {
		this.interrupted = interrupted;
	}

	public InputStreamReader getIsr() {
		return isr;
	}

	public void setIsr(InputStreamReader isr) {
		this.isr = isr;
	}

	public OutputStreamWriter getOsw() {
		return osw;
	}

	public void setOsw(OutputStreamWriter osw) {
		this.osw = osw;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public BufferedWriter getBw() {
		return bw;
	}

	public void setBw(BufferedWriter bw) {
		this.bw = bw;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	

	public boolean isAzione() {
		return azione;
	}

	public void setAzione(boolean azione) {
		this.azione = azione;
	}
	
}
