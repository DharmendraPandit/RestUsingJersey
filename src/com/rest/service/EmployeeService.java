package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(String id);
	
}
