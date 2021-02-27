/****
 * 
 * @version 2.0.0
 * @author Ronaldo
 * Inizio progetto: 20/02/2021
 * 
 * 
 */

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
	
	private static final long serialVersionUID = 1L;
	
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
		super("Tic-Tac-Toe Game");
		frameProperty();
		app = new App(this);
		getContentPane().add(app);
	}
	
	private void frameProperty() {
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		setSize(300, 350);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			this.setIconImage(ImageIO.read(new File("./images/bg1.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
