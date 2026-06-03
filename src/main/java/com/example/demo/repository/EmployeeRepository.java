package com.example.demo.repository;

import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findByName(String Name);

    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);

    @Query(value = "SELECT * FROM employees WHERE department = :department", nativeQuery = true)
    List<Employee> findByDepartmentNative(@Param("department") String department);

    @Query(value = "SELECT name, department FROM employees", nativeQuery = true)
    List<EmployeeDepartmentDTO> fetchEmployeeDepartments();

    @Query(value = "SELECT * FROM employees WHERE name LIKE %:keyword%", nativeQuery = true)
    List<Employee> searchEmployees(@Param("keyword") String keyword);
}
