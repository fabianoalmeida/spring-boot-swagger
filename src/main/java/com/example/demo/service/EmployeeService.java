package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {

	/**
	 * Method to create new employees in the db using mongo-db repository.
	 * 
	 * @param emp
	 */
	public void createEmployee(List<Employee> emp);

	/**
	 * Method to fetch all employees from the db using mongo-db repository.
	 * 
	 * @return
	 */
	public Collection<Employee> getAllEmployees();

	/**
	 * Method to fetch employee by id using mongo-db repository.
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Employee> findEmployeeById(String id);

	/**
	 * Method to delete employee by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void deleteEmployeeById(String id);

	/**
	 * Method to update employee by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void updateEmployee(Employee emp);

	/**
	 * Method to delete all employees using mongo-db repository.
	 */
	public void deleteAllEmployees();

}
