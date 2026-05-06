import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame {
    private final String[] types = {"Sedan", "SUV", "Off-Road SUV"};
    private JComboBox<String> typeIn = new JComboBox<>(types);

    private JTextField brandIn = new JTextField(50);

    private JTextField colorIn = new JTextField();

    private JTextField engineSizeIn = new JTextField();

    private JTextField cylindersIn = new JTextField();

    private JTextField hpIn = new JTextField();

    private JTextField plateIn = new JTextField();


    private JCheckBox checkBox = new JCheckBox();
    private final String sedanText = "Is Lowered?";
    private final String SUVText = "Is FOUR-WHEEL-DRIVE?";
    private final String offRoadText = "Has Suspention Kit?";


    JButton saveButton = new JButton("SAVE");
    JButton cancelButton = new JButton("CANCEL");



    public InputFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Design.DIMENSION);
        setLocationRelativeTo(null);
//        setResizable(false);
        setTitle("ADD A VEHICLE");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(70, 140,70,140));

        typeIn.setActionCommand("TYPE");
        typeIn.setFont(new Font(Design.FONT, Font.PLAIN, 15));
        typeIn.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(typeIn);
        mainPanel.add(Box.createVerticalStrut(30));


        addField(mainPanel, brandIn, "Enter Brand Name");
        addField(mainPanel, colorIn, "Enter Color Name");
        addField(mainPanel, engineSizeIn, "Enter Engine Size (L)");
        addField(mainPanel, cylindersIn, "Enter Engine Cylinders Number");
        addField(mainPanel, hpIn, "Enter Engine Horsepower");
        addField(mainPanel, plateIn, "Enter Plate Number (NUMBERS ONLY)");



        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        saveButton.setActionCommand("SAVE");
        cancelButton.setActionCommand("CANCEL");


        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
        buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        checkBox.setFont(new Font(Design.FONT, Font.PLAIN, 17));
        checkBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkBox.setText(sedanText);
        mainPanel.add(checkBox);
        mainPanel.add(Box.createVerticalStrut(30));

        mainPanel.add(buttonsPanel);


        add(mainPanel);

    }

    public void addField(JPanel panel, JTextField field, String text) {

        JLabel label = new JLabel(text);
        label.setFont(new Font(Design.FONT, Font.PLAIN, 17));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        field.setFont(new Font("Courier New", Font.PLAIN, 16));

        panel.add(label);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);

        panel.add(Box.createVerticalStrut(30));
    }


    public void setListener(ActionListener listener) {
        typeIn.addActionListener(listener);
        saveButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
    }

    public void updateTypeFields(String selected) {
        if (selected.equals("Sedan")) checkBox.setText(sedanText);
        else if (selected.equals("SUV")) checkBox.setText(SUVText);
        else if (selected.equals("Off-Road SUV")) checkBox.setText(offRoadText);
        checkBox.setSelected(false);
    }

    public String getActiveType() {
        return switch(checkBox.getText()) {
            case sedanText -> "sedan";
            case SUVText -> "suv";
            case offRoadText -> "offRoad";
            default -> null;
        };
    }


    public String getBrand() {return brandIn.getText();}
    public String getColor() {return colorIn.getText();}
    public double getEngineSize() throws NumberFormatException {return Double.parseDouble(engineSizeIn.getText());}
    public int getCylinders() throws NumberFormatException {return Integer.parseInt(cylindersIn.getText());}
    public int getHP() throws NumberFormatException {return Integer.parseInt(hpIn.getText());}
    public int getPlate() throws NumberFormatException {return Integer.parseInt(plateIn.getText());}
    public boolean getCheckBox() {return checkBox.isSelected();}

}
