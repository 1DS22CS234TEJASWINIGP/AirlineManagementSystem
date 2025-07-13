package airlinemanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirlineLoginSystem extends JFrame {
    public AirlineLoginSystem() {
        setTitle("Airline Login System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adding a panel to the frame
        JPanel panel = new JPanel(new BorderLayout());

        // Adding an image to the panel
        ImageIcon airlineImage = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\Arico Airlines.png"); // Replace with the actual path of your image
        JLabel imageLabel = new JLabel(airlineImage);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Adding buttons for Admin and User
        JButton adminButton = new JButton("Admin Login");
        JButton userButton = new JButton("User Login");

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginpage obj =new loginpage();
                obj.setVisible(true);
                dispose();
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            UserLogin obj =new UserLogin();
                obj.setVisible(true);
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(adminButton);
        buttonPanel.add(userButton);
    
        

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AirlineLoginSystem().setVisible(true);
  });
}
}
