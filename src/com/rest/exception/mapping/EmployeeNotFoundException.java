package com.rest.exception.mapping;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = -656892604165799803L;
	public static final String NOT_FOUND_MESSAGE = "Employee not found, please insert correct value.";
	
	@Override
	public String getMessage() {
		
		return "Employee not found, please insert correct value.";
	}
	
}