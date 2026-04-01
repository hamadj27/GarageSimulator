public class Garage {
    private GarageEquipments equipments;
    private Vehicle vehicle[];
    private int numOfVehicles;

    public Garage (int maxCapacity){
        this.vehicle = new Vehicle[maxCapacity];
        numOfVehicles = 0;
    }
    public boolean addVehicle(Vehicle v){
        if(numOfVehicles<vehicle.length){
            vehicle[numOfVehicles++] = v;
            return true;
        }return false;

    }
    public boolean removeVehicle(int plateNum){
        for(int i =0;i<numOfVehicles;i++){
            if(plateNum==vehicle[i].getPlateNum()){
                vehicle[i]=vehicle[numOfVehicles - 1];
                vehicle[--numOfVehicles] = null;
                return true;
            }
        }return false;

    }
    public Vehicle searchVehicle(int plateNum, int i){
        if(i >= numOfVehicles) return  null;
        if(vehicle[i].getPlateNum() == plateNum) return  vehicle[i];

        return searchVehicle(plateNum, i + 1);


    }
    public boolean maintainVehicle(int plateNum){
        if (searchVehicle(plateNum, 0) != null)  {
            if (equipments.getHealth() < 10) equipments.performMaintenance();
            equipments.use();
            searchVehicle(plateNum, 0).performMaintenance();
            return true;
        }
        return false;
    }

    public void displayAllVehicle(){
        for(int i = 0; i<numOfVehicles;i++){
            vehicle[i].printInfo();
            System.out.println();
        }
    }
}
