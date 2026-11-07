package cs230project;

import java.util.Scanner;

public class shouq {

    public static void rentVehicle(Vehicle[] vehicles, int count, String name) {
        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (v.getName().equalsIgnoreCase(name) && v.getAvailable()) {
                v.setAvailable(false);
                System.out.println("You have rented: " + v.getBrand() + " " + v.getName());
                return;
            }
        }
        System.out.println("Vehicle is not available or does not exist.");
    }

    public static void returnVehicle(Vehicle[] vehicles, int count, String name) {
        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (v.getName().equalsIgnoreCase(name) && !v.getAvailable()) {
                v.setAvailable(true);
                System.out.println("You have returned: " + v.getBrand() + " " + v.getName());
                return;
            }
        }
        System.out.println("Vehicle was not rented or does not exist.");
    }

    public static void processTask4Menu(Vehicle[] vehicles, int count, Scanner input, String agentChoice) {
        switch (agentChoice) {
            case "4":
                System.out.print("Enter vehicle name to rent: ");
                String rentName = input.nextLine();
                rentVehicle(vehicles, count, rentName);
                break;
            case "5":
                System.out.print("Enter vehicle name to return: ");
                String returnName = input.nextLine();
                returnVehicle(vehicles, count, returnName);
                break;
            default:
                System.out.println("Invalid choice for rental operations.");
        }
    }
}
