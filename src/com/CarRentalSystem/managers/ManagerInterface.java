package com.CarRentalSystem.managers;

import com.CarRentalSystem.Interfaces.Car;

import java.util.Optional;

public interface ManagerInterface {
    void addCar();
    void rentCar();
    void returnCar();
    void editCar();
    void listCar();
    void searchModelByType(String type);
    void removeCar();
    void addDriver();
    void saveAndExit();
    void listRentableCars();
    void listSearchableCars();
    void execute();
    void displayCommands();


}
