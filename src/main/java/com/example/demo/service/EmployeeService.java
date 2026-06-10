package com.example.demo.service;

import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    Logger log = (Logger) LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        log.info("Save the Employee :");
        return employeeRepository.save(employee);
    }

    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getByDepartmentNative(String department) {
        return employeeRepository.findByDepartmentNative(department);
    }

    public List<Employee> getHighSalaryEmployees(Double salary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThan(salary);
    }

    public List<EmployeeDepartmentDTO> getDepartmentProjection() {
        log.info("getDepartmentProjection");
        return employeeRepository.fetchEmployeeDepartments();
    }

    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.searchEmployees(keyword);
    }

    public List<Employee> findByName(String Name) { return employeeRepository.findByName(Name); }
}
