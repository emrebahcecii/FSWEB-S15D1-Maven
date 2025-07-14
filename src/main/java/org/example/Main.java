package org.example;

import org.example.mobile.Contact;
import org.example.models.Grocery;

public class Main {
    public static void main(String[] args) {

        Grocery.startGrocery();
        Contact c = new Contact("Emre","535535");
        System.out.println( c.getPhoneNumber());


    }
}
