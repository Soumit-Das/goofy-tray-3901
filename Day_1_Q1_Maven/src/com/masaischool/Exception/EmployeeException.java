package com.masaischool.Exception;

public class EmployeeException extends Exception{

	public EmployeeException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "No Record Found Exception " + getMessage();
	}
	
	
	
}
