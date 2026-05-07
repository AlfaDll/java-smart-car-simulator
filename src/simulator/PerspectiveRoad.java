package simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PerspectiveRoad extends JPanel {
    // Variable for the animation (lines moves)
    private int offset = 0;

    // Variable to stock the image of the car ahead
    private Image carImage;

    // Variable for the steering wheel angle (in radians)
    private double steeringAngle = 0.0;

    // Variable for the actual speed of the car (km/h)
    private int speed = 120;

    public PerspectiveRoad() throws IOException {
        // Allow JPanel to listen the keyboard
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    steeringAngle -= 0.1;
                    if (steeringAngle < -0.8) steeringAngle = -0.8;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    steeringAngle += 0.1;
                    if (steeringAngle > 0.8) steeringAngle = 0.8;
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    speed += 2;
                    if (speed > 220) speed = 220;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    speed -= 3;
                    if (speed < 0) speed = 0;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                steeringAngle = 0.0;
            }
        });

        carImage = ImageIO.read(new File("src/simulator/carInFront.png"));

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offset = offset + 8;
                if (offset > 150) {
                    offset = 0;
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        // Draw the sky
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 800, 300);

        // Draw the grass
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 300, 800, 300);

        // draw the road
        g.setColor(Color.GRAY);
        int[] xPoints = {-400, 800, 350, 250};
        int[] yPoints = {600, 600, 300, 300};
        g.fillPolygon(xPoints, yPoints, 4);

        // the white line of the middle
        g.setColor(Color.white);
        int[] xLine = {180, 200, 302, 298};
        int[] yLine = {600, 600, 300, 300};
        g.fillPolygon(xLine, yLine, 4);

        // Speed simulation cutting the white line
        g.setColor(Color.GRAY);
        for(int i = 0; i < 3; i++) {
            int yCut = 300 + ((offset + (i * 100)) % 300);
            int cutHeight = 10 + ((yCut - 300) / 4);
            int xCut = 300 - ((yCut - 300) / 4);
            g.fillRect(xCut, yCut, 40, cutHeight);
        }

        if (carImage != null){
            g.drawImage(carImage, 255, 325, 130, 110, null);
        }

        // The roof edge
        g.setColor(new Color(20, 20, 20));
        g.fillRect(0, 0, 800, 40);

        // The left A-pillar
        int[] xLeftPillar = {0, 80, 40, 0};
        int[] yLeftPillar = {0, 0, 480, 480};
        g.fillPolygon(xLeftPillar, yLeftPillar, 4);

        // The right A-pillar
        int[] xRightPillar = {720, 800, 800, 760};
        int[] yRightPillar = {0, 0, 480, 480};
        g.fillPolygon(xRightPillar, yRightPillar, 4);

        // Main dashboard at the bottom
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 480, 800, 120);

        // Speed text
        g.setFont(new Font("Monospaced", Font.BOLD, 40));
        g.setColor(new Color(50, 255, 50));
        g.drawString(speed + " KM/H", 430, 550);

        // Steering wheel
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(40, 40, 40));
        g.fillOval(100, 400, 200, 200);

        g.setColor(new Color(30, 30, 30));
        g.fillOval(130, 430, 140, 140);

        g.setColor(new Color(40, 40, 40));
        g.fillRect(100, 490, 200, 20);

        // Rotate steering wheel
        java.awt.geom.AffineTransform oldTransform = g2d.getTransform();
        g2d.rotate(steeringAngle, 200, 500);

        g2d.setColor(new Color(40, 40, 40));
        g2d.fillOval(100, 400, 200, 200);

        g2d.setColor(new Color(30, 30, 30));
        g2d.fillOval(130, 430, 140, 140);

        g2d.setColor(new Color(40, 40, 40));
        g2d.fillRect(100, 490, 200, 20);

        g2d.setTransform(oldTransform);
    }
}