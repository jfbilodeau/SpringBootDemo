package com.webage.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private long id;
    private String firstName;
    private String lastName;

    public Employee(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}

@RestController
public class IndexController {
    private static List<Employee> employees = new ArrayList<Employee>();

    static {
        employees.add(new Employee(1, "Charles", "Babbage"));
        employees.add(new Employee(2, "Ada", "Lovelace"));
        employees.add(new Employee(3, "Grace", "Hopper"));
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("/hello")
    public String hello() {
        String message = System.getenv("APP_MESSAGE");

        String payload = String.format("message: %s", message);

        return payload;
    }


}
