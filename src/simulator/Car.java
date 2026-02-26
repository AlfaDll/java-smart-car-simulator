package simulator;

import java.awt.*;

public class Car {
    // Position on the road (in meters)
    private double position;

    // Current speed (in meters per second)
    private double speed;

    // Current acceleration (negative value means braking)
    private double acceleration;

    // Constructor of Car class
    public Car(double position, double speed, double acceleration) {
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    // Changing the speed and the position of the car
    public void update(double timePassed){
        // Updating the speed
        this.speed = this.speed + (this.acceleration * timePassed);

        // Updating the position
        this.position = this.position + (this.speed * timePassed);
    }

    // Creating the actual car and making it visible
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // Making drawing smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        // Placing the car on the road
        // First I have to convert double value (this.position) to int value for fillRect
        int x = (int) this.position;
        int y = 250;

        // Main body
        g2d.setColor(Color.darkGray);
        g2d.fillRect(x, y + 10, 60,15);

        // Roof (Rounded rectangle)
        g2d.fillRoundRect(x + 15, y,30, 15, 10, 10);

        // Windows (lightblue)
        g2d.setColor(new Color(135, 206, 235));
        // Front window
        g2d.fillRect(x + 18, y+ 2, 10, 10);
        // Back window
        g2d.fillRect(x + 32, y+ 2, 10, 10);

        // Wheels
        g2d.setColor(Color.BLACK);
        // Front wheel
        g2d.fillOval(x + 10, y + 20, 12, 12);
        // Back wheel
        g2d.fillOval(x + 38, y + 20, 12, 12);

        // Rims
        g2d.setColor(Color.GRAY);
        // Front rim
        g2d.fillOval(x + 13, y + 23, 6, 6);
        // Back rim
        g2d.fillOval(x + 41, y + 23, 6, 6);

        // Headlights
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x + 58, y + 12, 3, 4);

        // Taillights (red)
        g2d.setColor(Color.RED);
        g2d.fillRect(x - 1, y + 12, 2, 4);

        // Outlines
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y + 10, 60, 15); // Body outline
        g2d.drawRoundRect(x + 15, y, 30, 15, 10, 10); // Roof outline
    }
}

