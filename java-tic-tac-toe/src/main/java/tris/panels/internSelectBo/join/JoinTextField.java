package tris.panels.internSelectBo.join;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JoinTextField extends JTextField {
	
	public JoinTextField() {
		
		setVisible(true);
		setBounds(0, 0, 200, 40);
		setBorder(null);
		setAutoscrolls(false);
		setInheritsPopupMenu(true);
		setFont(new Font("Tahoma", Font.PLAIN, 19));
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		setOpaque(false);
		setBounds(105, 122, 261, 35);
		
	}

}
