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

    private JCheckBox offRoadBox = new JCheckBox();


    JButton saveButton = new JButton("SAVE");
    JButton cancelButton = new JButton("CANCEL");


    JPanel mainPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    public InputFrame(ActionListener listener, JFrame reference) {
        setListener(listener);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(reference.getSize());
        setLocation(reference.getLocation());
        setTitle("ADD A VEHICLE");

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



        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        saveButton.setActionCommand("SAVE");
        saveButton.setBackground(Design.BUTTONS_COLOR);
        saveButton.setForeground(Design.BUTTONS_TEXTS_COLOR);
        cancelButton.setActionCommand("CANCEL");
        cancelButton.setBackground(Design.BUTTONS_COLOR);
        cancelButton.setForeground(Design.BUTTONS_TEXTS_COLOR);



        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
        buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        addCheckBox(mainPanel, checkBox, sedanText, true);
        addCheckBox(mainPanel,offRoadBox, offRoadText, false);


        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(buttonsPanel);


        add(mainPanel);

        setColor(Design.COLOR);
    }

    public void addField(JPanel panel, JTextField field, String text) {

        JLabel label = new JLabel(text);
        label.setForeground(Design.TEXTS_COLOR);
        label.setFont(new Font(Design.FONT, Font.PLAIN, 17));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setBackground(Design.BUTTONS_COLOR);
        field.setForeground(Design.BUTTONS_TEXTS_COLOR);
        field.setCaretColor(Design.BUTTONS_TEXTS_COLOR);
        field.setMargin(new Insets(0,5,0,5));
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
        if (selected.equals("Sedan")) {
            checkBox.setText(sedanText);
            hideCheckBox(offRoadBox);
        }
        else if (selected.equals("SUV")) {
            checkBox.setText(SUVText);
            hideCheckBox(offRoadBox);
        }
        else if (selected.equals("Off-Road SUV")) {
            checkBox.setText(SUVText);
            showCheckBox(offRoadBox);
        }
        checkBox.setSelected(false);
        offRoadBox.setSelected(false);
    }

    public String getActiveType() {
        return switch(checkBox.getText()) {
            case sedanText -> "sedan";
            case SUVText -> offRoadBox.isVisible() ? "offRoad": "suv";
            default -> null;
        };
    }

    private void addCheckBox(JPanel panel, JCheckBox box, String text, boolean visible) {
        box.setFont(new Font(Design.FONT, Font.PLAIN, 17));
        box.setForeground(Design.TEXTS_COLOR);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.setText(text);
        panel.add(box);
        panel.add(Box.createVerticalStrut(5));
        if(!visible) box.setVisible(false);
    }

    private void showCheckBox(JCheckBox box) {
        box.setVisible(true);
    }
    private void hideCheckBox(JCheckBox box) {
        box.setVisible(false);
    }



    private void setColor(Color color) {
        mainPanel.setBackground(color);
        buttonsPanel.setBackground(color);
        checkBox.setBackground(color);
        offRoadBox.setBackground(color);
    }

    public String getBrand() {return brandIn.getText();}
    public String getColor() {return colorIn.getText();}
    public double getEngineSize() throws NumberFormatException {return Double.parseDouble(engineSizeIn.getText());}
    public int getCylinders() throws NumberFormatException {return Integer.parseInt(cylindersIn.getText());}
    public int getHP() throws NumberFormatException {return Integer.parseInt(hpIn.getText());}
    public int getPlate() throws NumberFormatException {return Integer.parseInt(plateIn.getText());}
    public boolean getCheckBox() {return checkBox.isSelected();}
    public boolean getOffRoadBox() {return offRoadBox.isSelected();}

}
