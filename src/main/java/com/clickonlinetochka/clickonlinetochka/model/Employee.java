package com.clickonlinetochka.clickonlinetochka.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "employes")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Double salary;
    @Indexed
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee(String firstName, String lastName, Double salary, List<Order> ordersForProcessing) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.ordersForProcessing = ordersForProcessing;
    }

    private List<Order> ordersForProcessing;

    public Employee() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Order> getOrdersForProcessing() {
        return ordersForProcessing;
    }

    public void setOrdersForProcessing(List<Order> ordersForProcessing) {
        this.ordersForProcessing = ordersForProcessing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(ordersForProcessing, employee.ordersForProcessing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary, ordersForProcessing);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", ordersForProcessing=" + ordersForProcessing +
                '}';
    }
}
