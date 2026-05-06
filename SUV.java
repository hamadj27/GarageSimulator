public class SUV extends Vehicle {
    protected boolean isAWD;

    //a constructor to initializes an SUV
    public SUV(String brand, String color, double engineSize, int cylinders, int HP, int plateNum, boolean isAWD) {
        super(brand, color, engineSize, cylinders, HP, plateNum);
        this.isAWD = isAWD;
    }

    //returns the detailed information specific to the SUV
    public String displayInfo() {
        return "Type: SUV\nBrand: " + getBrand() + "\nColor: " + getColor() + "\nAll Wheel Drive?: " + (isAWD ? "Yes" : "No") +
        "\nEngine: " + getEngine().getCylinders() + " Cylinders, " + getEngine().getSize() + "L, " + getEngine().getHP() +
        "hp\nPlate Number: " + getPlateNum() + "\nStatus: [" + (isReady() ? "Ready To Go" : "Not Ready") + "]";
        
    }
}
