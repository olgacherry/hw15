package com.olgacherry.olgacherryspringemployee.controller;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.EmployeeServise;
import com.olgacherry.olgacherryspringemployee.validation.EmployeeValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class EmployeeController {
    private final EmployeeServise employeeServise;

    public EmployeeController(EmployeeServise employeeServise) {
        this.employeeServise = employeeServise;
    }

    @GetMapping("/add")
    public ResponseEntity <Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if(EmployeeValidator.validate(firstName,lastName)) {
            return ResponseEntity.ok(employeeServise.addEmployee(firstName, lastName));
        }
return ResponseEntity.badRequest().build();
    }

    @GetMapping("/remove")
    public ResponseEntity <Employee> removeEmployee(@RequestParam String firstName, @RequestParam String lastName){
        if(EmployeeValidator.validate(firstName,lastName)){
            employeeServise.removeEmployee(firstName,lastName);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity <Employee> findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        if(EmployeeValidator.validate(firstName,lastName)){
            return ResponseEntity.ok(employeeServise.findEmployee(firstName,lastName));
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeServise.getAllEmployees();
    }
}