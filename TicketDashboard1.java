package airlinemanagement;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TicketDashboard1 extends JFrame {
    private JTextField ticketNumberField;

    private final List<String> availableSlots;

    public TicketDashboard1() {
        setTitle("Ticket Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        availableSlots = generateAvailableSlots();

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10)); // Use GridLayout with spacing
        panel.setBackground(new Color(230, 230, 250)); // Set background color
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel ticketNumberLabel = new JLabel("Ticket Number:");
        ticketNumberLabel.setForeground(Color.BLACK); // Set foreground color
        ticketNumberLabel.setBounds(10, 20, 100, 25);
        panel.add(ticketNumberLabel);

        ticketNumberField = new JTextField(20);
        ticketNumberField.setBounds(120, 20, 150, 25);
        panel.add(ticketNumberField);

        JButton bookTicketButton = new JButton("Book Ticket");
        bookTicketButton.setBackground(new Color(220, 208, 255)); // Set background color
        bookTicketButton.setBounds(10, 60, 120, 25);
        bookTicketButton.addActionListener((ActionEvent e) -> {
            onBookTicketButtonClicked();
        });
        panel.add(bookTicketButton);

        JButton cancelTicketButton = new JButton("Cancel Ticket");
        cancelTicketButton.setBackground(new Color(220, 208, 255)); // Set background color
        cancelTicketButton.setBounds(140, 60, 130, 25);
        cancelTicketButton.addActionListener((ActionEvent e) -> {
            onCancelTicketButtonClicked();
        });
        panel.add(cancelTicketButton);

        JButton showSlotsButton = new JButton("Show Available Slots");
        showSlotsButton.setBackground(new Color(220, 208, 255)); // Set background color
        showSlotsButton.setBounds(10, 100, 200, 25);
        showSlotsButton.addActionListener((ActionEvent e) -> {
            onShowSlotsButtonClicked();
        });
        panel.add(showSlotsButton);
    }

    private void onBookTicketButtonClicked() {
        ticketbooking1 obj =new ticketbooking1();
        obj.setVisible(true);
        dispose();
    }

    private void onCancelTicketButtonClicked() {
       ticketcancellation1 obj =new ticketcancellation1();
        obj.setVisible(true);
        dispose(); 
    }

    private void onShowSlotsButtonClicked() {
        String availableSlotsMessage = "Available Slots:\n";
        for (String slot : availableSlots) {
            availableSlotsMessage += slot + "\n";
        }
        JOptionPane.showMessageDialog(this, availableSlotsMessage, "Available Slots", JOptionPane.INFORMATION_MESSAGE);
    }

    private List<String> generateAvailableSlots() {
        List<String> slots = new ArrayList<>();
        // Add some example slots
        slots.add("Slot 1 - 10:00 AM to 11:00 AM");
        slots.add("Slot 2 - 12:00 PM to 1:00 PM");
        slots.add("Slot 3 - 3:00 PM to 4:00 PM");
        return slots;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketDashboard1());
}
}
