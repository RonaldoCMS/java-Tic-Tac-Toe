package tris.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;
import tris.graphics.bartitle.BarTitle;
import tris.graphics.home.Home;
import tris.networking.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class App extends JPanel {
	
	private JFrame frame;
	private JPanel barTitle;
	private Home selectBox;
	private Connection connessione;
	
	public App(JFrame frame) {
		this.connessione = new Connection();
		//setSize(frame.getWidth(), frame.getHeight());
		this.frame = frame;
		
		setSize(300, 350);
		setLayout(null);
		setBackground(new Color(34, 110, 112));
		barTitleProperty();
		selectBoxProperty();
		
		
	}

	private void barTitleProperty() {
		barTitle = new BarTitle(frame);
		barTitle.setLocation(0, 0);
		barTitle.setSize(300, 30);
		add(barTitle);
		barTitle.setLayout(new BorderLayout(0, 0));
	}
	
	private void selectBoxProperty() {
		selectBox = new Home(this);
		add(selectBox);
	}

	public Home getSelectBox() {
		return selectBox;
	}

	public void setSelectBox(Home selectBox) {
		this.selectBox = selectBox;
	}

	public Connection getConnessione() {
		return connessione;
	}

	public void setConnessione(Connection connessione) {
		this.connessione = connessione;
	}
	
	
	
	
}
