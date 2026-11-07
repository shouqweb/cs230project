class Vehicle {
    //Vehicle info variables
    private String name;
    private String brand;
    private boolean available;
    private int year;
    private boolean insuranceIncluded;
    private double dailyRate;
    //Constructor to set the info and make it available by default
    public Vehicle(String name, String brand, int year,
                    boolean insuranceIncluded, double dailyRate) {
    this.name = name;
    this.brand = brand;
    this.year = year;
    this.insuranceIncluded = insuranceIncluded;
    this.dailyRate = dailyRate;
    this.available = true;
    }
    //Getters to get the values
    public String getName() {
        return name;
    }
    //Setters to update the values
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public boolean getAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public boolean getInsuranceIncluded() {
        return insuranceIncluded;
    }
    public void setInsuranceIncluded(boolean insuranceIncluded) {
        this.insuranceIncluded = insuranceIncluded;
    }
    public double getDailyRate() {
        return dailyRate;
    }
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }
    
}
class Main {
    public static void main(String[] args) {
        
        Vehicle car1 = new Vehicle(
            "Camry", "Toyota", 2022, true, 150.0
            );
            Vehicle car2 = new Vehicle(
            "Taurus", "Ford", 2023, false, 120.0
            );
            Vehicle car3 = new Vehicle(
           "Accord", "Honda", 2024, true, 180.0
            );
            
            System.out.println("===== Car 1 =====");
            System.out.println("Name: " + car1.getName());
            System.out.println("Brand: " + car1.getBrand());
            System.out.println("Available: " + car1.getAvailable());
            System.out.println("Year: " + car1.getYear());
            System.out.println("Insurance: " + car1.getInsuranceIncluded());
            System.out.println("Daily Rate: " + car1.getDailyRate());
            
            System.out.println("===== Car 2 =====");
            System.out.println("Name: " + car2.getName());
            System.out.println("Brand: " + car2.getBrand());
            System.out.println("Available: " + car2.getAvailable());
            System.out.println("Year: " + car2.getYear());
            System.out.println("Insurance: " + car2.getInsuranceIncluded());
            System.out.println("Daily Rate: " + car2.getDailyRate());
            
            System.out.println("===== Car 3 =====");
            System.out.println("Name: " + car3.getName());
            System.out.println("Brand: " + car3.getBrand());
            System.out.println("Available: " + car3.getAvailable());
            System.out.println("Year: " + car3.getYear());
            System.out.println("Insurance: " + car3.getInsuranceIncluded());
            System.out.println("Daily Rate: " + car3.getDailyRate());
            
            System.out.println("===== Testing Setters =====");
            
            car1.setBrand("Nissan");
            car1.setAvailable(false);
            car1.setYear(2025);
            car1.setInsuranceIncluded(false);
            car1.setDailyRate(200.0);
            
            System.out.println("Update Brand: " + car1.getBrand());
            System.out.println("Update Available: " + car1.getAvailable());
            System.out.println("Update Year: " + car1.getYear());
            System.out.println("Update Insurance: " + car1.getInsuranceIncluded());
            System.out.println("Update Daily Rate: " + car1.getDailyRate());
            Vehicle[] vehicles = {car1, car2, car3};
java.util.Scanner input = new java.util.Scanner(System.in);

while (true) {
    System.out.println("\n=== Main Menu ===");
    System.out.println("1. Client Search");
    System.out.println("2. Rent Vehicle");
    System.out.println("3. Return Vehicle");
    System.out.println("4. Exit");
    System.out.print("Enter choice: ");

    if (!input.hasNextLine()) {
        break;
    }

    String choice = input.nextLine().trim();

    switch (choice) {
        case "1":
            Danah.clientMenu(vehicles, vehicles.length, input);
            break;

        case "2":
            shouq.processTask4Menu(
                vehicles, vehicles.length, input, "4");
            break;

        case "3":
            shouq.processTask4Menu(
                vehicles, vehicles.length, input, "5");
            break;

        case "4":
            return;

        default:
            System.out.println("Invalid choice.");
    }
}    
    }
}
