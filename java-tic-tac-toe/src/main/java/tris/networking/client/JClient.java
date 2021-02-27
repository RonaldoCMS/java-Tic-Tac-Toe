package tris.networking.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class JClient implements Runnable {

	private InputStreamReader isr;
	private OutputStreamWriter osw;
	private BufferedReader br;
	private BufferedWriter bw;
	private PrintWriter pw;
	private BufferedReader scanner;
	private Socket socket;
	private boolean interrupted;
	private boolean accept;
	private int test;
	private String indirizzo;
	private boolean azione;
	
	public JClient() {
		azione = false;
		accept = false;
		test = 0;
	}
	
	public void avvia() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void connetti() {
		try {
			interrupted = false;
			socket = new Socket(indirizzo, 6789);
			isr = new InputStreamReader(socket.getInputStream());
			osw = new OutputStreamWriter(socket.getOutputStream());
			
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);
			
			pw = new PrintWriter(bw, true);
			
			scanner = new BufferedReader(new InputStreamReader(System.in));
			//socket.setSoTimeout(10000);
			accept = true;
			//JOptionPane.showMessageDialog(null, "Client Connesso");
		}
		catch(SocketTimeoutException sok) {	
			System.out.println("[JCLIENT] Tempo di ricerca scaduta");
			disconetti();
		}
		catch(ConnectException e) {
			if(test == 5) {
				System.out.println("[JCLIENT] Server non attivo");
				interrupted = true;
				test = 0;
			}
			else {
				System.out.println("[JCLIENT] Tentativo numero " + test + " fallito.");
				test++;
				connetti();
			}
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void disconetti() {
		try {
			socket.close();
			interrupted = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void run() {
		connetti();
	}

	public boolean isInterrupted() {
		return interrupted;
	}

	public void setInterrupted(boolean interrupted) {
		this.interrupted = interrupted;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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

	public BufferedReader getScanner() {
		return scanner;
	}

	public void setScanner(BufferedReader scanner) {
		this.scanner = scanner;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public boolean isAzione() {
		return azione;
	}

	public void setAzione(boolean azione) {
		this.azione = azione;
	}

	
	
	
	
}
