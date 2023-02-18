package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer extends Bank {
    private String customer_name;
    private String ssn;
    private String user_name;
    private String pin_num;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    //Default Constructor
    Customer() {}
    //Parameterized constructor
    Customer(String name, String social_security) {
        customer_name = name;
        ssn = social_security;
    }

    //Initializes an account object and adds that account to the customer's accounts list
    public void addAccount() {
        System.out.println("\n");
        System.out.println("Create a new bank account:");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter account type (Checking or Savings): ");
        String at = s.next().toUpperCase();
        System.out.print("\n");
        //Initializes new account with user input
        Account x = new Account(this.customer_name, this.ssn, at);
        //Adds account to customer's account list
        accounts.add(x);
        System.out.println(at.toUpperCase() + " account created!");
        System.out.println("\n");
    }

    //Cycles through all the customer's bank accounts. Customer can select a specific account and can view/update that account.
    public void accountOptions() {
        //Iterates over customer's accounts list
        for (Account account : accounts) {
            boolean notDone = true;
            boolean inputIsValid = true;
            String answer1 = "";
            while (inputIsValid) {
                //Asks user if they want to select that specific account
                System.out.println("\n");
                System.out.println("Select this account? Enter Y or N");
                account.showInfo();
                System.out.print("Enter: ");
                Scanner s1 = new Scanner(System.in);
                answer1 = s1.next().toUpperCase();  //converts input to uppercase
                if (answer1.equals("Y") || answer1.equals("N")) {
                    inputIsValid = false;
                }
                else {
                    System.out.println("\n");
                    System.out.println("ERROR: Invalid choice. Try again...");
                }
            }

            //While customer would like to remain in that specific bank account
            while (notDone) {
                //If user enters Y, display the Account Menu
                if (Objects.equals(answer1, "Y")) {
                    account.showMenu();
                    Scanner s2 = new Scanner(System.in);
                    String answer2 = s2.next().toUpperCase();
                    //Based on user input from Account Menu, do something
                    switch (answer2) {
                        //Deposit
                        case "A" -> {
                            boolean valid = true;
                            while (valid) {
                                System.out.println("\n");
                                System.out.print("Enter amount to deposit: ");
                                Scanner s5 = new Scanner(System.in);
                                double amount2 = s5.nextDouble();
                                if (account.validDeposit(amount2)) {
                                    account.deposit(amount2);
                                    valid = false;
                                }
                            }
                        }
                        //Withdraw
                        case "B" -> {
                            boolean valid = true;
                            while (valid) {
                                System.out.println("\n");
                                System.out.print("Enter amount to withdraw: ");
                                Scanner s5 = new Scanner(System.in);
                                double amount2 = s5.nextDouble();
                                if (account.validWithdraw(amount2)) {
                                    account.withdraw(amount2);
                                    valid = false;
                                }
                            }
                        }
                        //Check account balance
                        case "C" -> account.checkBalance();
                        //Display account information
                        case "D" -> account.showInfo();
                        //If user input is not A - D
                        default -> System.out.println("ERROR: Invalid choice.");
                    }

                    boolean notDone2 = true;
                    while (notDone2) {
                        System.out.println("\n");
                        System.out.print("Return to Account Menu: Enter Y or N: ");
                        Scanner s6 = new Scanner(System.in);
                        String a3 = s6.next().toUpperCase();
                        System.out.println();
                        switch (a3) {
                            case "Y" -> {
                                notDone2 = false;
                            }
                            case "N" -> {
                                notDone2 = false;
                                notDone = false;
                            }
                            default -> System.out.println("ERROR: Invalid choice.");
                        }
                    }
                }
                //Exit
                if (Objects.equals(answer1, "N")) {
                    notDone = false;
                }
                //Loop has iterated over all accounts.
                if (Objects.equals(answer1, "N") && accounts.indexOf(account) == accounts.size() - 1) {
                    System.out.println("All accounts have been shown.");
                    System.out.println("\n");
                }
            }
        }
    }

    //Displays all the customer's bank accounts (if they have 1 or more)
    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("\n");
            System.out.println("You have no accounts open.");
        }
        else {
            System.out.println("\n");
            System.out.println(this.customer_name + "'s Bank Accounts: ");
            for (Account account : accounts) {
                account.showInfo();
                System.out.println("\n");
            }
            System.out.println("\n");
            System.out.println("Select an account below...");
        }
        System.out.println("\n");
    }

    //Displays the user's account summary
    public void displayAccountSummary() {
        System.out.println("User Account Summary");
        System.out.println("--------------------");
        System.out.println("Name: " + customer_name);
        System.out.println("SSN: " + this.ssn);
        System.out.println("Username: " + this.user_name);
        System.out.println("PIN #: " + this.pin_num);
        System.out.println("\n");
    }

    //Setters
    public void setUser_name(String user) {
        user_name = user;
    }
    public void setPin_num(String x) {
        pin_num = x;
    }

    //Getters
    public String getCustomer_name() {
        return this.customer_name;
    }
    public String getUser_name() {
        return this.user_name;
    }
    public String getPin_num() {
        return pin_num;
    }

} //End of Class Customer
