package com.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Edge case: Test all invalid combinations in constructor
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "0123456789", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "0123456789", "123 Main St");
        });
    }

    // Test combinations of invalid firstName, lastName, phone, and address
    @Test
    public void testInvalidConstructorCombinations() {
        // Invalid first name and valid everything else
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "0123456789", "123 Main St");
        });

        // Invalid last name and valid everything else
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "0123456789", "123 Main St");
        });

        // Invalid phone and valid everything else
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345", "123 Main St");
        });

        // Invalid address and valid everything else
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "0123456789", null);
        });

        // Multiple invalid fields (e.g., null phone and invalid lastName)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "LongLastName", null, "123 Main St");
        });

        // All fields invalid
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "TooLongName", null, "invalidPhone", null);
        });
    }

    // Test setters with valid and invalid data
    @Test
    public void testSettersWithValidData() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");

        // Valid updates
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 Oak St");
        assertEquals("456 Oak St", contact.getAddress());
    }

    // Edge case: Test invalid data passed into setters
    @Test
    public void testSettersWithInvalidData() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");

        // Invalid first name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });

        // Invalid last name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });

        // Invalid phone number
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("invalidphone");
        });

        // Invalid address
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is far too long for the 30 character limit.");
        });
    }
}
