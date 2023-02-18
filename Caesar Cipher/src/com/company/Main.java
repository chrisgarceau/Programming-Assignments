package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Getting user input
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a message: ");
        //Original string
        String message_copy = s.nextLine();
        //Original string converted to lowercase
        String message_lower = message_copy.toLowerCase();
        //Initialize StringBuffer to allow for mutations of original message
        StringBuffer message = new StringBuffer(message_lower);
        System.out.println("Enter a shift number: ");
        int shift = s.nextInt();
        System.out.println("Enter rotate number: ");
        int rotate = s.nextInt();
        s.close();

        //alphabet array list to use for shifting
        ArrayList<Character> alphabet = new ArrayList<Character>();
        Character a = 'a';
        for (int i = 0; i < 26; i++) {
            alphabet.add(a++);
        }

        //Creating new CipherCode object
        CipherCoder secret = new CipherCoder(alphabet, message_copy, message_lower, message, shift, rotate);
        System.out.println("Message -> " + secret.getMessageCopy());
        System.out.println("Shift = " + secret.getShift());
        System.out.println("Rotate = " + secret.getRotate());

        //If message & parameters are valid, then encrypt.
        if (secret.checkValidMessage() && secret.checkValidShift() &&  secret.checkValidRotate() && secret.checkEncryption()) {
            secret.shift();
            secret.updateCapitalLetters();
            secret.rotate();
        }

        System.out.println("Encrypted message -> " + secret.getNewMessage());
    }
}
