import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private HomeFrame homeFrame;
    private InputFrame inputFrame;
    private InfoFrame infoFrame;
    private Garage garage;
    public Controller(HomeFrame homeFrame, InputFrame inputFrame, InfoFrame infoFrame, Garage garage) {
        this.homeFrame = homeFrame;
        this.inputFrame = inputFrame;
        this.infoFrame = infoFrame;
        this.garage = garage;

        homeFrame.setListener(this);
        inputFrame.setListener(this);
        infoFrame.setListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ADD":
                homeFrame.setVisible(false);
                inputFrame.setLocation(homeFrame.getLocation());
                inputFrame.setVisible(true);
                break;
            case "REMOVE":
                try {
                    String plate = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Remove").strip();
                    Vehicle removed = garage.removeVehicle(Integer.parseInt(plate));
                    if (removed != null)
                        JOptionPane.showMessageDialog(homeFrame, removed.getBrand() + " Have Been Removed Successfully");
                    else
                        JOptionPane.showMessageDialog(homeFrame, "No Car Found With" + (plate.length() > 4 ? " That Plate Number" :" A Plate Number [" + plate + "]"),"ERROR", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(homeFrame, "Plate Number Should contain Only NUMBERS","ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "SEARCH":
                try {
                    String target = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Search For").strip();

                    Vehicle found = garage.searchVehicle(Integer.parseInt(target), 0);
                    if (found == null) {
                        JOptionPane.showMessageDialog(homeFrame,"No Car Found With" + (target.length() > 4 ? " That Plate Number" :" A Plate Number [" + target + "]"),"ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(homeFrame, found.displayInfo());
                    }
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(homeFrame, "Plate Number Should contain Only NUMBERS","ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "MAINTAIN":
                try {
                    String car = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Maintain").strip();

                    Vehicle v = garage.maintainVehicle(Integer.parseInt(car));
                    if (v == null) {
                        JOptionPane.showMessageDialog(homeFrame, "No Car Found With" + (car.length() > 4 ? " That Plate Number" :" A Plate Number [" + car + "]"), "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(homeFrame,v.getBrand() + " Maintained Successfully");
                    }
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(homeFrame, "Plate Number Should contain Only NUMBERS", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (VehicleExceptions err) {
                    JOptionPane.showMessageDialog(homeFrame, err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "DISPLAY":
                if (garage.getNumOfVehicles() <= 0) JOptionPane.showMessageDialog(homeFrame, "There Are No Vehicles In The Garage To Display","ERROR", JOptionPane.ERROR_MESSAGE);
                else {
                    infoFrame.setInfo(garage.displayAllVehicle());
                    homeFrame.setVisible(false);
                    infoFrame.setLocation(homeFrame.getLocation());
                    infoFrame.setVisible(true);
                }
                break;
            case "TYPE":
                inputFrame.updateTypeFields((String)(((JComboBox<String>)e.getSource()).getSelectedItem()));

                break;
            case "SAVE":
                    try {
                        if (inputFrame.getActiveType() == "sedan")
                            garage.addVehicle(new Sedan(inputFrame.getBrand(), inputFrame.getColor(), inputFrame.getEngineSize(), inputFrame.getCylinders(), inputFrame.getHP(), inputFrame.getPlate(), inputFrame.getCheckBox()));
                        else if (inputFrame.getActiveType() == "suv")
                            garage.addVehicle(new SUV(inputFrame.getBrand(), inputFrame.getColor(), inputFrame.getEngineSize(), inputFrame.getCylinders(), inputFrame.getHP(), inputFrame.getPlate(), inputFrame.getCheckBox()));
                        else if (inputFrame.getActiveType() == "offRoad")
                            garage.addVehicle(new Sedan(inputFrame.getBrand(), inputFrame.getColor(), inputFrame.getEngineSize(), inputFrame.getCylinders(), inputFrame.getHP(), inputFrame.getPlate(), inputFrame.getCheckBox()));

                        homeFrame.setLocation(inputFrame.getLocation());
                        inputFrame.dispose();
                        homeFrame.setVisible(true);
                        JOptionPane.showMessageDialog(homeFrame, inputFrame.getBrand() + " Added To The Garage Successfully");
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(inputFrame, "ERROR: " + err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    } catch (VehicleExceptions err) {
                        String errRepresnt = "";
                        for(int i = 0; i < err.getErrors().getSize(); i++) errRepresnt += err.getErrors().get(i) + (i == err.getErrors().getSize()-1 ? "": "\n");
                        JOptionPane.showMessageDialog(inputFrame, "ERROR(s):\n" + errRepresnt, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case "CANCEL":
                homeFrame.setLocation(inputFrame.getLocation());
                inputFrame.dispose();
                homeFrame.setVisible(true);
                break;
            case "BACK":
                homeFrame.setLocation(infoFrame.getLocation());
                infoFrame.dispose();
                homeFrame.setVisible(true);
                break;
        }
    }
}
