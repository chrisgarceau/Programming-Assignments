package com.company;

import java.util.Random;

public class Account extends Customer {
    private String customer_name;
    private String customer_ssn;
    private String account_type;
    private String account_num;
    private double balance;
    private String credit_card;


    //Default Constructor
    Account() {}
    //Parameterized constructor
    Account(String name, String ss, String at) {
        customer_name = name;
        customer_ssn = ss;
        account_type = at;

        //Generates random 10-digit bank account number
        Random rnd = new Random();
        final long r = rnd.nextLong(999999999);
        account_num = String.format("%010d", r);

    }

    //Deposits amount into customer's account balance
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + "");
    }

    //Checks if deposit amount is valid
    public boolean validDeposit(double amount) {
        if (amount <= 0) {
            System.out.println("Cannot deposit negative amount. Try again...");
            return false;
        }
        return true;
    }

    //Withdraws amount from customer's account balance
    //amount must be less than or equal to customer's account balance
    //amount must also be greater than 0
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrew $" + amount + "");
    }

    //Checks if withdraw amount is valid
    public boolean validWithdraw(double amount) {
        //Case 1: account balance is zero
        if (this.balance == 0) {
            System.out.println("ERROR: Cannot withdraw funds. Account balance is $0. Try again...");
            return false;
        }
        //Case 2: amount is greater than current account balance
        else if (amount > this.balance) {
            System.out.println("ERROR: Withdraw amount must be less or equal to " + this.balance + ". Try again...");
            return false;
        }
        //Case 3: amount is less than or equal to zero. Can't withdraw negative amount or 0.
        else if (amount <= 0) {
            System.out.println("ERROR: Withdraw amount must be greater than $0. Try again...");
            return false;
        }
        return true;
    }

    //Displays customer's account balance
    public void checkBalance() {
        System.out.println("Account Balance: $" + this.balance);
    }

    //Displays customer's checking or savings account information
    public void showInfo() {
        System.out.println("\n");
        System.out.println("Account Information");
        System.out.println("---------------------------");
        System.out.println("Name: " + this.customer_name);
        System.out.println("Account Type: " + this.account_type);
        System.out.println("Account #: " + this.account_num);
        System.out.println("Account Balance: $" + this.balance);
    }

    //Displays bank account options menu
    public void showMenu() {
        System.out.println("\n");
        System.out.println("Account Menu");
        System.out.println("------------");
        System.out.println("Press A to Deposit");
        System.out.println("Press B to Withdraw");
        System.out.println("Press C to Check Balance");
        System.out.println("Press D to Show Account Information");
        System.out.print("Enter: ");
    }

    //Setters
    public void setCustomer_name(String name) {
        customer_name = name;
    }
    public void setCustomer_ssn(String ss) {
        customer_ssn = ss;
    }

    //Getters
    public String getCustomer_name() {return this.customer_name;}
    public String getCustomer_ssn() {
        return this.customer_ssn;
    }
    public String getAccount_type() {
        return this.account_type;
    }
    public String getAccount_num() {
        return this.account_num;
    }


} //End of Class Account
