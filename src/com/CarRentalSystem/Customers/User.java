package com.CarRentalSystem.Customers;

import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.Customer;

import java.time.LocalDateTime;
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
    public void rentCar(Car car) {
        if (rentCar == null) {
            this.rentedCars.add(car);
            System.out.println(toString() + "," + LocalDateTime.now());
            this.rentCar = car;
        }
        else {
            System.out.println("Customer already has a car.");
        }
    }

    @Override
    public Optional<Car> returnCar() {
        if (this.rentCar != null) {
            Optional<Car> car = Optional.of(this.rentCar);
            System.out.println(toString() + "," + LocalDateTime.now());
            this.rentCar = null;
            return car;
        }
        return Optional.empty();
    }

    @Override
    public void displayRentedCars() {
        if (this.rentedCars.isEmpty()) {
            System.out.println("Customer has not rented cars already.");
        }
        else {
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
    public String toCSV(){
        String CSVCars = String.join("," , this.rentedCars.toString());
        return this.fName +"," + this.lName + "," + rentedCars;
    }
}
