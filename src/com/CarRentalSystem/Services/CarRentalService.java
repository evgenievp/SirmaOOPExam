package com.CarRentalSystem.Services;

import com.CarRentalSystem.CSVDrivers.CSVReader;
import com.CarRentalSystem.CSVDrivers.CSVWriter;
import com.CarRentalSystem.Cars.CarModel;
import com.CarRentalSystem.Customers.User;
import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.Customer;
import com.CarRentalSystem.Interfaces.ServiceInterface;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService implements ServiceInterface {
    private Scanner sc;
    private CSVWriter writer;
    private CSVReader reader;
    private LinkedList<Car> cars;
    private LinkedList<Customer> customers;
    private User operatingUser = null;

    public CarRentalService(Scanner sc, CSVReader reader, CSVWriter writer) {
        this.sc = sc;
        this.cars = new LinkedList<>();
        this.customers = new LinkedList<>();
        this.reader = reader;
        this.writer = writer;
    }

    public void setUser(User user) {
        this.operatingUser = user;
    }

    public void loadData() {
        customers = reader.getLoadedUsers();
        cars = reader.loadCars();
    }

    public LinkedList<Customer> getCustomers() {
        return this.customers;
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
        } else if (operatingUser.hasCar()) {
            System.out.println("You already have a rented car from us");
        } else {
            System.out.println("These are available cars");
            listAvailableCars();
            System.out.println("Write number of car which you would like to rent.");
            int carNum = Integer.parseInt(sc.nextLine());
            if (carNum > this.cars.size() || carNum < 0) {
                System.out.println("Invalid car num");
            } else {
                Car wantedCar = this.cars.get(carNum);
                wantedCar.changeStatus();
                operatingUser.rentCar(wantedCar);
                System.out.println(this.operatingUser.getUsername() + " rent a " + wantedCar);
            }
        }
    }

    @Override
    public void returnCar() {
        if (operatingUser.hasCar()) {
            this.operatingUser.returnCar();
        }
    }

    @Override
    public void addDriver(Customer customer) {
        this.customers.add(customer);
        this.operatingUser = (User) customer;
    }

    @Override
    public void editCar() {
        listCars();
        System.out.println("Choose car number which you want to edit.");
        int choice = Integer.parseInt(sc.nextLine());
        Car carForEdit = this.cars.get(choice);
        String editingCommands = """
                if you want to edit car model, press 1.
                For editing car year of creation, press 2.
                For editing car type press, 3.
                For editing car status, press 4.
                """;
        System.out.println(editingCommands);
        int editCommand = Integer.parseInt(sc.nextLine());
        switch (editCommand) {
            case 1: {
                System.out.println("Enter new model");
                String newModel = sc.nextLine();
                carForEdit.setModel(newModel);
                break;
            }
            case 2: {
                System.out.println("Enter new year of creation");
                int newYearOfCreation = Integer.parseInt(sc.nextLine());
                carForEdit.setYear(newYearOfCreation);
                break;
            }
            case 3: {
                System.out.println("Enter new type");
                String newType = sc.nextLine();
                carForEdit.setType(newType);
                break;

            }
            default: {
                carForEdit.changeStatus();
                System.out.println("Status changed");
                break;
            }
        }
    }

    @Override
    public void listCars() {
        this.cars = reader.loadCars();
        if (this.cars.size() > 0) {
            int count = 0;
            for (var car : this.cars) {
                System.out.println(count + " " +car);
                count++;
            }
        }
        else {
            System.out.println("Still haven't any cars");
        }
    }

    @Override
    public Optional<Car> searchModelByType(String type) {
        for (var car : this.cars) {
            if (car.getModel().equals(type)) {
                System.out.println(car);
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    @Override
    public void listAvailableCars() {
        int count = 0;
        for (Car car : this.cars) {
            if (car.getStatus().equals("Available")) {
                System.out.println(count + " " + car);
                count++;
            }
        }
    }

    @Override
    public void removeCar() {
        listCars();
        System.out.println("Enter number of car, which will be removed");
        int choice = Integer.parseInt(sc.nextLine());
        Car car = this.cars.get(choice);
        this.cars.remove(choice);
        System.out.println("Car " + car + " has been removed.");
    }


    @Override
    public boolean saveAndExit() {
        writer.saveCars(this.cars);
        writer.saveCustomers(this.customers);
        System.out.print("Saving data");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
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
                8. List available cars.
                9. Save & exit (Sign out).
                --------------------------------------
                """;
        System.out.println(commands);
    }



}
