package tris;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tris.graphics.App;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

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

	//"./cd../cd../cd../cd../images/logo.png"
	public MainProgram() {
		super("Tic-Tac-Toe Game");
		setUndecorated(true);
		setResizable(false);
		app = new App(this);
		setVisible(true);
		setSize(300, 350);
		getContentPane().add(app);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("./images/logo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
