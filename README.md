# Hospital Management System

## Description

This project is a console-based application developed in Core Java, designed to manage hospital operations. It serves as a management system where administrators, doctors, nurses, receptionists, and patients can perform various tasks related to hospital management, including managing patients, doctors, appointments, inventory, billing, and more. The application is built to demonstrate object-oriented programming principles, console I/O operations, and unit testing with JUnit in Java, tailored specifically for hospital management.

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
   2. Update Appointment
   3. Cancel Appointment
   4. View Doctor’s Schedule
   5. View Patient’s Appointments
   6. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Billing Management Menu**
   ```
   ====================================
           Manage Billing
   ====================================
   1. Generate Bill
   2. Process Payment
   3. View Outstanding Payments
   4. Back to Main Menu
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

3. **Doctor Interface**

   **Main Menu for Doctor**
   ```
   ====================================
             Doctor Dashboard
   ====================================
   1. View Patient Records
   2. Update Patient Medical Records
   3. View My Schedule
   4. Back to Main Menu
   5. Logout
   ====================================
   Enter your choice: _
   ```

   **Patient Records Menu**
   ```
   ====================================
          View Patient Records
   ====================================
   1. Search Patient by ID
   2. Search Patient by Name
   3. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **Update Medical Records Menu**
   ```
   ====================================
      Update Patient Medical Records
   ====================================
   1. Enter Patient ID
   2. Add Diagnosis
   3. Add Treatment
   4. Add Prescription
   5. View Medical History
   6. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

4. **Nurse Interface**

   **Main Menu for Nurse**
   ```
   ====================================
             Nurse Dashboard
   ====================================
   1. View Patient Records
   2. Update Treatment Logs
   3. Manage Inventory
   4. View My Schedule
   5. Back to Main Menu
   6. Logout
   ====================================
   Enter your choice: _
   ```

   **Update Treatment Logs Menu**
   ```
   ====================================
          Update Treatment Logs
   ====================================
   1. Enter Patient ID
   2. Add Treatment Details
   3. View Treatment History
   4. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

5. **Receptionist Interface**

   **Main Menu for Receptionist**
   ```
   ====================================
         Receptionist Dashboard
   ====================================
   1. Register New Patient
   2. Schedule Appointment
   3. Cancel Appointment
   4. Process Billing
   5. View Patient Appointments
   6. Back to Main Menu
   7. Logout
   ====================================
   Enter your choice: _
   ```

   **Patient Registration Menu**
   ```
   ====================================
         Register New Patient
   ====================================
   Enter Patient Details:
   1. Name:
   2. Age:
   3. Gender:
   4. Contact Information:
   5. Medical History:
   6. Submit
   7. Back to Main Menu
   ====================================
   ```

   **Appointment Scheduling Menu**
   ```
   ====================================
          Schedule Appointment
   ====================================
   1. Enter Patient ID
   2. Choose Doctor
   3. Choose Date and Time
   4. Confirm Appointment
   5. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

6. **Patient Interface**

   **Main Menu for Patient**
   ```
   ====================================
            Patient Dashboard
   ====================================
   1. View My Medical Records
   2. View My Appointments
   3. View My Billing Information
   4. Back to Main Menu
   5. Logout
   ====================================
   Enter your choice: _
   ```

   **View Medical Records Menu**
   ```
   ====================================
        View My Medical Records
   ====================================
   1. View Diagnoses
   2. View Treatments
   3. View Prescriptions
   4. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **View Appointments Menu**
   ```
   ====================================
        View My Appointments
   ====================================
   1. View Upcoming Appointments
   2. View Past Appointments
   3. Back to Main Menu
   ====================================
   Enter your choice: _
   ```

   **View Billing Information Menu**
   ```
   ====================================
     View My Billing Information
   ====================================
   1. View Outstanding Bills
   2. View Payment History
   3. Back to Main Menu
   ====================================
   Enter your choice: _

   ```

## Technologies Used

- **Java SE (Standard Edition)**: Core language for developing the application.
- **JUnit Framework**: For unit testing of the application's components.
- **Console I/O**: For interaction with the user via the console.
- **Collections Framework**: Utilized for managing patients, doctors, appointments, inventory, and billing information efficiently.
- **Object-Oriented Programming (OOP)**: Design paradigm to structure the application using objects and classes.
