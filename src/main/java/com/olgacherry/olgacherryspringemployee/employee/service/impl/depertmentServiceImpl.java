package com.olgacherry.olgacherryspringemployee.employee.service.impl;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.DepartmentServise;
import com.olgacherry.olgacherryspringemployee.employee.service.EmployeeServise;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class depertmentServiceImpl implements DepartmentServise {


    private final EmployeeServise employeeServise;
    public depertmentServiceImpl(EmployeeServise employeeServise) {
        this.employeeServise = employeeServise;
    }
    @Override
    public Employee getEmployeeWhithMaxSalary(Integer departmentId) {
        Collection<Employee>employees=employeeServise.getAllEmployees();
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee getEmployeeWhithMinSalary(Integer departmentId) {
        Collection<Employee>employees=employeeServise.getAllEmployees();
        return employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    };


    @Override
    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        Collection<Employee>employees=employeeServise.getAllEmployees();
        return employees.stream()
                .filter(it->it.getDepartment()==departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesCollectedByDepartment() {
        Collection<Employee>employees=employeeServise.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}
