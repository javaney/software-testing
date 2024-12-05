package com.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact("1234567890"));
    }

    // Test adding multiple valid contacts
    @Test
    public void testAddMultipleContacts() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        Contact contact2 = new Contact("0987654321", "Jane", "Smith", "0987654321", "456 Oak St");

        contactService.addContact(contact1);
        contactService.addContact(contact2);

        assertEquals(contact1, contactService.getContact("1234567890"));
        assertEquals(contact2, contactService.getContact("0987654321"));
    }

    // Test trying to add a contact with a duplicate ID
    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Oak St"));
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");

        assertNull(contactService.getContact("1234567890"));
    }

    // Edge case: Deleting non-existent contact
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("nonexistentId");
        });
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Oak St");

        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    // Test update contact with invalid data
    @Test
    public void testUpdateContactWithInvalidData() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        contactService.addContact(contact);

        // Invalid phone number update
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Jane", "Smith", "invalidphone", "456 Oak St");
        });

        // Invalid first name update
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", null, "Smith", "0987654321", "456 Oak St");
        });
    }

    // Test updating a non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("nonexistentId", "Jane", "Smith", "0987654321", "456 Oak St");
        });
    }

    // Additional test: deleting and then re-adding a contact with the same ID
    @Test
    public void testReaddAfterDelete() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");

        // Add the same contact ID again after deletion
        Contact newContact = new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Oak St");
        contactService.addContact(newContact);

        assertEquals(newContact, contactService.getContact("1234567890"));
    }
}
