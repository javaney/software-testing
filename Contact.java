package com.contacts;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contactId (must be <= 10 characters and not null)
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID: must be non-null and <= 10 characters.");
        }

        // Validate firstName (must be <= 10 characters and not null)
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name: must be non-null and <= 10 characters.");
        }

        // Validate lastName (must be <= 10 characters and not null)
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name: must be non-null and <= 10 characters.");
        }

        // Validate phone (must be exactly 10 digits and not null)
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number: must be 10 digits and non-null.");
        }

        // Validate address (must be <= 30 characters and not null)
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address: must be non-null and <= 30 characters.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for firstName, lastName, phone, and address (contactId is not updatable)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name: must be non-null and <= 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name: must be non-null and <= 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number: must be 10 digits and non-null.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address: must be non-null and <= 30 characters.");
        }
        this.address = address;
    }
}
