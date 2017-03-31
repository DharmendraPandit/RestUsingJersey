package com.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.rest.dao.EmployeeDao;
import com.rest.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> fetchAll() {
		
		List<Employee> employees = new ArrayList<>();
		
		Employee employee1 = new Employee();
		employee1.setId("1");
		employee1.setName("employee1");

		employees.add(employee1);
		
		Employee employee2 = new Employee();
		employee2.setId("2");
		employee2.setName("employee2");
		
		employees.add(employee2);
		
		return employees;
	}
	
	
	@Override
	public Employee fetchEmployeeById(String id) {
		
		System.out.println("fetchEmployeeById called.");
		
		Employee employee = new Employee();
		employee.setId("1");
		employee.setName("abc");
		
		return null;
	}
	
}
