package cs230project;

import java.util.Scanner;

public class shouq {

    // Task 4: Rent Vehicle Logic (Moussa Academy Style)
    public static void rentVehicle(Vehicle[] vehicles, int count, String name) {
        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (v.getName().equalsIgnoreCase(name) && v.isAvailable()) {
                v.setAvailable(false);
                System.out.println("You have rented: " + v.getBrand() + " " + v.getName());
                return;
            }
        }
        System.out.println("Vehicle is not available or does not exist.");
    }

    // Task 4: Return Vehicle Logic (Moussa Academy Style)
    public static void returnVehicle(Vehicle[] vehicles, int count, String name) {
        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            if (v.getName().equalsIgnoreCase(name) && !v.isAvailable()) {
                v.setAvailable(true);
                System.out.println("You have returned: " + v.getBrand() + " " + v.getName());
                return;
            }
        }
        System.out.println("Vehicle was not rented or does not exist.");
    }

    // Task 4: Agent Menu Cases (Case 4 & Case 5)
    public static void processTask4Menu(RentalManagement rental, Scanner input, String agentChoice) {
        switch (agentChoice) {
            case "4":
                System.out.print("Enter vehicle name to rent: ");
                String rentName = input.nextLine();
                rental.rentVehicle(rentName);
                break;
            case "5":
                System.out.print("Enter vehicle name to return: ");
                String returnName = input.nextLine();
                rental.returnVehicle(returnName);
                break;
        }
    }
}
