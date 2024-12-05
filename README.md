# Portfolio Submission: Contact Service and Reflections

## Overview

This repository contains a portion of my work from two major projects completed in my course. From Project One, I have included the **Contact Service** files, which demonstrate my ability to create unit tests, automate software testing, and apply testing strategies to meet specific requirements. From Project Two, I have included my **Summary and Reflections Report**, which highlights my approach to software testing and quality assurance.

## Project One: Contact Service

### Files Included:
- **Contact.java**: The class that defines the Contact object with fields such as contact ID, first name, last name, phone number, and address.
- **ContactService.java**: The service class responsible for managing contact objects, including adding, updating, and deleting contacts.
- **ContactTest.java**: Unit tests for the Contact class, ensuring that the fields are validated correctly (e.g., proper length, non-null).
- **ContactServiceTest.java**: Unit tests for the ContactService class, ensuring that contacts can be correctly added, updated, and deleted.

These files showcase my ability to write **effective unit tests** using **JUnit** and my understanding of **software testing** principles such as validation, error handling, and input/output testing.

## Project Two: Summary and Reflections Report

The **Summary and Reflections Report** provides a detailed reflection on my experiences in software testing, the strategies I used to ensure code functionality and security, and how I designed my tests to meet project requirements.

---

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

To ensure that my software is functional and secure, I utilize a structured approach that includes thorough **unit testing**, **validation of user inputs**, and **exception handling**. In Project One, for example, I ensured that the **ContactService** class handled invalid input cases (such as null values or overly long fields) by writing **JUnit tests** to validate those conditions. This ensures the software behaves as expected and handles edge cases securely. Additionally, I implemented practices like **input validation** to guard against improper inputs that could lead to errors or security vulnerabilities.

In terms of security, following best practices such as **data encapsulation** and ensuring that **sensitive data** (like contact information) is stored and handled safely is a priority. By adhering to secure coding practices and performing rigorous testing, I minimize potential vulnerabilities in the software.

### How do I interpret user needs and incorporate them into a program?

Interpreting user needs begins with understanding the **requirements** outlined by the project or client. In the case of the **ContactService** project, user needs revolved around managing contact information, ensuring the integrity of input data, and providing basic CRUD (Create, Read, Update, Delete) functionality. 

To incorporate these needs, I broke down the requirements into functional components such as:
- Ensuring that each contact had a **unique ID** that could not be modified.
- Implementing checks to ensure fields like **phone number** and **address** conformed to specified formats.
- Writing comprehensive **unit tests** to verify that each user requirement was met through test cases, ensuring that the program behaved as expected across all scenarios.

### How do I approach designing software?

My approach to designing software follows a **systematic and iterative process**:
1. **Understanding the Requirements**: I start by carefully analyzing the user or project requirements. For instance, in Project One, I first ensured I had a solid grasp of the functional requirements such as adding, updating, and deleting contacts.
   
2. **Modular Design**: I design the system using a modular approach where each component (e.g., `Contact.java` or `ContactService.java`) has a well-defined responsibility. This ensures that the system is both **scalable** and **maintainable**.

3. **Testing Early and Often**: I incorporate **test-driven development (TDD)** principles by writing tests as I develop the software. This ensures that each component is tested thoroughly before integration.

4. **Iterative Improvement**: Throughout the process, I continuously refine both the code and the tests, addressing edge cases and improving efficiency based on testing results.

By following these principles, I can develop software that is both **robust** and **user-friendly**, ensuring that the final product meets the functional and security needs of the end users.
