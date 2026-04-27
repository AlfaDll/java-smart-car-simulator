package simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerspectiveRoad extends JPanel {
    // Variable for the animation (lines moves)
    private int offset = 0;

    // Constructor to add the animation timer
    public PerspectiveRoad() {
        //timer of 30 milliseconds
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offset = offset + 8; // Speed of the road
                if (offset > 150) {
                    offset = 0;
                }
                repaint(); // redraw of the window
            }
        });
        timer.start();
    }

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

        // the white line of the middle
        g.setColor(Color.white);
        int[] xLine = {390, 410, 402, 398};
        int[] yLine = {600, 600, 300, 300};
        g.fillPolygon(xLine, yLine, 4);

        // Car body of the car in front
        g.setColor(new Color(200, 0, 0));
        g.fillRect(280, 380, 240, 120);

        // Back window of the car in front
        g.setColor(Color.DARK_GRAY);
        g.fillRect(310, 400, 180, 40);

        // Tires of the car in front
        g.setColor(Color.BLACK);
        g.fillRect(260, 470, 40, 40); // Left tire
        g.fillRect(500, 470, 40, 40); // Right tire

        // The roof edge (Top of the screen)
        g.setColor(new Color(20, 20, 20)); // Very dark gray
        g.fillRect(0, 0, 800, 40);

        // The left A-pillar of the windshield (Montant gauche)
        int[] xLeftPillar = {0, 80, 40, 0};
        int[] yLeftPillar = {0, 0, 480, 480};
        g.fillPolygon(xLeftPillar, yLeftPillar, 4);

        // The right A-pillar of the windshield (Montant droit)
        int[] xRightPillar = {720, 800, 800, 760};
        int[] yRightPillar = {0, 0, 480, 480};
        g.fillPolygon(xRightPillar, yRightPillar, 4);

        // Main dashboard at the bottom
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 480, 800, 120);

        // Outside of the steering wheel
        g.setColor(new Color(40, 40, 40));
        g.fillOval(100, 400, 200, 200);

        // Inside of the steering wheel (makes a hole)
        g.setColor(new Color(30, 30, 30));
        g.fillOval(130, 430, 140, 140);

        // Steering wheel branch
        g.setColor(new Color(40, 40, 40));
        g.fillRect(100, 490, 200, 20);
        g.setColor(Color.GRAY);

        // Speed simulation cutting the white line
        for(int i = 0; i < 3; i++) {
            // Y position moves down the screen
            int yCut = 300 + ((offset + (i * 100)) % 300);

            // The cut gets taller as it gets closer to us (3D effect)
            int cutHeight = 10 + ((yCut - 300) / 4);

            // We draw the gray rectangle over the white line
            g.fillRect(380, yCut, 40, cutHeight);
        }
    }
}


