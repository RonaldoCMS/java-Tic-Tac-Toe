package tris.panels.bartitle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import tris.events.MoveFrame;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BarTitle extends JPanel {
	
	private JPanel panelExit;
	private JLabel lblExit;
	private JLabel lblTitle;
	
	public BarTitle(final JFrame frame) {
		
		setBackground(new Color(34, 110, 112));
		setSize(300, 30);
		setLayout(null);
		
		lblTitleProperty();
		lblExitProperty();
		panelExitProperty();
		
		panelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelExit.setBackground(new Color(105, 17, 16));
				lblExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelExit.setBackground(new Color(34, 110, 112));
				lblExit.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		
		new MoveFrame(frame, this);
		setVisible(true);
		
	}
	private void panelExitProperty() {
		
		panelExit = new JPanel();
		panelExit.setLayout(null);
		panelExit.add(lblExit);
		panelExit.setBackground(new Color(34, 110, 112));
		panelExit.setBounds(268, 0, 32, 28);
		add(panelExit);
		
	}
	
	private void lblExitProperty() {
		lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 32, 30);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
	
	private void lblTitleProperty() {
		lblTitle = new JLabel("TIC TAC TOE");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 267, 30);
		add(lblTitle);
	}
	
}
