package com.CarRentalSystem.managers;

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

    }

    @Override
    public void rentCar() {

    }

    @Override
    public void returnCar() {

    }

    @Override
    public void editCar() {

    }

    @Override
    public void listCar() {

    }

    @Override
    public void searchModelByType(String type) {

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
    public void listRentableCars() {

    }

    @Override
    public void listSearchableCars() {

    }

    @Override
    public void execute(String command) {

    }

    @Override
    public void displayCommands() {

    }
}
