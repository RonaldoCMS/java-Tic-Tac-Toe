package tris;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tris.panels.App;
import java.awt.FlowLayout;

public class MainProgram extends JFrame {

	private App app;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProgram frame = new MainProgram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainProgram() {
		setUndecorated(true);
		setResizable(false);
		app = new App(this);
		setVisible(true);
		setSize(300, 350);
		getContentPane().add(app);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
