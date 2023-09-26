import java.util.*;

class Vehicle {
    private String model;
    private int year;
    private double dailyRate;

    public Vehicle(String model, int year, double dailyRate) {
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private Date startDate;
    private int rentalDays;

    public Rental(Customer customer, Vehicle vehicle, Date startDate, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.rentalDays = rentalDays;
    }

    public double calculateRentalCost() {
        return vehicle.calculateRentalCost(rentalDays);
    }

    public String getRentalDetails() {
        return "Customer: " + customer.getName() +
               "\nVehicle: " + vehicle.getModel() +
               "\nStart Date: " + startDate +
               "\nRental Days: " + rentalDays +
               "\nTotal Cost: $" + calculateRentalCost();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer information
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, email);

        // Ask for vehicle type
        System.out.println("Choose vehicle type:");
        System.out.println("1. 2-Wheeler");
        System.out.println("2. 4-Wheeler");
        int vehicleTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Vehicle> vehicles = new ArrayList<>();

        if (vehicleTypeChoice == 1) {
            // Offer 2-wheeler options
            vehicles.add(new Vehicle("Motorcycle A", 2023, 30.0));
            vehicles.add(new Vehicle("Scooter B", 2023, 25.0));
        } else if (vehicleTypeChoice == 2) {
            // Offer 4-wheeler options
            vehicles.add(new Vehicle("Car A", 2023, 50.0));
            vehicles.add(new ElectricCar("Tesla Model 3", 2023, 75.0, 75));
        } else {
            System.out.println("Invalid choice. Exiting...");
            System.exit(1);
        }

        // Display vehicle options
        System.out.println("Available Vehicles:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getModel());
        }

        // Get user's vehicle choice
        System.out.print("Enter the number of the chosen vehicle: ");
        int vehicleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Vehicle selectedVehicle = vehicles.get(vehicleChoice - 1);

        // Get rental information
        System.out.print("Enter the number of rental days: ");
        int rentalDays = scanner.nextInt();

        // Create a rental
        Rental rental = new Rental(customer, selectedVehicle, new Date(), rentalDays);

        // Display rental details and cost
        System.out.println("\nRental Details:");
        System.out.println(rental.getRentalDetails());

        scanner.close();
    }
}
