package com;
import com.CarRentalSystem.Auth.Authenticate;
import com.CarRentalSystem.CSVDrivers.CSVReader;
import com.CarRentalSystem.CSVDrivers.CSVWriter;
import com.CarRentalSystem.Services.CarRentalService;
import com.CarRentalSystem.managers.RentalManager;


import java.util.Scanner;

public class CarRentalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        Authenticate auth = new Authenticate();
        CarRentalService service = new CarRentalService(sc, reader, writer);
        RentalManager manager = new RentalManager(service, sc);

        System.out.println("***Welcome to the Car Rental System***");

        boolean isRunning = true;
        int command;
        boolean signedIn = false;

        while (isRunning) {
            // Maybe this is not needed, but I believe elementary authentication is need.
            // I will not put in security rules, just otherwise it seems schizophrenic to me.
            while (!signedIn) {
                System.out.println("Press 1 for Sign In \n2Press 2 for Sign Up");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1) {
                    System.out.println("Enter username");
                    String user = sc.nextLine();
                    System.out.println("Enter password");
                    String password = sc.nextLine();
                    signedIn = auth.signIn(user, password);
                }
                else {
                    System.out.println("Enter first name");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name");
                    String lName = sc.nextLine();
                    System.out.println("Enter username name");
                    String username = sc.nextLine();
                    System.out.println("Enter password name");
                    String password = sc.next();
                    signedIn = auth.signUp(firstName, lName, username, password);
                }
            }
            manager.displayCommands();
            command = Integer.parseInt(sc.nextLine());
            isRunning = manager.execute(command);


        }
    }

}

