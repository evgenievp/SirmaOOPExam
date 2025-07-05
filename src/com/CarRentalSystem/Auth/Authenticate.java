package com.CarRentalSystem.Auth;

import com.CarRentalSystem.Customers.Customer;

import java.util.LinkedList;
import java.util.List;

public class Authenticate {
    private List<Customer> customers;

    public Authenticate() {
        this.customers = new LinkedList<>();
    }


    public boolean signIn(String user, String password) {
        if (customers.isEmpty()) {
            for (var customer : this.customers) {
                if (customer.getUsername().equals(user) && customer.getPassword().equals(password)) {
                    System.out.println("Welcome " + user);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean signUp(String fName, String lName, String username, String password) {
        if (!customers.isEmpty()) {
            for (var customer : this.customers) {
                if (customer.getUsername().equals(username)) {
                    System.out.println("You have to use another username.");
                    return false;
                }
            }
        }
        Customer user = new Customer(fName, lName, username, password);
        this.customers.add(user);
        System.out.println("Welcome " + username);
        return true;
    }

}
