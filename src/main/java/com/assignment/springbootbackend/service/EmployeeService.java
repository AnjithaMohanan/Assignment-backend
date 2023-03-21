package com.assignment.springbootbackend.service;

import com.assignment.springbootbackend.model.Employee;
import com.assignment.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    public Optional<Employee> getEmployeeById(int id){
        return employeeRepository.findById(id);

    }
    @Override
    public List<Employee>getAllEmployee(){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }
    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setAge(employee.getAge());
        employeeToUpdate.setProfession(employee.getProfession());
        return employeeRepository.save(employeeToUpdate);
    }
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
