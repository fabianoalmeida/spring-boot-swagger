package com.example.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Employee")
@RequestMapping(value = "/api/emp")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save employees in the db.
	 * 
	 * @param emp
	 * @return
	 */
	@PostMapping(value = "/create")
	@ApiOperation(value = "Creating a list of employees")
	public String create(@RequestBody List<Employee> emp) {
		logger.debug("Saving employees.");
		service.createEmployee(emp);
		return "Employee records created.";
	}

	/**
	 * Method to fetch all employees from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall")
	public Collection<Employee> getAll() {
		logger.debug("Getting all employees.");
		return service.getAllEmployees();
	}

	/**
	 * Method to fetch employee by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getbyid/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value = "employee-id") String id) {
		logger.debug("Getting employee with employee-id= {}.", id);
		return service.findEmployeeById(id);
	}

	/**
	 * Method to update employee by id.
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value = "/update/{employee-id}")
	public String update(@PathVariable(value = "employee-id") String id, @RequestBody Employee e) {
		logger.debug("Updating employee with employee-id= {}.", id);
		e.setId(id);
		service.updateEmployee(e);
		return "Employee record for employee-id= " + id + " updated.";
	}

	/**
	 * Method to delete employee by id.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{employee-id}")
	public String delete(@PathVariable(value = "employee-id") String id) {
		logger.debug("Deleting employee with employee-id= {}.", id);
		service.deleteEmployeeById(id);
		return "Employee record for employee-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all employees from the db.
	 * 
	 * @return
	 */
	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all employees.");
		service.deleteAllEmployees();
		return "All employee records deleted.";
	}

}
