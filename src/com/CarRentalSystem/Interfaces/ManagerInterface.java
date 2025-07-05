package com.CarRentalSystem.Interfaces;

public interface ManagerInterface {
    void addCar();
    void rentCar();
    void returnCar();
    void editCar();
    void listCars();
    void searchModelByType(String type);
    void removeCar();
    void addDriver(Customer customer);
    boolean saveAndExit();
    boolean execute(int command);
    void displayCommands();
    void listAvailableCars();


}
