package tris.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import tris.panel.Buttons;
import tris.panel.Points;

public class ClickButtonEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if (Buttons.isX()) {
            button.setText("X");
            Buttons.setX(false);
        } else {
            button.setText("O");
            Buttons.setX(true);
        }

        button.setEnabled(false);

        esito();
    }

    private void esito() {
        String[] b = {Buttons.getBtn(0).getText(),
                Buttons.getBtn(1).getText(),
                Buttons.getBtn(2).getText(),
                Buttons.getBtn(3).getText(),
                Buttons.getBtn(4).getText(),
                Buttons.getBtn(5).getText(),
                Buttons.getBtn(6).getText(),
                Buttons.getBtn(7).getText(),
                Buttons.getBtn(8).getText()
        };


        valuta(b[0], b[1], b[2]);
        valuta(b[3], b[4], b[5]);
        valuta(b[6], b[7], b[8]);
        valuta(b[0], b[3], b[6]);
        valuta(b[1], b[4], b[7]);
        valuta(b[2], b[5], b[8]);
        valuta(b[0], b[4], b[8]);
        valuta(b[2], b[4], b[6]);

        int i = 0;

        for (String s : b) {
            if (!s.equals("")) {
                i++;
            }
        }

        if (i == 9) {
            JOptionPane.showMessageDialog(null, "Nessuno ha vinto, pareggio!");
            reset();
        }

    }

    private void valuta(String s1, String s2, String s3) {
        if (s1.equals(s2) && s2.equals(s3) && !s1.equals("")) {

            if (s1.equals("X"))
                winX();
                //System.out.println("X");
            else
                winO();
            //System.out.println("O");

            reset();
        }
    }

    private void winX() {
        Points.setValX(Points.getValX() + 1);
        Points.setPunteggioX("Punteggio X : " + Points.getValX());
        JOptionPane.showMessageDialog(null, "Vince X! Attenzione incomincia O");

    }

    private void winO() {
        Points.setValY(Points.getValY() + 1);
        Points.setPunteggioO("Punteggio O : " + Points.getValY());
        JOptionPane.showMessageDialog(null, "Vince O! Attenzione incomincia X");
    }

    public void nuovaPartita() {
        chiudiPulsanti();
        abilitaPulsanti();

        Points.setValY(0);
        Points.setPunteggioO("Punteggio O : " + Points.getValY());

        Points.setValX(0);
        Points.setPunteggioX("Punteggio X : " + Points.getValX());
    }

    private void reset() {
        chiudiPulsanti();
        abilitaPulsanti();
    }

    private void chiudiPulsanti() {
        for (int i = 0; i < 9; i++)
            Buttons.getBtn(i).setText("");
    }

    private void abilitaPulsanti() {
        for (int i = 0; i < 9; i++)
            Buttons.getBtn(i).setEnabled(true);

    }
}
