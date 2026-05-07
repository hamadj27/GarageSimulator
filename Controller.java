import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private HomeFrame homeFrame;
    private InputFrame inputFrame;
    private InfoFrame infoFrame;
    private Garage garage;
    public Controller(HomeFrame homeFrame, Garage garage) {
        this.homeFrame = homeFrame;
        this.garage = garage;

        homeFrame.setListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ADD":
                homeFrame.setVisible(false);
                inputFrame = new InputFrame(this, homeFrame);
                inputFrame.setVisible(true);
                break;
            case "REMOVE":
                try {
                    String plate = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Remove");
                    if(plate == null) return;

                    Vehicle removed = garage.removeVehicle(Integer.parseInt(plate.strip()));
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
                    String target = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Search For");
                    if(target == null) return;

                    Vehicle found = garage.searchVehicle(Integer.parseInt(target.strip()), 0);
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
                    String car = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Maintain");
                    if(car == null) return;

                    Vehicle v = garage.maintainVehicle(Integer.parseInt(car.strip()));
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
                    infoFrame = new InfoFrame(this, garage.displayAllVehicle(), homeFrame);
                    homeFrame.setVisible(false);
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
                            garage.addVehicle(new OffRoadSUV(inputFrame.getBrand(), inputFrame.getColor(), inputFrame.getEngineSize(), inputFrame.getCylinders(), inputFrame.getHP(), inputFrame.getPlate(), inputFrame.getCheckBox(), inputFrame.getOffRoadBox()));

                        homeFrame.setLocation(inputFrame.getLocation());
                        homeFrame.setSize(inputFrame.getSize());
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
                homeFrame.setSize(inputFrame.getSize());
                inputFrame.dispose();
                homeFrame.setVisible(true);
                break;
            case "BACK":
                homeFrame.setLocation(infoFrame.getLocation());
                homeFrame.setSize(infoFrame.getSize());
                infoFrame.dispose();
                homeFrame.setVisible(true);
                break;
        }
    }
}
