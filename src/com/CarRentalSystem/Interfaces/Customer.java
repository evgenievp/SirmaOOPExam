package com.CarRentalSystem.Interfaces;

import java.util.Optional;

public interface Customer {
    void rentCar(Car car);
    Optional<Car> returnCar();
    void displayRentedCars();
    String toCSV();
    String toString();
    String getUsername();
    String getPassword();
    void changePassword(String password);
}
