# Employee-Payroll-System

## Overview
The **Payroll Management System** is a Java-based application designed to manage employee records, calculate salaries, and store employee details in a MySQL database. It supports both **Full-Time** and **Part-Time** employees and provides functionality for adding, retrieving, and displaying employee data from both an in-memory list and a database.

## Features

- Add full-time and part-time employees.
- Store employee details in an **ArrayList**.
- Persist employee data in a **MySQL database**.
- Fetch and display employee records from the database.
- Remove employees from the in-memory list and database.
- This Project covers all the features Of OOPS includes ABSTRACTION,ENCAPSULATION,INHERITANCE,POLYMORPHISM.

## Object-Oriented Programming (OOP) Concepts Covered

This project follows key OOP principles:

   Encapsulation - Employee details and database connections are encapsulated within their respective classes.

   Abstraction - The Employee class is an abstract class that defines common behavior for all employee types.

   Inheritance - FullTimeEmployee and PartTimeEmployee inherit from the Employee class.

  Polymorphism - The calculateSalary() method is overridden in both FullTimeEmployee and PartTimeEmployee to provide 
                 specific implementations.  

## Technologies Used
- Java (JDK 8+)
- MySQL (Database for employee records)
- JDBC (Java Database Connectivity)

## Project Structure
Whole Structure Of My Project Which Indicates How the Flow Of Execution Will Be Done
src/
    |-- DatabaseManager.java  # Handles database connections
    |-- Employee.java         # Abstract class for employees
    |-- FullTimeEmployee.java # Full-time employee class
    |-- PartTimeEmployee.java # Part-time employee class
    |-- PayrollSystem.java    # Manages employee operations
    |-- Main.java             # Entry point for the application


## Database Schema
The project uses a MySQL database named **payroll** with a table **Employees**:
```sql
CREATE TABLE Employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(20),
    monthlySalary DOUBLE,
    hoursWorked INT,
    hourlyRate DOUBLE
);
```

## How to Run
### Prerequisites:
- Install **Java JDK 8+**
- Install **MySQL Server**
- Set up the **payroll** database and create the **Employees** table using the provided schema.
- Update database credentials in `DatabaseManager.java` (if necessary).

### Steps:
1. Compile the Java files:
   javac Main.java
   
2. Run the application:
   java Main
   
## Future Enhancements
- Add a **GUI interface** using JavaFX or Swing.
- Improve **error handling** and validation**.
- Implement **logging** for database transactions.
- Add **unit tests** for better reliability.

## Author
Developed by [Aditya Jadhav]



