package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvImporter {
    public static List<Contact> importContacts(String filepath) throws IOException {
        List<Contact> contacts = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            Contact contact = new Contact(parts[0], parts[1], parts[2]);
            contacts.add(contact);
        }
        reader.close();
        return contacts;
    }
}