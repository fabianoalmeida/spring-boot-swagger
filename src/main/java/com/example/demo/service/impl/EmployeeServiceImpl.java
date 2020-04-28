package com.example.demo.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#createEmployee(java.util.List)
     */
    @Override
    public void createEmployee(List<Employee> emp) {
    	repository.saveAll(emp);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#getAllEmployees()
     */
    @Override
    public Collection<Employee> getAllEmployees() {
        return repository.findAll();
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#findEmployeeById(int)
     */
    @Override
    public Optional<Employee> findEmployeeById(String id) {
        return repository.findById(id);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#deleteEmployeeById(int)
     */
    @Override
    public void deleteEmployeeById(String id) {
    	repository.deleteById(id);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#updateEmployee(int)
     */
    @Override
    public void updateEmployee(Employee emp) {
    	repository.save(emp);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#deleteAllEmployees()
     */
    @Override
    public void deleteAllEmployees() {
    	repository.deleteAll();
    }
	
}
