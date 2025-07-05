package com.CarRentalSystem.managers;

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
    public void addDriver() {
        service.addDriver();
    }

    @Override
    public void saveAndExit() {
        service.saveAndExit();
    }


    @Override
    public boolean execute(int command) {
        return service.execute(command);
    }

    @Override
    public void displayCommands() {
        service.displayCommands();
    }
}
