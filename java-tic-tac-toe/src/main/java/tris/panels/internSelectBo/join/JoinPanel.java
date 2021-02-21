package tris.panels.internSelectBo.join;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import tris.components.ButtonJoin;
import tris.panels.App;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JoinPanel extends JPanel {
	
	private PanelJoinIP ip;
	private ButtonJoin ok;
	private ButtonJoin back;
	
	public JoinPanel(final App app) {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setLocation(154, 249);
		separator.setSize(147, 36);
		add(separator);
		
		ip = new PanelJoinIP();
		ip.setBounds(0, 219, 300, 45);
		this.add(ip);
		ip.setVisible(true);
		ip.setLayout(null);
		
		ok = new ButtonJoin("Connetti");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadPanel load = new LoadPanel(app);
				app.getSelectBox().setVisible(false);
				setVisible(false);
				app.add(load);
			}
		});
		ok.setLocation(154, 275);
		back = new ButtonJoin("Torna indietro");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				app.getSelectBox().setVisible(true); 
			}
		});
		back.setLocation(10, 275);
		
		this.add(ok);
		this.add(back);
		
		setBounds(0, 29, 300, 321);
		setBackground(new Color(34, 110, 112));
		
	}

}
