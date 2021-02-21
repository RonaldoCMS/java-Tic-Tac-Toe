package tris.panels.selectBox;

import javax.swing.JPanel;

import tris.panels.App;
import tris.panels.internSelectBo.join.JoinPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JoinGame extends JPanel {

	private PanelSelectBox panel;
	private JPanel app;
	private JoinPanel join;
	
	public JoinGame(final SelectBox selectBox, final App app) {
		this.app = app;
		
		setLayout(null);
		panel = new PanelSelectBox("Partecipa ad una partita");
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectBox.setVisible(false);
				join = new JoinPanel(app);
				app.add(join);
			}
		});
		setSize(300, 60);
		panel.setBounds(0, 0, 300, 60);
		add(panel);
	}

	public JPanel getApp() {
		return app;
	}

	public void setApp(JPanel app) {
		this.app = app;
	}

	
	
}
