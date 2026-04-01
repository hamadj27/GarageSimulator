public class Garage {
    private GarageEquipments equipments;
    private Vehicle vehicle[];
    private int numOfVehicles = 0;
    

    public Garage (int maxCapacity){
        vehicle = new Vehicle[maxCapacity];
    }
    public boolean addVehicle(Vehicle v){
        if(numOfVehicles<vehicle.length){
            v = vehicle[numOfVehicles++];
            return true;
        }return false;

    }
    public  boolean removeVehicle(int plateNum){
        for(int i =0;i<numOfVehicles;i++){
        if(plateNum==vehicle[i].getPlateNum()){
            vehicle[i]=vehicle[numOfVehicles--];
            return true;
        }
        }return false;

    }
    public Vehicle searchVehicle(int plateNum, int i){
        if(i >= numOfVehicles) return  null;
        if(vehicle[i].getPlateNum() == plateNum) return  vehicle[i];

        return searchVehicle(plateNum, i + 1);


    }
    public void maintainVehicle(int plateNum){
        for(int i = 0; i<numOfVehicles;i++) {
            if (plateNum == vehicle[i].getPlateNum()) {
                if (equipments.getHealth() < 10) {
                    vehicle[i].performMaintenance();
                    ;
                }
            }
        }



        }

    public void displayAllVehicle(){
        for(int i = 0; i<numOfVehicles;i++){
            vehicle[i].printInfo();
        }
    }
}
