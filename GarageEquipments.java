import java.io.Serializable;

public class GarageEquipments implements Maintainable, Serializable {
    private int health;

    public GarageEquipments (){
        health = 100;
    }

    // use the equipment and reduce health
    public void use(){
        health-=10;
    }

    // restore equipment health back to full
    public void performMaintenance(){
        health=100;
    }

    // get current equipment health
    public int getHealth(){
        return health;
    }

    
}
