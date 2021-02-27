package tris.graphics.home.panels.join;

import javax.swing.JPanel;

import tris.events.PlayEvent;
import tris.graphics.App;
import tris.graphics.home.Home;
import tris.graphics.home.panels.join.panels.JoinPanel;
import tris.util.RowTris;

import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JoinGame extends JPanel {
	
	private Home home;
	private RowTris panel;
	private App app;
	private JoinPanel join;
	
	public JoinGame(final Home home, final App app) {
		this.app = app;
		this.home = home;;
		panel = new RowTris("Partecipa ad una partita");
		panel.setBounds(0, 0, 300, 60);

		setLayout(null);
		setSize(300, 60);
		add(panel);
		event();
	}

	private void event() {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nick = app.getHome().getNickGame().getTextField().getTextField().getText();
				home.setVisible(false);
				join = new JoinPanel(home);
				app.add(join);
				join.setVisible(true);
				app.getConnessione().setNickname(nick);
			}
		});
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public RowTris getPanel() {
		return panel;
	}

	public void setPanel(RowTris panel) {
		this.panel = panel;
	}

	public JoinPanel getJoin() {
		return join;
	}

	public void setJoin(JoinPanel join) {
		this.join = join;
	}
	
	
}
