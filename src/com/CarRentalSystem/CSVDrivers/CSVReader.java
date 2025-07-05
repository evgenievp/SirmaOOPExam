package com.CarRentalSystem.CSVDrivers;

import com.CarRentalSystem.Cars.CarModel;
import com.CarRentalSystem.Customers.User;
import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSVReader {
    private final String usersPath = "src\\customers.csv";
    private final String carsPath = "src\\cars.csv";
    private LinkedList<Customer> loadedUsers;
    private LinkedList<Car> carsLoaded;

    public CSVReader() {
        this.loadedUsers = new LinkedList<>();
        this.carsLoaded = new LinkedList<>();
    }

    public LinkedList<Car> loadCars() {
        File file = new File(carsPath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String read;
            while ((read = reader.readLine()) != null) {
                String[] data = read.split(",");
                carAssembly(data);
            }
            return carsLoaded;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public LinkedList<Customer> loadUsers() {
        File file = new File(usersPath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String read;
            while ((read = reader.readLine()) != null) {
                String[] data = read.split(",");
                String fName = data[0];
                String lName = data[1];
                String username = data[2];
                String password = data[3];
                if (data.length > 4) {
                    String[] cars = data[4].split(",");
                    userAssembly(fName, lName, username, password, cars);
                }
                else {
                    userAssembly(fName, lName, username, password);
                }
                read = reader.readLine();

            }
            return loadedUsers;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // first Cars Assembly method - it gets string and assembly Car class
    public LinkedList<Car> carAssembly(String[] cars) {
        LinkedList<Car> assembledCars = new LinkedList<>();
        for (var data : cars) {
            String[] currentCar = data.split(";");
            String model = currentCar[0];
            int year = Integer.parseInt(String.valueOf(currentCar[1]));
            String type = currentCar[2];
            String status = currentCar[3];
            Car car = new CarModel(model, year, type, status);
            assembledCars.add(car);
        }
        return assembledCars;
    }

    // Main car assembly, It is triggered by loadCars method.
    public void carAssembly(String model, int year, String type, String status) {
        Car car = new CarModel(model, year, type, status);
    }

    // user asssembly - triggered by load users.
    public void userAssembly(String fname, String lName, String username, String password, String[] cars) {
        Customer user = new User(fname, lName, username, password);
        LinkedList<Car> carsAssembled = carAssembly(cars);
        user.setRentedCars(carsAssembled);
        loadedUsers.add(user);
    }

    public void userAssembly(String fName, String lName, String username, String password) {
        Customer user = new User(fName, lName, username, password);
        loadedUsers.add(user);
    }


}
