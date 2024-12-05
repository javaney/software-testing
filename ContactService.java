package com.contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    // Constructor
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists: must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by contact ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist: cannot delete.");
        }
        contacts.remove(contactId);
    }

    // Update contact fields by contact ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    // Retrieve a contact by ID (for testing or other purposes)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
