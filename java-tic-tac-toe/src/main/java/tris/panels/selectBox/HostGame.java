package tris.panels.selectBox;

import javax.swing.JPanel;

import tris.panels.App;
import tris.panels.internSelectBo.host.HostPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HostGame extends JPanel {
	
	private PanelSelectBox panel;
	private HostPanel host;
	
	public HostGame(final SelectBox selectBox, final App app) {
		setLayout(null);
		panel = new PanelSelectBox("Crea una partita");
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectBox.setVisible(false);
				host = new HostPanel(app);
				app.add(host);
			}
		});
		setSize(300, 60);
		panel.setBounds(0, 0, 300, 60);
		add(panel);
	}

	public PanelSelectBox getPanel() {
		return panel;
	}

	public void setPanel(PanelSelectBox panel) {
		this.panel = panel;
	}
	
	

}
