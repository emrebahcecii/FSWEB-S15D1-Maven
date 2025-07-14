package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int index = findContact(oldContact);
        if (index < 0) {
            return false;
        }
        int existingIndex = findContact(newContact.getName());
        if (existingIndex >= 0 && existingIndex != index) {
            return false;
        }

        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int index = findContact(contact);
        if (index >= 0) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public int findContact(String name){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact current = myContacts.get(i);
            if (current.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContact(){
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " " + contact.getPhoneNumber());
        }
    }
}
