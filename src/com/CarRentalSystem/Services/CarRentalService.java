package com.CarRentalSystem.Services;

import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.ServiceInterface;

import java.util.Optional;
import java.util.Scanner;

public class CarRentalService implements ServiceInterface {
    private Scanner sc;
    public CarRentalService(Scanner sc) {
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
    public Optional<Car> searchModelByType(String type) {
        return Optional.empty();
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
}
