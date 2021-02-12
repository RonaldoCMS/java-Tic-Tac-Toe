package tris.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;

import tris.events.ClickButtonEvent;

import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Buttons extends JPanel {

    private static boolean X;
    private static JButton[] btn;

    public Buttons() {

        btn = new JButton[9];
        setLayout(new GridLayout(3, 3, 0, 0));

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton("");
            btn[i].setFocusable(false);
            btn[i].setFocusTraversalKeysEnabled(false);
            btn[i].setFocusPainted(false);
            btn[i].setBorderPainted(false);
            btn[i].setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
            btn[i].setForeground(Color.WHITE);
            btn[i].setContentAreaFilled(false);

        }
        X = true;
        panelProperty();
        eventsProperty();

    }

    private void panelProperty() {
        for (int i = 0; i < btn.length; i++)
            add(btn[i]);
    }

    private void eventsProperty() {
        for (int i = 0; i < btn.length; i++)
            btn[i].addActionListener(new ClickButtonEvent());
    }

    public static boolean isX() {
        return X;
    }

    public static void setX(boolean x) {
        X = x;
    }

    public static JButton getBtn(int index) {
        return btn[index];
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dividiTris(g, 0, 64, 250, 3, Color.white);
        dividiTris(g, 0, 128, 250, 3, Color.white);
        dividiTris(g, 70, 0, 3, 250, Color.white);
        dividiTris(g, 140, 0, 3, 250, Color.white);
        g.dispose();
    }

    private void dividiTris(Graphics g, int x, int y, int width, int height, Color c) {
        g.setColor(c);
        g.fillRect(x, y, width, height);

    }

}
