# Hospital Management System

## Description

This project is a console-based application developed in Core Java, designed to manage hospital operations. It serves as a management system where administrators can perform various tasks related to hospital management, including managing patients, doctors, appointments, inventory, billing, and more. The application is built to demonstrate object-oriented programming principles, console I/O operations, and unit testing with JUnit in Java, tailored specifically for hospital management.

## Features

1. **User Authentication and Authorization**
   - Secure login system to ensure that only authorized personnel can access the system.
   - Different roles such as administrator, doctor, nurse, receptionist, and patient with specific permissions.

   ```
   ====================================
          Hospital Management System
   ====================================
   1. Login
   2. Exit
   ====================================
   Enter your choice: _
   ```

2. **Administrator Interface**

   **Main Menu for Administrator**
   ```
   ====================================
          Administrator Dashboard
   ====================================
   1. Manage Patients
   2. Manage Doctors
   3. Manage Appointments
   4. Manage Billing
   5. View Reports
   6. View Audit Logs
   7. Logout
   ====================================
   Enter your choice: _
   ```

   **Patient Management Menu**
   ```
   ====================================
           Manage Patients
   ====================================
   1. Register New Patient
   2. Update Patient Information
   3. Delete Patient Record
   4. View Patient Records
   5. Search Patient Records
   6. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Doctor Management Menu**
   ```
   ====================================
           Manage Doctors
   ====================================
   1. Register New Doctor
   2. Update Doctor Information
   3. Delete Doctor Record
   4. View Doctor Profiles
   5. Search Doctor Profiles
   6. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Appointment Management Menu**
   ```
   ====================================
         Manage Appointments
   ====================================
   1. Schedule New Appointment
   2. Cancel Appointment
   3. View Doctor’s Schedule
   4. View Patient’s Appointments
   5. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Billing Management Menu**
   ```
   ====================================
           Manage Billing
   ====================================
   1. Generate Bill
   2. Process Bill
   3. Authorize Bill
   4. View Outstanding Payments
   5. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Reports Menu**
   ```
   ====================================
            View Reports
   ====================================
   1. Patient Demographics Report
   2. Treatment Outcomes Report
   3. Doctor Performance Report
   4. Inventory Usage Report
   5. Financial Summary Report
   6. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Audit Logs Menu**
   ```
   ====================================
           View Audit Logs
   ====================================
   1. View All Logs
   2. Search Logs by User
   3. Search Logs by Action
   4. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

## Technologies Used

- **Java SE (Standard Edition)**: Core language for developing the application.
- **JUnit Framework**: For unit testing of the application's components.
- **Console I/O**: For interaction with the user via the console.
- **Collections Framework**: Utilized for managing patients, doctors, appointments, inventory, and billing information efficiently.
- **Object-Oriented Programming (OOP)**: Design paradigm to structure the application using objects and classes.
