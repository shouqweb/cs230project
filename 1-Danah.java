import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/** Task 3 searches and client menu using the group's existing Vehicle model. */
public class Danah {
    /** Finds all models containing the supplied text. */
    public static Vehicle[] searchByName(Vehicle[] fleet, int count, String text) {
        return findMatches(fleet, count, text, true);
    }

    /** Finds all manufacturers containing the supplied text. */
    public static Vehicle[] searchByBrand(Vehicle[] fleet, int count, String text) {
        return findMatches(fleet, count, text, false);
    }

    /** Uses the populated array entries and leaves their availability unchanged. */
    private static Vehicle[] findMatches(Vehicle[] fleet, int count,
                                         String text, boolean byName) {
        String key = text == null ? "" : text.trim().toLowerCase(Locale.ROOT);
        if (fleet == null || key.isEmpty()) {
            return new Vehicle[0];
        }
        int limit = Math.min(Math.max(count, 0), fleet.length);
        Vehicle[] matches = new Vehicle[limit];
        int found = 0;
        for (int i = 0; i < limit; i++) {
            Vehicle vehicle = fleet[i];
            if (vehicle == null) {
                continue;
            }
            String field = byName ? vehicle.getName() : vehicle.getBrand();
            if (field != null && field.toLowerCase(Locale.ROOT).contains(key)) {
                matches[found++] = vehicle;
            }
        }
        return Arrays.copyOf(matches, found);
    }

    /** Reuses the main menu's Scanner and returns when the client selects Back. */
    public static void clientMenu(Vehicle[] fleet, int count, Scanner input) {
        while (true) {
            System.out.println("\n--- Client ---");
            System.out.println("1. Search for a Vehicle by name");
            System.out.println("2. Search for a Vehicle by brand");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            if (!input.hasNextLine()) {
                return;
            }
            String choice = input.nextLine().trim();
            if (choice.equals("3")) {
                return;
            }
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Invalid choice. Enter 1, 2, or 3.");
                continue;
            }
            searchAndPrint(fleet, count, input, choice.equals("1"));
        }
    }

    /** Checks the query and displays results with the group's getter names. */
    private static void searchAndPrint(Vehicle[] fleet, int count,
                                       Scanner input, boolean byName) {
        System.out.print(byName ? "Enter vehicle name: " : "Enter brand: ");
        if (!input.hasNextLine()) {
            return;
        }
        String query = input.nextLine().trim();
        if (query.isEmpty()) {
            System.out.println("Search text cannot be empty.");
            return;
        }
        Vehicle[] matches = byName ? searchByName(fleet, count, query)
                : searchByBrand(fleet, count, query);
        if (matches.length == 0) {
            System.out.println("No vehicles matched: " + query);
            return;
        }
        System.out.println("Matches found: " + matches.length);
        for (int i = 0; i < matches.length; i++) {
            Vehicle vehicle = matches[i];
            System.out.printf("%d. %s %s (%d)%n", i + 1,
                    vehicle.getBrand(), vehicle.getName(), vehicle.getYear());
            System.out.printf("Status: %s | Insurance: %s%n",
                    vehicle.getAvailable() ? "Available" : "Rented",
                    vehicle.getInsuranceIncluded() ? "Included" : "Not included");
            System.out.printf(Locale.US, "Daily rate: %.2f%n",
                    vehicle.getDailyRate());
        }
    }
}
