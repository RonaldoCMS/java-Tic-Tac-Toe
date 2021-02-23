package tris.util;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;

public class RowTris extends JPanel {
	
	private LabelTris lblText;
	private String text;
	
	public RowTris(String text) {
		this.text = text;
		
		setForeground(Color.WHITE);
		setBackground(new Color(34, 110, 112));
		setSize(300, 60);
		setLayout(new BorderLayout(0, 0));
		
		lblProperty();
		events();
		
		setVisible(true);
	}

	private void events() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(27, 75, 77));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(34, 110, 112));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
		});
	}

	private void lblProperty() {
		lblText = new LabelTris(text);
		lblText.setForeground(Color.WHITE);
		lblText.setHorizontalTextPosition(SwingConstants.CENTER);
		//lblText.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
		lblText.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblText);
		
	}

}
