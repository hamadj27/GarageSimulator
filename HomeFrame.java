import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class HomeFrame extends JFrame {
    private JButton addButton = new JButton("Add Vehicle");
    private JButton removeButton = new JButton("Remove Vehicle");
    private JButton searchButton = new JButton("Search For Vehicle");
    private JButton maintainButton = new JButton("Maintain Vehicle");
    private JButton displayButton = new JButton("Display All Vehicle");

    public HomeFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Design.DIMENSION);
        setLocationRelativeTo(null);
//        setResizable(false);
        setTitle("MIKE GARAGE MANAGEMENT");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(Design.COLOR);

        panel.setBorder(BorderFactory.createEmptyBorder(70, 140,70,140));

        setButtonSettings(addButton);
        setButtonSettings(removeButton);
        setButtonSettings(searchButton);
        setButtonSettings(maintainButton);
        setButtonSettings(displayButton);

        panel.add(Box.createVerticalGlue());
        addButton(panel, addButton, "ADD",false);
        addButton(panel, removeButton, "REMOVE", false);
        addButton(panel, searchButton, "SEARCH", false);
        addButton(panel, maintainButton, "MAINTAIN", false);
        addButton(panel, displayButton, "DISPLAY", true);
        panel.add(Box.createVerticalGlue());


        add(panel);
    }


    private void addButton(JPanel panel, JButton button, String cmd, boolean last) {
        panel.add(button);
        button.setActionCommand(cmd);
        if(!last) panel.add(Box.createVerticalStrut(15));
    }

    private void setButtonSettings(JButton b) {
        b.setBackground(Design.BUTTONS_COLOR);
        b.setForeground(Color.WHITE);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setFont(new Font(Design.FONT, Font.PLAIN, 22));
        b.setPreferredSize(new Dimension(400,50));
        b.setMaximumSize(new Dimension(400,50));
    }

    public void setListener(ActionListener listener) {
        addButton.addActionListener(listener);
        removeButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        maintainButton.addActionListener(listener);
        displayButton.addActionListener(listener);
    }
}
