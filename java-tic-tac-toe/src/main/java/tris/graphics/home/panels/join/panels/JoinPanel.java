package tris.graphics.home.panels.join.panels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import tris.events.PlayEvent;
import tris.graphics.App;
import tris.graphics.home.Home;
import tris.networking.Connection;
import tris.threading.LoadPanel;
import tris.util.ButtonTris;
import tris.util.Elementi;
import tris.util.Logo;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JoinPanel extends JPanel {
	
	// <!-- Classe principale -->
	private Home home;
	private App app;
	
	
	private Logo logo;
	private PanelJoinIP ip;
	private ButtonTris ok;
	private ButtonTris back;
	private LoadPanel load;
	
	public JoinPanel(Home home) {
		this.home = home;
		this.app = home.getApp();
		setLayout(null);
		
		separatorProperty();
		
		okProperty(this);
		backProperty();
		logoProperty();
		ipProperty();
		
		setBounds(0, 29, 300, 321);
		setBackground(Elementi.background);
		
		this.add(ok);
		this.add(back);
		add(logo);
		setVisible(true);
	}

	private void logoProperty() {
		logo = new Logo();
		logo.setBounds(10, 11, 280, 222);
		logo.logoMax();
	}

	private void backProperty() {
		back = new ButtonTris("indietro");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				app.getHome().setVisible(true); 
				setVisible(false);
			}
		});
		back.setLocation(10, 275);
	}

	private void okProperty(final JPanel panel) {
		ok = new ButtonTris("Connetti");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(insertIndirizzo()) {
					ok.addMouseListener(new PlayEvent(home, panel, false));
				}
			}
		});
		ok.setLocation(154, 275);
	}
	
	private boolean insertIndirizzo() {
		String temp = ip.getTextField().getTextField().getText();
		if(temp.equals("")) {
			JOptionPane.showMessageDialog(null, "INSERISCI INDIRIZZO!");
			return false;
		}
		else {
			app.getConnessione().getClient().setIndirizzo(temp);
			//client.setNickname();
			return true;
		}
		
	}

	private void ipProperty() {
		ip = new PanelJoinIP();
		ip.setBounds(0, 219, 300, 45);
		ip.setLayout(null);
		this.add(ip);
		ip.setVisible(true);
	}

	private void separatorProperty() {
		JSeparator separator = new JSeparator();
		separator.setLocation(154, 249);
		separator.setSize(147, 36);
		add(separator);
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Logo getLogo() {
		return logo;
	}

	public void setLogo(Logo logo) {
		this.logo = logo;
	}

	public PanelJoinIP getIp() {
		return ip;
	}

	public void setIp(PanelJoinIP ip) {
		this.ip = ip;
	}

	public ButtonTris getOk() {
		return ok;
	}

	public void setOk(ButtonTris ok) {
		this.ok = ok;
	}

	public ButtonTris getBack() {
		return back;
	}

	public void setBack(ButtonTris back) {
		this.back = back;
	}

	public LoadPanel getLoad() {
		return load;
	}

	public void setLoad(LoadPanel load) {
		this.load = load;
	}

	
	
}
