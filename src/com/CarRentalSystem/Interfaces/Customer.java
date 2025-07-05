package com.CarRentalSystem.Interfaces;

import java.util.LinkedList;
import java.util.Optional;

public interface Customer extends Data {
    void rentCar(Car car);
    Optional<Car> returnCar();
    void displayRentedCars();
    String toCSV();
    String toString();
    String getUsername();
    String getPassword();
    void changePassword(String password);
    boolean hasCar();
    void setRentedCars(LinkedList<Car> cars);

}
