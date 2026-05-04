import java.io.*;

public class Garage {
    private File file = new File("data.dat");

    private GarageEquipments equipments;
    private LinkedList<Vehicle> vehicle;

    public Garage () {
        loadDataFromFile();
    }
    public boolean addVehicle(Vehicle v){
        boolean status = vehicle.addLast(v);
        saveDataToFile();
        return status;
    }
    public boolean removeVehicle(int plateNum){
        for(int i =0;i<vehicle.getSize();i++){
            if(plateNum==vehicle.get(i).getPlateNum()){
                vehicle.removeAt(i);
                saveDataToFile();
                return true;
            }
        }return false;

    }
    public Vehicle searchVehicle(int plateNum, int i){
        if(i >= vehicle.getSize()) return  null;
        Vehicle current = vehicle.get(i);
        if(current.getPlateNum() == plateNum) return current;

        return searchVehicle(plateNum, i + 1);


    }
    public boolean maintainVehicle(int plateNum){
        Vehicle targetVehicle = searchVehicle(plateNum, 0);
        if (targetVehicle != null)  {
            if (equipments.getHealth() < 10) equipments.performMaintenance();
            equipments.use();
            targetVehicle.performMaintenance();
            saveDataToFile();
            return true;
        }
        return false;
    }

    public void displayAllVehicle(){
        for(int i = 0; i<vehicle.getSize();i++){
            vehicle.get(i).printInfo();
            System.out.println();
        }
    }

    public int getNumOfVehicles() {return vehicle.getSize();}


    private void loadDataFromFile() {
        if(!file.exists()) {
            vehicle = new LinkedList<>();
            equipments = new GarageEquipments();
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            vehicle = (LinkedList<Vehicle>) in.readObject();
            equipments = (GarageEquipments) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            vehicle = new LinkedList<>();
            equipments = new GarageEquipments();
        }
    }



    private void saveDataToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(vehicle);
            out.writeObject(equipments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
