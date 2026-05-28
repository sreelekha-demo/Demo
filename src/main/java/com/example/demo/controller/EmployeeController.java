package com.example.demo.controller;

import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return employeeService.getByDepartment(department);
    }

    @GetMapping("/native/{department}")
    public List<Employee> getByDepartmentNative(@PathVariable String department) {
        return employeeService.getByDepartmentNative(department);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> getHighSalaryEmployees(@PathVariable Double salary) {
        return employeeService.getHighSalaryEmployees(salary);
    }

    @GetMapping("/projection")
    public List<EmployeeDepartmentDTO> getProjection() {
        return employeeService.getDepartmentProjection();
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String keyword) {
        return employeeService.searchEmployees(keyword);
    }
}
