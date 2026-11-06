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
            
            System.out.println(car1.getName());
            System.out.println(car2.getName());
            System.out.println(car3.getName());
            
            System.out.println(car1.getBrand());
            System.out.println(car1.getAvailable());
            System.out.println(car1.getYear());
            System.out.println(car1.getInsuranceIncluded());
            System.out.println(car1.getDailyRate());
            car1.setBrand("Nissan");
            System.out.println(car1.getBrand());
            car1.setAvailable(false);
            System.out.println(car1.getAvailable());
            car1.setYear(2025);
            System.out.println(car1.getYear());
            car1.setInsuranceIncluded(false);
            System.out.println(car1.getInsuranceIncluded());
            car1.setDailyRate(200.0);
           System.out.println(car1.getDailyRate());
    }
}
