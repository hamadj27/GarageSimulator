public class GarageEquipments implements Maintainable {
    private int health;

    public GarageEquipments (int health){
        this.health= health;
    }

    public void use(){
        health=-10;
    }

    public void performMaintenance(){
        health=100;
    }

    public int getHealth(){
        return health;
    }

    
}
