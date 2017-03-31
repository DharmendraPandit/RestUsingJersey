package com.rest.service.impl;

import java.util.List;

import com.rest.dao.EmployeeDao;
import com.rest.dao.impl.EmployeeDaoImpl;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = employeeDao.fetchAll();

		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {

		System.out.println("getEmployeeById called.");
		Employee employee = employeeDao.fetchEmployeeById(id);

		return employee;
	}

}
