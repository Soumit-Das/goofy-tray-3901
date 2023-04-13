package com.masaischool.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.EmployeeDAO;
import com.masaischool.DAO.EmployeeDAOimpl;
import com.masaischool.DTO.EmployeeDTO;
import com.masaischool.DTO.EmployeeDTOimpl;
import com.masaischool.Exception.EmployeeException;
import com.masaischool.Exception.SomethingWentWrongException;

public class UIMain {

	
//	static void adminMenu() {
//		
//		System.out.println("1. Register Employee");
//		
//	}
	
//	static void Displayadminmenu(Scanner sc) {
//		int choice;
//		do {
//		System.out.println("1. Register Employee");	
//		System.out.println("");
//        System.out.println("Enter Selection");
//		choice = sc.nextInt();
//		System.out.println("");
//		switch(choice) {
//		
//		case 1:
//			
//			break;
//		case 2:
//			
//			break;
//		case 3:
//			
//			break;
//		case 4:
//			
//			break;
//		case 5:
//			
//			break;
//		default : System.out.println("Wrong credentials");	
//		
//		}
//	}while(choice != 0);
//	}
	
	public static void main(String[] args) throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
//		EmpUI emp = new EmpUI();
		
		int choice;
		do {
		System.out.println("1. Register Employee");	
		System.out.println("2. Delete Employee");	
		System.out.println("3. Give Bonus to Employee");	
		System.out.println("4. Get employee by id");
		System.out.println("5. Get all employee");
		System.out.println("0. Exit");
		System.out.println("");
        System.out.println("Enter Selection");
		choice = sc.nextInt();
		System.out.println("");
		switch(choice) {
		
		case 1:
			System.out.println("Enter Employee id");
			int emp_id = sc.nextInt();
			System.out.println("Enter Employee Name");
			String name = sc.next();
			System.out.println("Enter Employee address");
			String address = sc.next();
			System.out.println("Enter Salary");
			int salary = sc.nextInt();
			
			EmployeeDTO emp = new EmployeeDTOimpl(emp_id,name,address,salary);
			
//			System.out.println(emp.toString());
			EmployeeDAO e = new EmployeeDAOimpl();
			
			e.registerEmployee(emp);
//			emp.regis(sc);
			break;	
			
		case 2:
			System.out.println("Enter employee whom you want to delete");
			int e_id = sc.nextInt();
			EmployeeDAO em = new EmployeeDAOimpl();
			em.deleteEmployeeById(e_id);
			break;
			
		case 3:
			System.out.println("Enter employee id");
			int em_id = sc.nextInt();
			System.out.println("Enter amount");
			int amt = sc.nextInt();
			EmployeeDAO ems = new EmployeeDAOimpl();
			ems.giveBonusToEmployee(em_id, amt);
			break;
			
		case 4:
			System.out.println("Enter employee id which you want to view");
			int ed = sc.nextInt();
			EmployeeDAO imsa = new EmployeeDAOimpl();
			System.out.println(imsa.getEmployeeById(ed));
			break;
			
		case 5:
			List<EmployeeDTO> list = new ArrayList<>();
			EmployeeDAO im = new EmployeeDAOimpl();
			list = im.getAllEmployee();
			System.out.println(list);
		}
	}while(choice != 0);
		System.out.println("Thank u for visiting, wapas laut k mat ana BDSK");
		
	}
	
}
