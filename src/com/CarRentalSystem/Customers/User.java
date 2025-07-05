package com.CarRentalSystem.Customers;

import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.Customer;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class User implements Customer {
    private String fName;
    private String lName;
    private String username;
    private String password;
    LocalDateTime dateTime;
    private List<Car> rentedCars;
    private Car rentCar;
    private Customer operatingUser;

    public User(String fName, String lName, String username, String password) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.dateTime = LocalDateTime.now();
        this.rentedCars = new LinkedList<>();
        this.rentCar = null;
    }

    @Override
    public void setRentedCars(LinkedList<Car> cars) {
        this.rentedCars.addAll(cars);
    }

    @Override
    public void rentCar(Car car) {
        if (rentCar == null) {
            this.rentedCars.add(car);
            System.out.println(toString() + " rented car at:" + LocalDateTime.now());
            this.rentCar = car;
        } else {
            System.out.println("Customer already has a car.");
        }
    }

    @Override
    public Optional<Car> returnCar() {
        if (this.rentCar != null) {
            Optional<Car> car = Optional.of(this.rentCar);
            System.out.println(toString() + ", time of returning: " + LocalDateTime.now());
            Car currentCar = car.get();
            currentCar.changeStatus();
            this.rentCar = null;
            return Optional.of(currentCar);
        }
        return Optional.empty();
    }

    public boolean hasCar() {
        if (this.rentCar == null) {
            return false;
        }
        return true;
    }

    public void setCars(Car... cars) {
        this.rentedCars.addAll(Arrays.asList(cars));
    }

    @Override
    public void displayRentedCars() {
        if (this.rentedCars.isEmpty()) {
            System.out.println("Customer has not rented cars already.");
        } else {
            for (Car car : this.rentedCars) {
                System.out.println(car);
            }
        }
    }

    @Override
    public String toString() {
        return fName + " " + lName;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void changePassword(String newPassword) {
        if (!newPassword.equals(this.password)) {
            this.password = newPassword;
        }
    }

    @Override
    public String toCSV() {
        if (!this.rentedCars.isEmpty()) {
            StringBuilder cars = new StringBuilder();
            for (var car : this.rentedCars) {
                cars.append(car.toCSV());
            }
            return this.fName + "," + this.lName + "," + this.username + "," + this.password + "," + cars;
        }
        else {
            return this.fName + "," + this.lName + "," + this.username + "," + this.password;
        }
    }

}
