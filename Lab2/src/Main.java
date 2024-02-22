// Artem Ruzaev
// n01497403
// Lab # 2

import java.util.Scanner;

// Class representing an Employee
class Employee {
    private int employeeID;     // Employee ID
    private String firstName;   // First name of the employee
    private String lastName;    // Last name of the employee

    // Getter method for employee ID
    public int getEmployeeID() {
        return employeeID;
    }

    // Setter method for employee ID
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    // Getter method for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter method for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for last name
    public String getLastName() {
        return lastName;
    }

    // Setter method for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

// Main class for execution
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an instance of the Employee class
        Employee employee = new Employee();

        // Taking input for employee details
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();
        employee.setEmployeeID(employeeID);

        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        employee.setFirstName(firstName);

        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        employee.setLastName(lastName);

        // Displaying employee information
        System.out.println("Employee Info:");
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
    }
}
