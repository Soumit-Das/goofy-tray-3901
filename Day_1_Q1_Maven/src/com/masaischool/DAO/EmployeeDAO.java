package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.EmployeeDTO;
import com.masaischool.Exception.EmployeeException;

public interface EmployeeDAO {

	public String registerEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployeeById(int empId)throws EmployeeException;
	public List<EmployeeDTO> getAllEmployee();
	public String deleteEmployeeById(int empId)throws EmployeeException;
	public String giveBonusToEmployee(int empId, int amount)throws EmployeeException;
	
}
