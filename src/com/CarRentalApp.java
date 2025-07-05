package com;
import com.CarRentalSystem.Auth.Authenticate;
import com.CarRentalSystem.CSVDrivers.CSVReader;
import com.CarRentalSystem.CSVDrivers.CSVWriter;
import com.CarRentalSystem.Customers.User;
import com.CarRentalSystem.Interfaces.Customer;
import com.CarRentalSystem.Services.CarRentalService;
import com.CarRentalSystem.managers.RentalManager;


import java.util.Scanner;

public class CarRentalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CSVWriter writer = new CSVWriter();
        CSVReader reader = new CSVReader();

        Authenticate auth = new Authenticate(reader, writer);
        CarRentalService service = new CarRentalService(sc, reader, writer);
        RentalManager manager = new RentalManager(service, sc);
        boolean isRunning = true;
        boolean signedIn = false;
        int command;
        System.out.println("***Welcome to the Car Rental System***");
        while (isRunning) {
            // Maybe this is not needed, but I believe elementary authentication is need.
            // I will not put in security rules, just otherwise it seems schizophrenic to me.
            while (!signedIn) {
                service.loadData();
                auth.setCustomers(service.getCustomers());
                System.out.println("Press 1 for Sign In \nPress 2 for Sign Up");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1) {
                    System.out.println("Enter username");
                    String username = sc.nextLine();
                    System.out.println("Enter password");
                    String password = sc.nextLine();
                    Customer user = auth.getUser(username);
                    service.setUser((User) user);
                    if (user == null) {
                        System.out.println("wrong user or password");
                        continue;
                    }
                    signedIn = auth.signIn(username, password);
                }
                else {
                    boolean restart = false;
                    System.out.println("Enter new username");
                    String username = sc.nextLine();
                    System.out.println("Enter new password");
                    restart = auth.checkUsername(username);
                    String password = sc.nextLine();
                    if (restart) {
                        continue;
                    }
                    else {
                        User user = (User) auth.getUser(username);
                        service.setUser(user);
                    }
                    System.out.println("Enter first name");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name");
                    String lName = sc.nextLine();
                    User newUser = new User(firstName, lName, username, password);
                    signedIn = auth.signUp(newUser);
                    service.addDriver(newUser);
                }
            }
            manager.displayCommands();
            System.out.println("Awaiting commands...");
            command = Integer.parseInt(sc.nextLine());
            isRunning = manager.execute(command);


        }
    }
}

