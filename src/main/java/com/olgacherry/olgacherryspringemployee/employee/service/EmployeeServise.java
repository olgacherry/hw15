package com.olgacherry.olgacherryspringemployee.employee.service;

import com.olgacherry.olgacherryspringemployee.employee.Employee;

import java.util.List;

public interface EmployeeServise {
    Employee addEmployee(String firstName,String lastName);
    Employee  removeEmployee(String firstName,String lastName);
    Employee findEmployee(String firstName,String lastName);
    List<Employee> getAllEmployees();
}
