/*******
 *
 * @author RonaldoCMS
 * @version 1.0.0
 *
 *
 */

package tris;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tris.events.ClickButtonEvent;
import tris.events.MoveFrame;
import tris.panel.Buttons;
import tris.panel.Points;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Component;

public class MainProgram extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnNewMatch;
    private Buttons CenterPanel;
    private Points pointsPanel;
    private JPanel nordPanel;
    private JPanel panelExit;
    private JLabel Exit;

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
        setBounds(0, 0, 220, 277);
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
        contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPane.setBounds(new Rectangle(100, 100, 100, 100));
        contentPane.setBackground(new Color(36, 53, 87));
        contentPane.setBorder(UIManager.getBorder("Button.border"));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        propertyNordPanel();
        propertyCenterPanel();
        propertySudPanel();
    }

    private void propertyCenterPanel() {

        CenterPanel = new Buttons();
        CenterPanel.setBackground(new Color(36, 53, 87));
        contentPane.add(CenterPanel, BorderLayout.CENTER);
    }

    public void propertyNordPanel() {

        nordPanel = new JPanel();
        nordPanel.setBackground(new Color(36, 53, 87));
        nordPanel.setBorder(new EmptyBorder(1, 1, 2, 1));
        nordPanel.setLayout(new BoxLayout(nordPanel, BoxLayout.X_AXIS));
        contentPane.add(nordPanel, BorderLayout.NORTH);

        pointsPanel = new Points();
        pointsPanel.setBackground(new Color(36, 53, 87));
        Points.getPunteggioO().setForeground(Color.WHITE);
        Points.getPunteggioX().setForeground(Color.WHITE);
        nordPanel.add(pointsPanel);

        panelExit = new JPanel();
        panelExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panelExit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelExit.setBackground(new Color(36, 53, 87));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                MainProgram.this.dispose();
            }
        });

        panelExit.setBackground(new Color(36, 53, 87));
        nordPanel.add(panelExit);
        panelExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainProgram.this.dispose();
            }
        });

        Exit = new JLabel("X");
        Exit.setForeground(Color.WHITE);
        Exit.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
        panelExit.add(Exit);
        Exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainProgram.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelExit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelExit.setBackground(new Color(36, 53, 87));
            }

        });

        new MoveFrame(this, pointsPanel);
    }

    public void propertySudPanel() {

        btnNewMatch = new JButton("Nuova partita");
        btnNewMatch.setFocusable(false);
        btnNewMatch.setFocusTraversalKeysEnabled(false);
        btnNewMatch.setFocusPainted(false);
        btnNewMatch.setBorderPainted(false);
        btnNewMatch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
        btnNewMatch.setForeground(Color.WHITE);
        btnNewMatch.setContentAreaFilled(false);
        setLocationRelativeTo(null);
        btnNewMatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClickButtonEvent().nuovaPartita();
            }
        });

        contentPane.add(btnNewMatch, BorderLayout.SOUTH);
    }
}
