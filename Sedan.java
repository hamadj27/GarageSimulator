public class Sedan extends Vehicle {
    private boolean isLowered;

    //a constructor to initializes a Sedan car
    public Sedan(String brand, String color, double engineSize, int cylinders, int HP, int plateNum, boolean isLowered) {
        super(brand, color, engineSize, cylinders, HP, plateNum);
        this.isLowered = isLowered;
    }

    //returns the detailed information specific to the Sedan
    public String displayInfo() {
        return "Type: Sedan\nBrand: " + getBrand() + "\nColor: " + getColor() + "\nIs Lowered?: " + (isLowered ? "Yes" : "No") +
        "\nEngine: " + getEngine().getCylinders() + " Cylinders, " + getEngine().getSize() + "L, " + getEngine().getHP() +
        "hp\nPlate Number: " + getPlateNum() + "\nStatus: [" + (isReady() ? "Ready To Go" : "Not Ready") + "]";
        
    }
}
