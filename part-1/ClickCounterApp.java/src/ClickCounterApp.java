import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickCounterApp extends JFrame implements ActionListener {

    private JLabel counterLabel;
    private JButton clickButton;
    private JButton resetButton;
    private int count = 0;

    public ClickCounterApp() {
        setTitle("Click Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        counterLabel = new JLabel("Clicks: 0", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 24));

        clickButton = new JButton("Click Me");
        clickButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            count = 0;
            counterLabel.setText("Clicks: 0");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(clickButton);
        buttonPanel.add(resetButton);

        setLayout(new BorderLayout());
        add(counterLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        counterLabel.setText("Clicks: " + count);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClickCounterApp().setVisible(true));
    }
}
