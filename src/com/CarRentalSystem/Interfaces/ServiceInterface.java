package com.CarRentalSystem.Interfaces;

import java.util.Optional;

public interface ServiceInterface {
    void addCar();
    void rentCar();
    void returnCar();
    void editCar();
    void listCars();
    Optional<Car> searchModelByType(String type);
    void listAvailableCars();
    void removeCar();
    void addDriver();
    void saveAndExit();
    boolean execute(int command);
    void displayCommands();


}
