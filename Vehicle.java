import java.io.Serializable;
public abstract class Vehicle implements Maintainable, Serializable {
    private String brand;
    private String color;
    private Engine engine;
    private int plateNum;
    private boolean isReady;

    // initializes the common properties of any vehicle 
    public Vehicle(String brand, String color, double engineSize, int cylinders, int HP, int plateNum) {
        LinkedList<String> errors = new LinkedList<>();
        setBrand(brand, errors);
        setColor(color, errors);
        engine = new Engine(engineSize, cylinders, HP, errors);
        setPlateNum(plateNum, errors);
        isReady = false;
        if (!errors.isEmpty()) throw new VehicleExceptions(errors);
    }

    //abstract method to print vehicle details, implemented by child classes
    abstract void printInfo();

    //executes the maintenance process for the vehicle
    public void performMaintenance() {isReady = true;}

    //getters:

    public String getBrand() {return brand;}
    private void setBrand(String brand, LinkedList<String> errors) {
        for(int i = 0; i < brand.length(); i++) {
            if(Character.isDigit(brand.charAt(i))) {
                errors.addLast("Brand name cannot contain numbers.");
                return;
            }
        }

        this.brand = brand;
    }

    public String getColor() {return color;}
    private void setColor(String color, LinkedList<String> errors) {
        for(int i = 0; i < color.length(); i++)  {
            if(Character.isDigit(color.charAt(i))) {
                errors.addLast("Color cannot contain numbers."); 
                return;
            }
        }
        
        this.color = color;
}

    public Engine getEngine() {return engine;}

    public int getPlateNum() {return plateNum;}
    private void setPlateNum(int p, LinkedList<String> errors) {
        if (p < 0) errors.addLast("Plate number cannot be negative.");
        else if (p == 0) errors.addLast("Plate number cannot be ZERO.");
        else
        this.plateNum = p;
    }


    public boolean isReady() {return isReady;}
}