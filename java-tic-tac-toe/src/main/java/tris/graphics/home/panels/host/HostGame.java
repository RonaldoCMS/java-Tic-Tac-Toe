package tris.graphics.home.panels.host;

import javax.swing.JPanel;

import tris.events.PlayEvent;
import tris.graphics.App;
import tris.graphics.home.Home;
import tris.graphics.home.panels.host.panels.HostPanel;
import tris.graphics.home.panels.join.panels.JoinPanel;
import tris.threading.LoadPanel;
import tris.util.RowTris;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HostGame extends JPanel {
	
	private Home selectBox;
	private RowTris panel;
	private App app;
	
	public HostGame(final Home selectBox, App app) {
		this.selectBox = selectBox;
		this.app = app;
		
		setLayout(null);
		setSize(300, 60);
		
		panelSelectBoxProperty();
		events();
	}

	private void panelSelectBoxProperty() {
		panel = new RowTris("Crea una partita");
		panel.setBounds(0, 0, 300, 60);
		add(panel);
		
	}

	private void events() {
		panel.addMouseListener(new PlayEvent(selectBox, this, true));
	}

	public void load() {
		LoadPanel load = new LoadPanel(selectBox);
		load.avviaServer();
		load.setBounds(0, 244, 300, 40);
		app.add(load);
	}
	
	public RowTris getPanel() {
		return panel;
	}

	public void setPanel(RowTris panel) {
		this.panel = panel;
	}

}
