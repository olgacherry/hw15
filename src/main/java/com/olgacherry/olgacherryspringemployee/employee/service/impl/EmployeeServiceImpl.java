package com.olgacherry.olgacherryspringemployee.employee.service.impl;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.EmployeeServise;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeAlreadyAddedException;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServise {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
            return employee;

            }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());

        }
            throw new EmployeeNotFoundException();

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
                return employees.get(employee.getFullName());

            }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}