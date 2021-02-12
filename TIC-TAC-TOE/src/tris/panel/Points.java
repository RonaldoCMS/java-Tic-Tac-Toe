package tris.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;


public class Points extends JPanel {

    private static JLabel punteggioX;
    private static JLabel punteggioO;
    private static int valX;
    private static int valY;

    public Points() {

        valX = 0;
        valY = 0;

        setLayout(new GridLayout(0, 1, 0, 0));

        punteggioX = new JLabel("Punteggio X : 0");
        punteggioX.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
        add(punteggioX);

        punteggioO = new JLabel("Punteggio O : 0");
        punteggioO.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
        add(punteggioO);
    }

    public static JLabel getPunteggioX() {
        return punteggioX;
    }

    public static void setPunteggioX(String punteggioX) {
        Points.punteggioX.setText(punteggioX);
    }

    public static JLabel getPunteggioO() {
        return punteggioO;
    }

    public static void setPunteggioO(String punteggioO) {
        Points.punteggioO.setText(punteggioO);
    }

    public static int getValX() {
        return valX;
    }

    public static void setValX(int valX) {
        Points.valX = valX;
    }

    public static int getValY() {
        return valY;
    }

    public static void setValY(int valY) {
        Points.valY = valY;
    }


}
