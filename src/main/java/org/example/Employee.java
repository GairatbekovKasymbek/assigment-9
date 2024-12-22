package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    private Date hireDate; // Поле типа Date

    // Конструктор для создания нового Employee (без ID)
    public Employee(int updateId, String name, String position, double salary, Date hireDate) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Конструктор для обновления существующего Employee (с ID)
    public Employee(int id, String name, String position, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;

        // Преобразование строки в объект Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.hireDate = dateFormat.parse(hireDate);
        } catch (ParseException e) {
            e.printStackTrace();
            this.hireDate = null; // Устанавливаем null в случае ошибки
        }
    }

    // Геттеры и сеттеры для каждого поля
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.hireDate = dateFormat.parse(hireDate);
        } catch (ParseException e) {
            e.printStackTrace();
            this.hireDate = null; // Устанавливаем null в случае ошибки
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", hireDate='" + (hireDate != null ? dateFormat.format(hireDate) : "N/A") +
                "'}";
    }
}
