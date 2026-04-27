package simulator;

import javax.swing.*;
import java.awt.*;

public class PersectiveRoad extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        // First we clean the window
        super.paintComponent(g);

        // Draw the sky (top-half of the front window)
        g.setColor(new Color(135, 206, 235)); // Un beau bleu ciel
        g.fillRect(0, 0, 800, 300);

        // Draw the grass (bottom-half of the front-window)
        g.setColor(new Color(34, 139, 34)); // Vert forêt
        g.fillRect(0, 300, 800, 300);

        // draw the road whit gray
        g.setColor(Color.GRAY);

        // The four x corners coordinates
        int[] xPoints = {100, 700, 450, 350};

        // The four y corners coordinates
        int[] yPoints = {600, 600, 300, 300};

        // draw the form with the 4 points
        g.fillPolygon(xPoints, yPoints, 4);
    }
}


