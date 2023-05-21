package com.olgacherry.olgacherryspringemployee.service;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.DepartmentService;
import com.olgacherry.olgacherryspringemployee.employee.service.EmployeeService;
import com.olgacherry.olgacherryspringemployee.employee.service.impl.DepartmentServiceImpl;
import com.olgacherry.olgacherryspringemployee.employee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        final int departmentId = 1;
        Employee employee1 = new Employee("Сергей", "Петров", 70000, 1);
        Employee employee2 = new Employee("Алексей", "Иванов", 90000, 1);
        Employee employee3 = new Employee("Илья", "Сидоров", 100000, 1);
        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);
        employees.put(employee3.getFirstName() + employee3.getLastName(), employee3);
        when(employeeService.getAllEmployees()).thenReturn(employees.values());
        Employee employeeWithMaxSalary = departmentService.getEmployeeWhithMaxSalary(departmentId);
        Assertions.assertEquals(employee3, employeeWithMaxSalary);
    }

    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        final int departmentId = 1;
        Employee employee1 = new Employee("Сергей", "Петров", 70000, 1);
        Employee employee2 = new Employee("Алексей", "Иванов", 90000, 1);
        Employee employee3 = new Employee("Илья", "Сидоров", 100000, 1);
        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);
        employees.put(employee3.getFirstName() + employee3.getLastName(), employee3);
        when(employeeService.getAllEmployees()).thenReturn(employees.values());
        Employee employeeWithMinSalary = departmentService.getEmployeeWhithMinSalary(departmentId);
        Assertions.assertEquals(employee1, employeeWithMinSalary);
    }

    @Test
    public void shouldReturnNullWhenDepartmentIsEmpty() {
        List<Integer> list = new ArrayList<>();
        Assertions.assertTrue(list.isEmpty());
    }
}