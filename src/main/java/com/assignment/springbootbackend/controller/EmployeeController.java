package com.assignment.springbootbackend.controller;

import com.assignment.springbootbackend.model.Employee;
import com.assignment.springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return  employeeService.saveEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
