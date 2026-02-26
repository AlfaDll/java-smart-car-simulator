package simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInterface extends JFrame {
    // Constructor
    public MenuInterface(){
        setTitle("Smart Car Simulator - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);

        // Centring the window in the screen
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(50, 50, 50));

        // Title label
        JLabel titleLabel = new JLabel("SMART CAR SIMULATOR", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.white);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 20, 20));
        buttonPanel.setBackground(new Color(50, 50, 50));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,100, 100, 100));

        // Button 1 : Third Person View
        JButton btnThirdPerson = new JButton("Third Person View");
        btnThirdPerson.setFont(new Font("Arial", Font.BOLD, 20));
        btnThirdPerson.setBackground(Color.red);
        btnThirdPerson.setForeground(Color.white);
        btnThirdPerson.setFocusPainted(false);

        // Equivalent of addEventListener of JavaScript
        btnThirdPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchThirdPersonView();
            }
        });

        // Button 2 : First Person View (same as the other button just the background color that changes)
        JButton btnFirstPerson = new JButton("Third Person View");
        btnFirstPerson.setFont(new Font("Arial", Font.BOLD, 20));
        btnFirstPerson.setBackground(Color.blue);
        btnFirstPerson.setForeground(Color.white);
        btnFirstPerson.setFocusPainted(false);

        // Equivalent of addEventListener of JavaScript
        btnFirstPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchFirstPersonView();
            }
        });

        // Adding the two buttons to the panel
        buttonPanel.add(btnThirdPerson);
        buttonPanel.add(btnFirstPerson);

        // Adding the rest to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Adding the main panel to the window
        this.add(mainPanel);
    }

    // Method to launch the 2D Simulator (Third Person View)
    private void launchThirdPersonView(){
        // Close the menu window
        this.dispose();
        // Open the simulator
        WindowSimulator window = new WindowSimulator();
        // Literally setting visible
        window.setVisible(true);
    }

    // Method to launch the 3D Simulator (First Person View)
    private void launchFirstPersonView(){
        // Close the menu window
        this.dispose();
        // Open the simulator
        FirstPersonSimulator window = new FirstPersonSimulator();
        // Literally setting visible
        window.setVisible(true);
        // Showing a popup message. The window stays open behind it!
        JOptionPane.showMessageDialog(this, "First Person view coming soon!");
    }
}
