package tris.events;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveFrame {
	 private Point clickMouse;

	    public MoveFrame(final JFrame f, JPanel p) {

	        p.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                /***
	                 * Recuperi il click del mouse
	                 */
	                clickMouse = e.getPoint();
	            }
	        });

	        p.addMouseMotionListener(new MouseMotionAdapter() {
	            @Override
	            public void mouseDragged(MouseEvent e) {
	                Point newClick = e.getLocationOnScreen(); //Recupera le nuove coordinate
	                newClick.translate(-clickMouse.x, -clickMouse.y);
	                f.setLocation(newClick);
	            }
	        });

	    }
}
