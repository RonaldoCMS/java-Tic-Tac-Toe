package tris.graphics.home.panels.join;

import javax.swing.JPanel;

import tris.graphics.App;
import tris.graphics.home.Home;
import tris.graphics.home.panels.join.panels.JoinPanel;
import tris.util.RowTris;

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
				String nick = app.getSelectBox().getNickGame().getTextField().getTextField().getText();
				home.setVisible(false);
				join = new JoinPanel(app);
				app.add(join);
				app.getConnessione().setNickname(nick);
				System.out.println("[APP] Sei loggato con " + nick);
			}
		});
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
}
