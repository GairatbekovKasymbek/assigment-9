package org.example;

import java.sql.*;

public class EmployeeDAO {
    // Метод для получения соединения с базой данных
    private Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/employee_db";
        String username = "postgres";
        String password = "123";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
            throw new RuntimeException("Error establishing database connection", e);  // Логируем и выбрасываем исключение
        }
    }

    // Метод для создания нового сотрудника
    public void createEmployee(Employee employee) {
        // Запрос с добавлением RETURNING id
        String sql = "INSERT INTO employee (name, position, salary, hire_date) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Устанавливаем значения для PreparedStatement
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPosition());
            statement.setDouble(3, employee.getSalary());

            // Преобразуем java.util.Date в java.sql.Date
            statement.setDate(4, new java.sql.Date(employee.getHireDate().getTime()));

            // Выполняем запрос на вставку и получаем сгенерированный id
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int generatedId = resultSet.getInt("id"); // Получаем сгенерированный id
                employee.setId(generatedId);  // Присваиваем сгенерированный id объекту Employee
            }

            System.out.println("Employee created successfully with ID: " + employee.getId());
        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
