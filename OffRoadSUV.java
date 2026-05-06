public class OffRoadSUV extends SUV {
    private boolean hasSuspensionKit;

    // a constructor to initializes an Off-Road SUV
    public OffRoadSUV(String brand, String color, double engineSize, int cylinders, int HP, int plateNum, boolean isAWD, boolean hasSuspensionKit) {
        super(brand, color, engineSize, cylinders, HP, plateNum, isAWD);
        this.hasSuspensionKit = hasSuspensionKit;
    }

    //prints the detailed information specific to the Off-Road SUV
    public String printInfo() {
        return "Type: Off-Road SUV\nBrand: " + getBrand() + "\nColor: " + getColor() + "\nAll Wheel Drive?: " + (isAWD ? "Yes" : "No") + "  |  Has Suspention Kit?: " + (hasSuspensionKit ? "Yes" : "No") +
        "\nEngine: " + getEngine().getCylinders() + " Cylinders, " + getEngine().getSize() + "L, " + getEngine().getHP() +
        "hp\nPlate Number: " + getPlateNum() + "\nStatus: [" + (isReady() ? "Ready To Go" : "Not Ready") + "]";
    }
}
