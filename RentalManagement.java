import java.util.ArrayList;
import java.util.Scanner;

/**
 * RentalManagement: manages the agency's collection of vehicles.
 * This part: storing vehicles, adding a new vehicle, and
 * displaying available vehicles.
 */
public class RentalManagement {

    // List that stores all vehicles in the agency
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Returns the list (other team members will need it for search/rent/return)
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    // Adds an already-created vehicle (used for sample data)
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    /**
     * Reads vehicle data from the agent and adds a new vehicle.
     * Invalid input is handled with try/catch.
     */
    public void addNewVehicle(Scanner input) {
        try {
            System.out.print("Enter vehicle name: ");
            String name = input.nextLine().trim();

            System.out.print("Enter vehicle brand: ");
            String brand = input.nextLine().trim();

            // Name and brand must not be empty
            if (name.isEmpty() || brand.isEmpty()) {
                System.out.println("Error: name and brand cannot be empty.");
                return;
            }

            System.out.print("Enter manufacturing year: ");
            int year = Integer.parseInt(input.nextLine().trim());
            if (year < 1980 || year > 2027) {
                System.out.println("Error: invalid year.");
                return;
            }

            System.out.print("Is insurance included? (yes/no): ");
            String answer = input.nextLine().trim().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Error: please answer yes or no.");
                return;
            }

            System.out.print("Enter daily rate: ");
            double rate = Double.parseDouble(input.nextLine().trim());
            if (rate <= 0) {
                System.out.println("Error: daily rate must be greater than 0.");
                return;
            }

            // Create the vehicle (available is set to true automatically)
            Vehicle v = new Vehicle(name, brand, year, answer.equals("yes"), rate);

            vehicles.add(v);
            System.out.println("Vehicle added successfully!");

        } catch (NumberFormatException e) {
            // Thrown when the user types letters instead of numbers
            System.out.println("Error: please enter a valid number.");
        }
    }

    /**
     * Displays only the vehicles that are currently available for rent.
     */
    public void displayAvailableVehicles() {
        System.out.println("\n--- Available Vehicles ---");
        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.getAvailable()) {
                System.out.println(v.getBrand() + " " + v.getName()
                        + " | Year: " + v.getYear()
                        + " | Insurance: " + (v.getInsuranceIncluded() ? "Included" : "Not included")
                        + " | Daily rate: " + v.getDailyRate() + " SAR");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles are available right now.");
        }
    }
}