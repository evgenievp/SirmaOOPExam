package com.CarRentalSystem.Interfaces;

public interface ManagerInterface {
    void addCar();
    void rentCar();
    void returnCar();
    void editCar();
    void listCars();
    void searchModelByType(String type);
    void removeCar();
    void addDriver();
    void saveAndExit();
    boolean execute(int command);
    void displayCommands();


}
