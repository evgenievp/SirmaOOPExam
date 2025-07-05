package com;
import com.CarRentalSystem.Services.CarRentalService;
import com.CarRentalSystem.managers.RentalManager;
import com.CarRentalSystem.utils.RandomClass;

import java.util.Scanner;

public class CarRentalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarRentalService service = new CarRentalService(sc);
        RentalManager manager = new RentalManager(service, sc);

        System.out.println("Welcome to the Car Rental System");
        manager.displayCommands();

        boolean isRunning = true;
        String command;

        while (isRunning) {
            command = sc.nextLine();
            isRunning = manager.execute(command);
            System.out.println("Press anykey to see again commands.");
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

