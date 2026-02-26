package simulator;
import javax.swing.*;

/* "extends" allows the class to do everything
that the parent class (JFrame here) can do. It's
called Inheritance.*/
public class WindowSimulator extends JFrame {

    // Constructor for  WindowSimulator
    public WindowSimulator(){
        setTitle("Smart Car Simulator");

        // Means kill the program and free memory when red cross (top right) is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initial size of the window
        setSize(800,600);

        // Adding the road
        this.add(new Road());
    }

}
