package com.CarRentalSystem.Cars;

import com.CarRentalSystem.Interfaces.Car;

public class CarModel implements Car {
    private String carModel;
    private String status;
    private int yearCreated;
    private String type;

    public CarModel(String carModel, int yearCreated, String type) {
        this.carModel = carModel;
        this.yearCreated = yearCreated;
        this.type = type;
        this.status = "Available";
    }

    public CarModel(String carModel, int yearCreated, String type, String status) {
        this(carModel, yearCreated, type);
        this.status = status;
    }


    @Override
    public String getModel() {
        return this.carModel;
    }

    @Override
    public int getYearCreated() {
        return this.yearCreated;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return this.carModel + " " + this.yearCreated + " " + this.type + " " + this.status;
    }

    @Override
    public String toCSV() {
        return carModel + ";" + yearCreated + ";" + type + ";" + status + ",";
    }

    @Override
    public void setModel(String model) {
        this.carModel = model;
    }

    @Override
    public void setYear(int year) {
        this.yearCreated = year;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void changeStatus() {
        if (this.status.equals("Available")) {
            this.status = "Not Available";
        }
        else {
            this.status = "Available";
        }
    }



}
