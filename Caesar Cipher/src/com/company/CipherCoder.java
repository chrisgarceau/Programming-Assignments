package com.company;

import java.util.ArrayList;

public class CipherCoder {
    private ArrayList<Character> alphabet;
    private String message_copy;
    private String message_lower;
    private StringBuffer message;
    private StringBuffer new_message = new StringBuffer();
    private int shift;
    private int rotate;


    //DEFAULT CONSTRUCTOR
    public CipherCoder() {}

    //PARAMETERIZED CONSTRUCTOR
    public CipherCoder(ArrayList<Character> a, String mc, String ml, StringBuffer m, int s, int r) {
        alphabet = a;
        message_copy = mc;
        message_lower = ml;
        message = m;
        shift = s;
        rotate = r;
    }

    //MUTATORS
    public void setMessageCopy(String mc) {
        message_copy = mc;
    }
    public void setMessageLower(String ml) {
        message_lower = ml;
    }
    public void setMessage(StringBuffer m) {
        message = m;
    }
    public void setNewMessage(StringBuffer nm) {
        new_message = nm;
    }
    public void setShift(int s) {
        shift = s;
    }
    public void setRotate(int r) {
        rotate = r;
    }
    //SHIFT FUNCTION - only shifts letters
    public void shift() {
        for (int i = 0; i < message.length(); i++) {
            boolean b = Character.isLetter(message.charAt(i));
            if (b) {
                int pos = alphabet.indexOf(message.charAt(i));
                int newPos;
                if (pos + shift > 25) { newPos = (pos + shift) - 26; }
                else { newPos = pos + shift; }
                new_message.append(alphabet.get(newPos));
            }
            else { new_message.append(message.charAt(i)); }
        }
    }
    //ROTATE FUNCTION - Inserts char at the end of the message to the front, then deletes the char at the end.
    public void rotate() {
        for (int i = 0; i < rotate; i++) {
            new_message.insert(0, new_message.charAt(new_message.length() - 1));
            new_message.deleteCharAt(new_message.length() - 1);
        }
    }
    //Updates capital letters within the string using the original message as a reference.
    public void updateCapitalLetters() {
        for (int i = 0; i < message.length(); i++) {
            boolean b = Character.isUpperCase(message_copy.charAt(i));
            if (b) {
                Character up = Character.toUpperCase(new_message.charAt(i));
                new_message.setCharAt(i, up);
            }
        }
    }

    //ACCESSORS & VALIDATORS
    public String getMessageCopy() {
        return message_copy;
    }
    public String getMessageLower() {
        return message_lower;
    }
    public StringBuffer getMessage() {
        return message;
    }
    public StringBuffer getNewMessage() {
        return new_message;
    }
    public int getShift() {
        return shift;
    }
    public int getRotate() {
        return rotate;
    }

    public boolean checkValidMessage() {
        int letterCount = 0;
        for (int i = 0; i < message.length(); i++) {
            boolean b = Character.isLetter(message.charAt(i));
            if (b) { letterCount++; }
        }
        if (letterCount == 0) {
            System.out.println("At least one letter should be provided.");
            return false;
        }
        return true;
    }
    public boolean checkValidShift() {
        if (shift < 0 || shift > 25) {
            System.out.println("The shift number should be between 0 and 25.");
            return false;
        }
        return true;
    }
    public boolean checkValidRotate() {
        if (rotate < 0) {
            System.out.println("Rotation should be greater than or equal zero.");
            return false;
        }
        return true;
    }
    public boolean checkEncryption() {
        if (shift == 0 && rotate == 0) {
            System.out.println("No encryption applied.");
            return false;
        }
        return true;
    }

} //END OF CIPHERCODE CLASS
