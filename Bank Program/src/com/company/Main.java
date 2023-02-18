package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializes Bank with a name and license number
        Bank b1 = new Bank("Citibank", "14617213476810");
        boolean exit = true;
        //While user wants to remain using program
        while (exit) {
            b1.displayWelcomeMessage();
            b1.displayBankMenu();
            Scanner s = new Scanner(System.in);
            String user_input = s.next().toUpperCase();
            switch (user_input) {
                //If user enters "A", create a new user account
                case "A" -> {
                    //Initializes Customer c by calling the createAccount() function which creates & returns the new Customer
                    Customer c = b1.createAccount(s);
                    boolean notDone = true;
                    //Validates the new customers credential's. Will loop until customer enters their correct credentials.
                    System.out.println("Please validate your username and password: ");
                    while (notDone) {
                        System.out.print("Enter username: ");
                        Scanner s1 = new Scanner(System.in);
                        String u = s1.next();
                        System.out.print("Enter PIN #: ");
                        String p = s.next();
                        System.out.println();
                        //If username/password pair exists and matches with the current input, then log into that customer's account.
                        if (b1.selectCustomer(u, p) != null && Objects.equals(u, c.getUser_name()) && Objects.equals(p, c.getPin_num())) {
                            System.out.println("Logging in...");
                            System.out.println("\n");
                            notDone = false;
                        }
                        //Checks if username already exists
                        else if (b1.selectCustomer(u, p) != null) {
                            System.out.println("Username already exits. Try again...");
                        }
                        //Else, username and/or password are incorrect
                        else {
                            System.out.println("Wrong username and/or password. Try again...");
                        }
                    }

                    //Once user is logged in, display bank account options from within that customer's account.
                    notDone = true;
                    while (notDone) {
                        b1.displayBankAccountOptions(c);
                        Scanner s2 = new Scanner(System.in);
                        String answer = s2.next().toUpperCase();
                        switch (answer) {
                            //If user enters "A", display all their bank accounts.
                            //Then cycle through each bank account and ask to select one for viewing/updating.
                            case "A" -> {
                                c.displayAccounts();
                                c.accountOptions();
                            }
                            //If user enters "B", create a new checking/savings account.
                            case "B" -> c.addAccount();
                            //If user enters "C", exit...
                            case "C" -> notDone = false;
                            default -> System.out.println("ERROR: Invalid choice. Try again...");
                        }
                    }
                }
                //If user enters "B", login. Once logged in, allow customer to:
                // - view all accounts
                // - update account(s)
                // - add account(s)
                // - exit
                case "B" -> {
                    Customer c2 = new Customer();
                    //If bank has at least 1 customer, continue to log in.
                    if (b1.getNumOfCustomers() > 0) {
                        boolean notDone = true;
                        while (notDone) {
                            System.out.println("\n");
                            System.out.println("Login: ");
                            System.out.print("Enter username: ");
                            Scanner s1 = new Scanner(System.in);
                            String u = s1.next();
                            System.out.print("Enter PIN #: ");
                            String p = s.next();
                            //Selects customer with entered unique username/password combination
                            c2 = b1.selectCustomer(u, p);
                            if (b1.selectCustomer(u, p) != null) {
                                System.out.println("Logging in...");
                                System.out.println();
                                notDone = false;
                            }
                            else {
                                System.out.println("Wrong username and/or password. Try again...");
                            }
                        }
                        //Once user is logged in, display bank account options from within that customer's account.
                        notDone = true;
                        while (notDone) {
                            b1.displayBankAccountOptions(c2);
                            Scanner s3 = new Scanner(System.in);
                            String answer = s3.next().toUpperCase();
                            switch (answer) {
                                case "A" -> {
                                    c2.displayAccounts();
                                    c2.accountOptions();
                                }
                                case "B" -> c2.addAccount();
                                case "C" -> notDone = false;
                                default -> {
                                    System.out.println("ERROR: Invalid choice. Try again...");
                                    System.out.println();
                                }
                            }
                        }
                    }
                    //Else, the bank has 0 customers. Return to home screen...
                    else {
                        System.out.println("\n");
                        System.out.println("Number of bank customers: 0");
                        System.out.println("Returning to Home Screen...");
                    }
                }
                //If user enters "C", terminate program.
                case "C" -> {
                    System.out.println("\n");
                    System.out.println("Exiting...");
                    exit = false;
                }
                default -> System.out.println("ERROR: Invalid choice. Try again...");
            }
        }
    }

} //End of Class Main
