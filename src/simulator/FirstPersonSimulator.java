package simulator;

import javax.swing.*;

public class FirstPersonSimulator extends JFrame {

    // Constructor for  FirstPersonSimulator
    public FirstPersonSimulator(){
        setTitle("Smart Car Simulator - 3D");

        // Means kill the program and free memory when red cross (top right) is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initial size of the window
        setSize(800,600);

    }

}
