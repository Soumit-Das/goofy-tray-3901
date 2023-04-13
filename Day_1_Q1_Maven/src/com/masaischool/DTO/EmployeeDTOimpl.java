package com.masaischool.DTO;

public class EmployeeDTOimpl implements EmployeeDTO{

	
	int empId;
    String name; 
	String address;
	int salary;
	
	public EmployeeDTOimpl() {};
	
	public EmployeeDTOimpl(int empId, String name, String address, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	@Override
	public int getEmpId() {
		return empId;
	}
	@Override
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int getSalary() {
		return salary;
	}
	@Override
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmpId : " + empId + ", Name : " + name + ", Address : " + address + ", Salary : " + salary
				+ "\n";
	}
	
	
	
	
}
