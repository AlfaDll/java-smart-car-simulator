package simulator;

import java.awt.Color;
import java.awt.Graphics;

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
        // Choosing a color for the car
        g.setColor(Color.RED);

        // Drawing the car as a rectangle
        // First I have to convert double value (this.position) to int value for fillRect
        g.fillRect((int) this.position,250,50,30);
    }
}

