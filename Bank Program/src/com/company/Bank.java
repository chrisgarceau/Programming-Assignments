package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Bank {
    private String bank_name;
    private String license_number;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> account_numbers = new ArrayList<>();

    //Constructor
    Bank() {}
    //Parameterized constructor
    Bank(String name, String ln) {
        bank_name = name;
        license_number = ln;
    }

    public void displayWelcomeMessage() {
        System.out.println("\n");
        System.out.println("Welcome to " + this.bank_name + "!");
        System.out.println("---------------------------------");
    }

    public void displayBankMenu() {
        System.out.println("Press A to Create a New User Account");
        System.out.println("Press B to Login");
        System.out.println("Press C to Exit");
        System.out.print("Enter: ");
    }

    public void displayBankAccountOptions(Customer c) {
        System.out.println("\n");
        System.out.println("Welcome " + c.getCustomer_name() + "!");
        System.out.println("Press A to View All Accounts");
        System.out.println("Press B to Create New Checking or Savings Account");
        System.out.println("Press C to Logout");
        System.out.print("Enter: ");
    }

    //Initializes new customer account
    public Customer createAccount(Scanner s) {
        System.out.println("\n");
        System.out.print("First name: ");
        String fname = s.next();
        System.out.print("Last name: ");
        String lname = s.next();
        String full_name = fname + " " + lname;
        System.out.print("SSN: ");
        String ssn = s.next();
        Customer c = new Customer(full_name, ssn);
        boolean notDone = true;
        //While user input username already exists, keep trying new usernames.
        while (notDone) {
            System.out.print("Enter a username: ");
            String user = s.next();
            boolean found = false;
            for (Customer customer: customers) {
                if (Objects.equals(customer.getUser_name(), user)) {
                    System.out.println("Username already exists. Try again");
                    found = true;
                }
            }
            //If username does not already exist, set username. Then exits...
            if (!found) {
                c.setUser_name(user);
                notDone = false;
            }
        }
        System.out.print("Enter a pin number: ");
        String p = s.next();
        c.setPin_num(p);
        System.out.println("\n");
        System.out.println("Account created!");
        System.out.println("\n");
        c.displayAccountSummary();
        //Adds customer to list of all bank customers
        addCustomer(c);
        return c;
    }
    //Returns the total number of customers
    public int getNumOfCustomers() {
        return customers.size();
    }
    //Adds customer to the list of all bank customers
    public void addCustomer(Customer x) {
        customers.add(x);
    }
    //Finds customer with specific username/pin pair and returns that customer. Else, returns null.
    public Customer selectCustomer(String user, String pin) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getUser_name(), user) && Objects.equals(customer.getPin_num(), pin)) {
                return customer;
            }
        }
        return null;
    }

} //End of Class Bank