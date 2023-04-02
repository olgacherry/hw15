package com.olgacherry.olgacherryspringemployee.employee.service.impl;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.EmployeeServise;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeAlreadyAddedException;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeNotFoundException;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServise {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if (employee != null) {
            throw new EmployeeAlreadyAddedException();
        }
        employee = new Employee(firstName, lastName);
        employees.add(employee);
            return employee;

            }





    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeNotFoundException();

        }

employees.remove(employee);

        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName, lastName);
        for (Employee employee:employees) {
            if (employee.equals(findEmployee)) {
                return employee;

            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}