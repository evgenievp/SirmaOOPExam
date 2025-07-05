package com.CarRentalSystem.Services;

import com.CarRentalSystem.CSVDrivers.CSVReader;
import com.CarRentalSystem.CSVDrivers.CSVWriter;
import com.CarRentalSystem.Cars.CarModel;
import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.Customer;
import com.CarRentalSystem.Interfaces.ServiceInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService implements ServiceInterface {
    private Scanner sc;
    private CSVWriter writer;
    private CSVReader reader;
    private List<Car> cars;
    private List<Customer> customers;

    public CarRentalService(Scanner sc, CSVReader reader, CSVWriter writer) {
        this.sc = sc;
        this.cars = new LinkedList<>();
        this.customers = new LinkedList<>();
        this.reader = reader;
        this.writer = writer;
    }


    @Override
    public void addCar() {
        System.out.println("Write car model, year of creation and type on three separate lines.");
        String model = sc.nextLine();
        int yearCreated = Integer.parseInt(sc.nextLine());
        String type = sc.nextLine();
        Car car = new CarModel(model, yearCreated, type);
        this.cars.add(car);
        System.out.println("Car added successfully");
    }

    @Override
    public void rentCar() {
        if (this.cars.isEmpty()) {
            System.out.println("You can't rent cars right now.");
        }
        else {
            System.out.println("These are available cars");
            listAvailableCars();
            System.out.println("Write number of car which you would like to rent.");
            int carNum = Integer.parseInt(sc.nextLine());
            if (carNum > this.cars.size() || carNum < 0) {
                System.out.println("Invalid car num");
            }
            else {
                Car wantedCar = this.cars.get(carNum);
                wantedCar.changeStatus();
                System.out.println("you rent a " + wantedCar);
            }
        }
    }

    @Override
    public void returnCar() {

    }

    @Override
    public void editCar() {

    }

    @Override
    public void listCars() {

    }

    @Override
    public Optional<Car> searchModelByType(String type) {
        return Optional.empty();
    }

    @Override
    public void listAvailableCars() {
        int count = 0;
        for (Car car : this.cars) {
            if (car.getStatus().equals("Available")) {
                System.out.println(count + " " + car);
                count ++;
            }
        }
    }

    @Override
    public void removeCar() {

    }

    @Override
    public void addDriver() {

    }

    @Override
    public void saveAndExit() {

    }


    @Override
    public void displayCommands() {
        String commands = """
                --------------------------------------
                Please press key for desired command.
                1. Add a car.
                2. Rent a car.
                3. Edit car.
                4. List all cars.
                5. Return a car.
                6. Search car by model type.
                7. Remove a car.
                8. Add driver.
                9. Save & exit.
                --------------------------------------
                """;
        System.out.println(commands);
    }

    @Override
    public boolean execute(int command) {
        switch (command) {
            case 1: {
                addCar();
                return true;
            }
            case 2: {
                returnCar();
                return true;
            }
        }
        return false;
    }

}
