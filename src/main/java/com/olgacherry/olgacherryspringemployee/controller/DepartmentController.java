package com.olgacherry.olgacherryspringemployee.controller;

import com.olgacherry.olgacherryspringemployee.employee.Employee;
import com.olgacherry.olgacherryspringemployee.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

@GetMapping("/max-salary")
    public Employee getEmployeeWhithMaxSalary(@RequestParam Integer departmentId){
        return departmentService.getEmployeeWhithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWhithMinSalary(@RequestParam Integer departmentId){
        return departmentService.getEmployeeWhithMinSalary(departmentId);
}
    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam Integer departmentId){
        return departmentService.getEmployeesByDepartment(departmentId);
    }
    @GetMapping("/all/collected-by-department")
    public Map<Integer,List<Employee>> getEmployeesCollectedByDepartment(){
        return departmentService.getEmployeesCollectedByDepartment();
    }
}
