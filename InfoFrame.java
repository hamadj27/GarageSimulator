import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InfoFrame extends JFrame {

    private JLabel title;
    private JTextArea textArea = new JTextArea();
    private JScrollPane scroll = new JScrollPane(textArea);
    private JButton backButton = new JButton("BACK");

    public InfoFrame(ActionListener listener, String info, JFrame reference) {
        setListener(listener);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ALL VEHICLES IN THE GARAGE");
        setSize(reference.getSize());
        setLocation(reference.getLocation());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(Design.COLOR);

        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        title = new JLabel("VEHICLES CURRENTLY IN GARAGE");
        title.setFont(new Font(Design.FONT, Font.BOLD, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Design.TITLE_COLOR);


        textArea.setEditable(false);
        textArea.setFont(new Font(Design.FONT, Font.PLAIN, 22));
        textArea.setMargin(new Insets(8,8,8,8));
        textArea.setText(info);
        textArea.setForeground(Design.TEXTAREA_COLOR);
        textArea.setBackground(Design.SCROLL_COLOR);

        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(Design.BUTTONS_COLOR);
        backButton.setForeground(Design.BUTTONS_TEXTS_COLOR);


        panel.add(title);
        panel.add(Box.createVerticalStrut(7));
        panel.add(scroll);
        panel.add(Box.createVerticalStrut(50));
        panel.add(backButton);
        backButton.setActionCommand("BACK");
        add(panel);
    }

    public void setListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
