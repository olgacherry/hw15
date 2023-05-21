package com.olgacherry.olgacherryspringemployee.employee.service;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWhithMaxSalary( Integer departmentId);
    public Employee getEmployeeWhithMinSalary(Integer departmentId);
    public List<Employee> getEmployeesByDepartment( Integer departmentId);
    public Map<Integer,List<Employee>> getEmployeesCollectedByDepartment();
}
