package org.example;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeData employeeData = new EmployeeData();

        while (true) {
            System.out.println("Choose an operation: ");
            System.out.println("1. Create Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Create Employee
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.println("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter hire date (YYYY-MM-DD): ");
                    String hireDateString = scanner.nextLine();

                    Date hireDate = Date.valueOf(hireDateString);

                    int updateId = 0;
                    Employee newEmployee = new Employee(updateId, name, position, salary, hireDate);
                    try {
                        employeeData.createEmployee(newEmployee);
                        System.out.println("Employee created successfully!");
                    } catch (SQLException e) {
                        System.out.println("Error creating employee: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Get Employee by ID
                    System.out.println("Enter employee ID: ");
                    int id = scanner.nextInt();
                    try {
                        Employee employee = employeeData.getEmployeeById(id);
                        if (employee != null) {
                            System.out.println("Employee Details: " + employee);
                        } else {
                            System.out.println("Employee not found.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error retrieving employee: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Get All Employees
                    try {
                        List<Employee> employees = employeeData.getAllEmployees();
                        if (employees.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            employees.forEach(System.out::println);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error retrieving employees: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Update Employee
                    System.out.println("Enter employee ID to update: ");
                    updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new name: ");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter new position: ");
                    String updatePosition = scanner.nextLine();
                    System.out.println("Enter new salary: ");
                    double updateSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new hire date (YYYY-MM-DD): ");
                    String updateHireDateString = scanner.nextLine();

                    Date updateHireDate = Date.valueOf(updateHireDateString);

                    Employee updatedEmployee = new Employee(updateId, updateName, updatePosition, updateSalary, updateHireDate);
                    try {
                        employeeData.updateEmployee(updatedEmployee);
                        System.out.println("Employee updated successfully!");
                    } catch (SQLException e) {
                        System.out.println("Error updating employee: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Delete Employee
                    System.out.println("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    try {
                        employeeData.deleteEmployee(deleteId);
                        System.out.println("Employee deleted successfully!");
                    } catch (SQLException e) {
                        System.out.println("Error deleting employee: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
