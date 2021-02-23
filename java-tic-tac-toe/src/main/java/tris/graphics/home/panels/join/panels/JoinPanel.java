package tris.graphics.home.panels.join.panels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import tris.graphics.App;
import tris.networking.Connection;
import tris.threading.LoadPanel;
import tris.util.ButtonTris;
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
	private App app;
	
	private Logo logo;
	private PanelJoinIP ip;
	private ButtonTris ok;
	private ButtonTris back;
	private LoadPanel load;
	
	public JoinPanel(final App app) {
		this.app = app;
		setLayout(null);
		
		separatorProperty();
		ipProperty();
		okProperty();
		backProperty();
		logoProperty();
		
		setBounds(0, 29, 300, 321);
		setBackground(new Color(34, 110, 112));
		
		this.add(ok);
		this.add(back);
		add(logo);
		
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
				setVisible(false);
				app.getSelectBox().setVisible(true); 
			}
		});
		back.setLocation(10, 275);
	}

	private void okProperty() {
		ok = new ButtonTris("Connetti");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(insertIndirizzo()) {
					LoadPanel load = new LoadPanel(app);
					load.avviaClient();
					load.setBounds(0, 244, 300, 40);
					app.getSelectBox().setVisible(false);
					setVisible(false);
					app.add(load);
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
		this.add(ip);
		ip.setVisible(true);
		ip.setLayout(null);
	}

	private void separatorProperty() {
		JSeparator separator = new JSeparator();
		separator.setLocation(154, 249);
		separator.setSize(147, 36);
		add(separator);
	}

}
