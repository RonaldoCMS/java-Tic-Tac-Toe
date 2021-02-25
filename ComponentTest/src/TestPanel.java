import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestPanel extends JPanel {
	
	test test;
	
	public TestPanel(test test) {
		this.test = test;
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				test.setVisible(false);
				JButton p = (JButton) e.getSource();
				p.setVisible(false);
			}
		});
		add(btnNewButton_1);
		test.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setVisible(true);
		btnNewButton.setBounds(93, 119, 89, 23);
		test.getContentPane().add(btnNewButton);
		setVisible(true);
		
	}

}
