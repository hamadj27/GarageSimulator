public class SUV extends Vehicle {
    protected boolean isAWD;

    //a constructor to initializes an SUV
    public SUV(String brand, String color, double engineSize, int cylinders, int HP, int plateNum, boolean isAWD) {
        super(brand, color, engineSize, cylinders, HP, plateNum);
        this.isAWD = isAWD;
    }

    //prints the detailed information specific to the SUV
    void printInfo() {
        System.out.println("Type: SUV  |  Brand: " + getBrand() + "  |  Color: " + getColor() + "  |  All Wheel Drive?: " + (isAWD ? "Yes" : "No") +
        "\nEngine: " + getEngine().getCylinders() + " Cylinders, " + getEngine().getSize() + "L, " + getEngine().getHP() + 
        "hp\nPlate Number: " + getPlateNum() + "  |  Status: [" + (isReady() ? "Ready To Go" : "Not Ready") + "]");
        
    }
}
