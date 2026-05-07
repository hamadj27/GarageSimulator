import java.io.*;

public class Garage {
    private File file = new File("data.dat");

    private GarageEquipments equipments;
    private LinkedList<Vehicle> vehicle;

    public Garage () {
        loadData();
    }
    public boolean addVehicle(Vehicle v){
        boolean status = vehicle.addLast(v);
        saveData();
        return status;
    }
    public Vehicle removeVehicle(int plateNum){
        for(int i =0;i<vehicle.getSize();i++){
            Vehicle current = vehicle.get(i);
            if(plateNum==current.getPlateNum()){
                vehicle.removeAt(i);
                saveData();
                return current;
            }
        }return null;

    }
    public Vehicle searchVehicle(int plateNum, int i){
        if(i >= vehicle.getSize()) return  null;
        Vehicle current = vehicle.get(i);
        if(current.getPlateNum() == plateNum) return current;

        return searchVehicle(plateNum, i + 1);


    }
    public Vehicle maintainVehicle(int plateNum) {
        Vehicle targetVehicle = searchVehicle(plateNum, 0);
        if (targetVehicle == null)  return null;
        if (targetVehicle.isReady() == true) throw new VehicleExceptions("Vehicle Already Maintained");

        if (equipments.getHealth() < 10) equipments.performMaintenance();
        equipments.use();
        targetVehicle.performMaintenance();
        saveData();
        return targetVehicle;
    }

    public String displayAllVehicle(){
        String txt = "";
        for(int i = 0; i<vehicle.getSize();i++){
            txt += "Vehicle (" + (i + 1) + "):\n\n" + vehicle.get(i).displayInfo() + (i == vehicle.getSize()-1 ? "" : "\n--------------------------------------------\n");
        } return txt;
    }

    public int getNumOfVehicles() {return vehicle.getSize();}


    private void loadData() {
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



    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(vehicle);
            out.writeObject(equipments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
