import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Garage MikeGarage = new Garage(10);

        System.out.println("WELCOME TO MIKE GARAGE ");

        boolean exit = true;
        while (exit) {
            System.out.println("=============================================");
            System.out.println("--- Mike Garage Management System ---");
            System.out.println("Choose an option (1-6): ");
            System.out.println("1. Add a Vehicle");
            System.out.println("2. Remove a Vehicle");
            System.out.println("3. Search for a Vehicle");
            System.out.println("4. Maintain a Vehicle");
            System.out.println("5. Display All Vehicles");
            System.out.println("6. Exit");
            System.out.println("ENTER YOUR CHOICE HERE: ");

            int c = in.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Select Vehicle Type:");
                    System.out.println("1. Sedan");
                    System.out.println("2. SUV");
                    System.out.println("3. Off-Road SUV");
                    System.out.print("Choice: ");
                    int ty = in.nextInt();

                    in.nextLine(); // Consume the leftover newline
                    System.out.print("Brand: ");
                    String brand = in.nextLine();
                    System.out.print("Color: ");
                    String color = in.nextLine();
                    System.out.print("Engine Size (L): ");
                    double engineSize = in.nextDouble();
                    System.out.print("Cylinders: ");
                    int cylinders = in.nextInt();
                    System.out.print("Horsepower: ");
                    int hp = in.nextInt();
                    System.out.print("Plate Number: ");
                    int plateNum = in.nextInt();

                    Vehicle newVehicle = null;

                    if (ty == 1) {
                        System.out.print("Is it lowered? (true/false): ");
                        boolean isLowered = in.nextBoolean();
                        newVehicle = new Sedan(brand, color, engineSize, cylinders, hp, plateNum, isLowered);
                    } else if (ty == 2) {
                        System.out.print("Is it AWD? (true/false): ");
                        boolean isAWD = in.nextBoolean();
                        newVehicle = new SUV(brand, color, engineSize, cylinders, hp, plateNum, isAWD);
                    } else if (ty == 3) {
                        System.out.print("Is it AWD? (true/false): ");
                        boolean isAWD = in.nextBoolean();
                        System.out.print("Has suspension kit? (true/false): ");
                        boolean hasSuspension = in.nextBoolean();
                        newVehicle = new OffRoadSUV(brand, color, engineSize, cylinders, hp, plateNum, isAWD, hasSuspension);
                    } else {
                        System.out.println("Invalid vehicle type selected.");
                        break;
                    }
                    if (Garage.addVehicle(newVehicle)) {
                        System.out.println("Vehicle successfully added to the garage!");

                    } else {
                        System.out.println("Failed to add vehicle. The garage might be full.");

                    }
                    break;

                case 2:
                    System.out.print("Enter Plate Number of the vehicle to remove: ");
                    int removePlate = in.nextInt();
                    if (Garage.removeVehicle(removePlate)) {
                        System.out.println("Vehicle removed successfully!");

                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Plate Number to search: ");
                    int sP = in.nextInt();
                    Vehicle foundVehicle = Garage.searchVehicle(sP, 0);
                    if (foundVehicle != null) {
                        System.out.println("--- Vehicle Found ---");
                        foundVehicle.printInfo();
                    } else {
                        System.out.println("Vehicle not found in the garage.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Plate Number to perform maintenance: ");
                    int mP = in.nextInt();
                    Garage.maintainVehicle(mP);
                    System.out.println("Maintenance routine executed.");
                    break;
                case 5:
                    System.out.println("--- Vehicles currently in Garage ---");
                    Garage.displayAllVehicle();
                    break;
                case 6:
                    System.out.println("THANKS FOR VISITING MIKE GARAGE");
                    exit = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

        }

      }

    }
