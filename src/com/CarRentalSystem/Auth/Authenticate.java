package com.CarRentalSystem.Auth;

import com.CarRentalSystem.Customers.User;

import java.util.LinkedList;
import java.util.List;

public class Authenticate {
    private List<User> customers;

    public Authenticate() {
        this.customers = new LinkedList<>();
    }


    public boolean signIn(String user, String password) {
        if (customers.isEmpty() && checkUsername(user)) {
            for (var customer : this.customers) {
                if (customer.getUsername().equals(user) && customer.getPassword().equals(password)) {
                    System.out.println("Welcome " + user);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean signUp(User newCustomer) {
        this.customers.add(newCustomer);
        System.out.println("Welcome " + newCustomer.getUsername());
        return true;
    }

    public boolean checkUsername(String username) {
        for (var user: this.customers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (var user : this.customers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        // Here will return first, because when I call this method I know I will find user.
        return this.customers.getFirst();
    }


}
