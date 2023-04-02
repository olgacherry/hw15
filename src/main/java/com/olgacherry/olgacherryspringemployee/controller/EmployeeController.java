package com.olgacherry.olgacherryspringemployee.controller;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.EmployeeServise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServise employeeServise;

    public EmployeeController(EmployeeServise employeeServise) {
        this.employeeServise = employeeServise;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
return employeeServise.addEmployee(firstName,lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServise.removeEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServise.findEmployee(firstName,lastName);
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeServise.getAllEmployees();
    }
}