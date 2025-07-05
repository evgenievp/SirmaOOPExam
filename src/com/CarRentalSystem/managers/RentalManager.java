package com.CarRentalSystem.managers;

import com.CarRentalSystem.Interfaces.Customer;
import com.CarRentalSystem.Interfaces.ManagerInterface;
import com.CarRentalSystem.Services.CarRentalService;

import java.util.Scanner;

public class RentalManager implements ManagerInterface {
    private CarRentalService service;
    private Scanner sc;

    public RentalManager(CarRentalService service, Scanner sc) {
        this.service = service;
        this.sc = sc;
    }

    @Override
    public void addCar() {
        service.addCar();
    }

    @Override
    public void rentCar() {
        service.rentCar();
    }

    @Override
    public void returnCar() {
        service.returnCar();
    }

    @Override
    public void editCar() {
        service.editCar();
    }

    @Override
    public void listCars() {
        service.listCars();
    }

    @Override
    public void searchModelByType(String type) {
        service.searchModelByType(type);
    }

    @Override
    public void removeCar() {
        service.removeCar();
    }

    @Override
    public void addDriver(Customer customer) {
        service.addDriver(customer);
    }

    @Override
    public boolean saveAndExit() {
        return service.saveAndExit();
    }

    @Override
    public boolean execute(int command) {
        switch (command) {
            case 1 -> {
                addCar();
                return true;
            }
            case 2 -> {
                rentCar();
                return true;
            }
            case 3 -> {
                editCar();
                return true;
            }
            case 4 -> {
                listCars();
                return true;
            }
            case 5 -> {
                returnCar();
                return true;
            }
            case 6 -> {
                System.out.println("Enter model of searched car");
                String model = sc.nextLine();
                searchModelByType(model);
                return true;
            }
            case 7 -> {
                removeCar();
                return true;
            }
            default -> {
                saveAndExit();
                return false;
            }
        }
    }

    @Override
    public void displayCommands() {
        service.displayCommands();
    }
}
