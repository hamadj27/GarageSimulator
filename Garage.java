public class Garage {
    private static GarageEquipment equipments;
    private static Vehicle vehicle[];
    private static int numOfVehicles;
    private int maxCapacity;

    public Garage (int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.vehicle = new Vehicle[maxCapacity];
        this.equipments = new GarageEquipment(100);
    }
    public static boolean addVehicle(Vehicle v){
        if(numOfVehicles<vehicle.length){
            vehicle[numOfVehicles++] = v;
            return true;
        }return false;

    }
    public static   boolean removeVehicle(int plateNum){
        for(int i =0;i<numOfVehicles;i++){
            if(plateNum==vehicle[i].getPlateNum()){
                vehicle[i]=vehicle[--numOfVehicles];
                return true;
            }
        }return false;

    }
    public static Vehicle searchVehicle(int plateNum, int i){
        if(i >= numOfVehicles) return  null;
        if(vehicle[i].getPlateNum() == plateNum) return  vehicle[i];

        return searchVehicle(plateNum, i + 1);


    }
    public static boolean maintainVehicle(int plateNum){
        if (searchVehicle(plateNum, 0) != null)  {
            if (equipments.getHealth() < 10) equipments.performMaintenance();
            equipments.use();
            searchVehicle(plateNum, 0).performMaintenance();
            return true;
        }
        return false;
    }

    public static void displayAllVehicle(){
        for(int i = 0; i<numOfVehicles;i++){
            vehicle[i].printInfo();
            System.out.println();
        }
    }
}
