package com.olgacherry.olgacherryspringemployee.service;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.impl.EmployeeServiceImpl;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeAlreadyAddedException;
import com.olgacherry.olgacherryspringemployee.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    @Test
    public void shouldTrowExceptionWhenEmployeeIsAlreadyPresentedInRepository(){
        Employee employee = new Employee("Сергей","Петров",120000,1);
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,()->employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()));

    }
    @Test
    public void shouldReturnCorrectEmployee(){
        Employee employee = new Employee("Сергей","Петров",120000,1);
        Employee addedEmployee = employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment());
        Assertions.assertEquals(employee, addedEmployee);

    }
    @Test
    public void shouldTrowExceptionWhenEmployeeIsNotFoundInRepository(){
        Employee employee = new Employee("Сергей","Петров",120000,1);
        Assertions.assertThrows(EmployeeNotFoundException.class,()-> employeeService.removeEmployee(employee.getFirstName(), employee.getLastName()));
    }
    @Test
    public void shouldTrowExceptionWhenEmployeeNotFoundInRepository(){
       Employee employee = new Employee("Сергей","Петров",120000,1);
       Assertions.assertThrows(EmployeeNotFoundException.class,()-> employeeService.findEmployee(employee.getFirstName(), employee.getLastName()));
    }
}
