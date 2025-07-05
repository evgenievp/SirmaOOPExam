package com.CarRentalSystem.CSVDrivers;

import com.CarRentalSystem.Interfaces.Car;
import com.CarRentalSystem.Interfaces.Customer;
import com.CarRentalSystem.Interfaces.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {


    public CSVWriter() {
    }

    public void saveCars(List<Car> cars) {
        save("src\\cars.csv", cars);
    }

    public void saveCustomers(List<Customer> customers) {
        save("src\\customers.csv", customers);
    }

    private <T extends Data> void save(String path, List<T> data) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (var currentRecord: data) {
                writer.write(currentRecord.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
