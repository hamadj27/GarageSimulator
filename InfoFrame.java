import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InfoFrame extends JFrame {

    private JLabel title;
    private JTextArea textArea = new JTextArea();
    private JScrollPane scroll = new JScrollPane(textArea);
    private JButton backButton = new JButton("BACK");

    private String info;

    public InfoFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Design.DIMENSION);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        title = new JLabel("VEHICLE CURRENTLY IN GARAGE");
        title.setFont(new Font(Design.FONT, Font.BOLD, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        textArea.setEditable(false);
        textArea.setFont(new Font(Design.FONT, Font.PLAIN, 18));
        textArea.setText(info);

        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setFont(new Font("Arial", Font.PLAIN, 17));


        panel.add(title);
        panel.add(Box.createVerticalStrut(5));
        panel.add(scroll);
        panel.add(Box.createVerticalStrut(50));
        panel.add(backButton);
        backButton.setActionCommand("BACK");
        add(panel);

    }

    public void setListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
