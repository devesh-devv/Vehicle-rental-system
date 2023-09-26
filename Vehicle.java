import java.util.Date;

// Base Vehicle class
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

    // Calculate rental cost (polymorphism)
    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }
}

// Inherited class for Electric Cars
class ElectricCar extends Vehicle {
    private int batteryCapacity;

    public ElectricCar(String model, int year, double dailyRate, int batteryCapacity) {
        super(model, year, dailyRate);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
}

// Customer class
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

// Rental class
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
        // Create a customer
        Customer customer = new Customer("John Doe", "john@example.com");

        // Create a vehicle (Electric Car)
        ElectricCar electricCar = new ElectricCar("Tesla Model 3", 2023, 50.0, 75);

        // Create a rental
        Rental rental = new Rental(customer, electricCar, new Date(), 7);

        // Display rental details
        System.out.println(rental.getRentalDetails());
    }
}
