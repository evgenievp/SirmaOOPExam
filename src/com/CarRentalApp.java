package com;
import com.CarRentalSystem.Services.CarRentalService;
import com.CarRentalSystem.managers.RentalManager;

public class CarRentalApp {
    public static void main(String[] args) {

        CarRentalService service = new CarRentalService();
        RentalManager manager = new RentalManager(service);

        System.out.println("Welcome to the Car Rental System");
        displayCommands();

        boolean isRunning = true;
        String command;

        while (isRunning) {
            command = ReadLine();
            isRunning = manager.execute(command);

            // Add Car
            // 1, Toyota Corolla, 2019, Sedan, Available
            // Rent Car
            // 1, John Doe, 2025-06-28
            // Return Car
            // 1
            // Edit 1
            // Toyota Corolla, 2019, Sedan, Rented
            // List Cars
            // Search Model Corolla
            // Remove 1

        }
    }

}

