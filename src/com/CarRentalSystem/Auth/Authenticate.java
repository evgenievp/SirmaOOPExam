package com.CarRentalSystem.Auth;

import com.CarRentalSystem.CSVDrivers.CSVReader;
import com.CarRentalSystem.CSVDrivers.CSVWriter;
import com.CarRentalSystem.Customers.User;
import com.CarRentalSystem.Interfaces.Customer;

import java.util.LinkedList;

public class Authenticate {
    private LinkedList<Customer> customers;
    private CSVReader reader;
    private CSVWriter writer;

    public Authenticate(CSVReader reader, CSVWriter writer) {
        this.customers = new LinkedList<>();
        this.reader = reader;
        this.writer = writer;
    }


    public boolean signIn(String user, String password) {
        if (!customers.isEmpty() && checkUsername(user)) {
            for (Customer customer : this.customers) {
                if (customer.getUsername().equals(user) && customer.getPassword().equals(password)) {
                    System.out.println("Welcome " + user);
                    return true;
                }
            }
        }
        return false;
    }

    public void setCustomers(LinkedList<Customer> customers) {
        this.customers = customers;
    }

    public boolean signUp(User newCustomer) {
        this.customers.add(newCustomer);
        System.out.println("Welcome " + newCustomer.getUsername());
        return true;
    }

    public boolean checkUsername(String username) {
        if (!customers.isEmpty()) {
            for (Customer user : this.customers) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Customer getUser(String username) {
        for (Customer user : this.customers) {
            if (user.getUsername().trim().equalsIgnoreCase(username.trim())) {
                return user;
            }
        }
        return null;
    }



}
