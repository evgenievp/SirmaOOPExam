package com.CarRentalSystem.Interfaces;

public interface Car extends Data {
    public String getModel();
    public int getYearCreated();
    public String getStatus();
    public String toString();
    public String toCSV();
    void setModel(String model);
    void setYear(int year);
    void setType(String type);
    void changeStatus();
}
