import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThemeColorSelectorApp extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;

    public ThemeColorSelectorApp() {
        setTitle("Theme Color Selector");

        mainPanel = new JPanel();

        redButton = new JButton("Red");
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");

        redButton.setActionCommand("RED");
        greenButton.setActionCommand("GREEN");
        blueButton.setActionCommand("BLUE");

        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "RED":
                mainPanel.setBackground(Color.RED);
                break;
            case "GREEN":
                mainPanel.setBackground(Color.GREEN);
                break;
            case "BLUE":
                mainPanel.setBackground(Color.BLUE);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ThemeColorSelectorApp().setVisible(true));
    }
}
