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
    }


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ADD":
                homeFrame.setVisible(false);
                inputFrame.setVisible(true);
                break;
            case "REMOVE":
                String plate = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Remove");
                Vehicle removed = garage.removeVehicle(Integer.parseInt(plate));
                if(removed != null)
                JOptionPane.showMessageDialog(homeFrame, removed.getBrand() + " Have Been Removed Successfully");
                else JOptionPane.showMessageDialog(homeFrame, "No Car Found With A Plate Number [" + plate + "]");
                break;
            case "SEARCH":
                String target = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Search For");

                garage.searchVehicle(Integer.parseInt(target), 0);
                break;
            case "MAINTAIN":
                String car = JOptionPane.showInputDialog("Please Enter The Vehicle Plate Number To Maintain");

                garage.maintainVehicle(Integer.parseInt(car));
                break;
            case "DISPLAY":
                if (garage.getNumOfVehicles() <= 0) JOptionPane.showMessageDialog(homeFrame, "There Are No Vehicles In The Garage To Display");
                else {
                    infoFrame.setInfo(garage.displayAllVehicle());
                    homeFrame.setVisible(false);
                    infoFrame.setVisible(true);
                }
                break;
            case "TYPE":
                inputFrame.updateTypeFields((String)(((JComboBox<String>)e.getSource()).getSelectedItem()));

                break;
            case "SAVE":

                break;
            case "CANCEL":
                inputFrame.dispose();
                homeFrame.setVisible(true);
                break;
            case "BACK":
                infoFrame.dispose();
                homeFrame.setVisible(true);
                break;
        }
    }
}
