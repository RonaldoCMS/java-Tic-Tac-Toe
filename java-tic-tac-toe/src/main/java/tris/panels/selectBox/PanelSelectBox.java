package tris.panels.selectBox;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;

public class PanelSelectBox extends JPanel {
	
	private JLabel lblText;
	
public PanelSelectBox(String text) {
	setForeground(Color.WHITE);
		
		setBackground(new Color(34, 110, 112));
		
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
		setSize(300, 60);
		setLayout(new BorderLayout(0, 0));
		
		lblText = new JLabel(text);
		lblText.setForeground(Color.WHITE);
		lblText.setHorizontalTextPosition(SwingConstants.CENTER);
		lblText.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblText);
		setVisible(true);
	}

}
