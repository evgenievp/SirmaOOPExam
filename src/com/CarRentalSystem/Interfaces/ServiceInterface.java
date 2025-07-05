package com.CarRentalSystem.Interfaces;

import java.util.Optional;

public interface ServiceInterface {
    void addCar();
    void rentCar();
    void returnCar();
    void editCar();
    void listCar();
    Optional<Car> searchModelByType(String type);
    void removeCar();
    void addDriver();
    void saveAndExit();
    void listRentableCars();
    void listSearchableCars();




}
