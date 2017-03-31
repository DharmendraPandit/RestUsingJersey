package com.rest.dao;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeDao {

	public List<Employee> fetchAll();

	public Employee fetchEmployeeById(String id);
}
