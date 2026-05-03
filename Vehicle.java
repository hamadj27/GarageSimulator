import java.io.Serializable;
public abstract class Vehicle implements Maintainable, Serializable {
    private String brand;
    private String color;
    private Engine engine;
    private int plateNum;
    private boolean isReady;

    // initializes the common properties of any vehicle 
    public Vehicle(String brand, String color, double engineSize, int cylinders, int HP, int plateNum) {
        try {
            setBrand(brand);
        } catch (Exception e) {
            String correction = "";
            for(int i = 0; i < brand.length(); i++) {
                //remove numbers from brand name
                if(!Character.isDigit(brand.charAt(i))) correction += brand.charAt(i);
            }
            this.brand = correction;
        }

        this.color = color;
        engine = new Engine(engineSize, cylinders, HP);
        this.plateNum = plateNum;
        isReady = false;
    }

    //abstract method to print vehicle details, implemented by child classes
    abstract void printInfo();

    //executes the maintenance process for the vehicle
    public void performMaintenance() {isReady = true;}

    //getters:

    public String getBrand() {return brand;}
    public void setBrand(String brand) throws Exception {
        for(int i = 0; i < brand.length(); i++) {
            if (Character.isDigit(brand.charAt(i))) throw new Exception();
        }
        this.brand = brand;
    }

    public String getColor() {return color;}

    public Engine getEngine() {return engine;}

    public int getPlateNum() {return plateNum;}

    public boolean isReady() {return isReady;}
}