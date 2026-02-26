package simulator;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Road extends JPanel {
    // Overriding the default drawing method of JPanel
    // Overriding = "écraser"
    @Override
    // Protected is for the inherited import JPanel here
    protected void paintComponent(Graphics g){
        // ALWAYS (!) cleaning the screen first
        super.paintComponent(g);

        // Setting the gray color to draw
        g.setColor(Color.gray);

        // Drawing the rectangle
        g.fillRect(0,200,800,200);
    }


}
