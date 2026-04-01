public class Garage {
     private GarageEquipments equipments;
    private Vehicle vehicle[];
    private int numOfVehicles;
    private int maxCapacity;

    public Garage (int maxCapacity){
        this.maxCapacity=maxCapacity;
        vehicle = new Vehicle[maxCapacity];
    }
    public boolean addVehicle(Vehicle v){
        if(numOfVehicles<vehicle.length){
            numOfVehicles++;
            return true;
        }return false;

    }
    public  boolean removeVehicle(int plateNum){
        if(plateNum==getPlateNum){
            numOfVehicles--;
            return true;
        } return false;

    }
    public Vehicle searchVehicle(int plateNum){
        for(int i =0; i<=maxCapacity;i++){
            if(vehicle[i].getPlateNum==plateNum)
                return vehicle[i];
        } return null;


    }
    public void maintainVehicle(int plateNum){
        if(searchVehicle(plateNum)!=null){
            if(Maintainable.)
        }



        }

    public void displayAllVehicle(){
        for(int i = 0; numOfVehicles>=maxCapacity;i++){
            vehicle[i].printInfo();
        }
    }
}
