import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreetingFormApp extends JFrame implements ActionListener {
    private JTextField nameField;
    private JButton greetButton;
    private JButton resetButton;
    private JLabel messageLabel;

    public GreetingFormApp() {
        setTitle("Greeting Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        nameField = new JTextField(15);
        greetButton = new JButton("Greet");
        resetButton = new JButton("Reset");
        messageLabel = new JLabel("Enter your name and press Greet.", SwingConstants.CENTER);

        greetButton.addActionListener(this);
        resetButton.addActionListener(this);


        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(greetButton);
        inputPanel.add(resetButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(messageLabel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == greetButton) {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                messageLabel.setText("Please enter a name.");
            } else {
                messageLabel.setText("Hello, " + name + "!");
            }
        } else if (source == resetButton) {
            nameField.setText("");
            messageLabel.setText("Enter your name and press Greet.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GreetingFormApp app = new GreetingFormApp();
            app.setVisible(true);
        });
    }
}
