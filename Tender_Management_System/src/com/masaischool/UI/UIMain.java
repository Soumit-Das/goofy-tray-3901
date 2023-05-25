package com.masaischool.UI;

import java.util.Scanner;

import com.masaischool.DAO.VendorDAO;
import com.masaischool.DAO.VendorDAOimpl;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class UIMain {

	static void AdminMenu() {
		System.out.println("");
		System.out.println("0. Logout");
		System.out.println("1. View all the vendors.");
		System.out.println("2. Create new tenders.");
		System.out.println("3. View All the Tenders.");
		System.out.println("4. View All the Bids of a tender.");
		System.out.println("5. Assign tender to a vendor.");
		System.out.println("");
	}
	
	
	static void DisplayAdminMenu(Scanner sc) {
		int Choice;
		do {
			AdminMenu();
		System.out.println("Enter Selection");
		Choice = sc.nextInt();
		System.out.println("");
		switch(Choice) {
		
		case 0:
//			AdminUI.logout()  Temporary purpose
			System.out.println("Logged out");
			break;
		case 1:
			VenderUI.ViewVendors();
			break;
		case 2:
			TenderUI.CreateTender(sc);
			break;
		case 3:
			TenderUI.ViewTenders();
			break;
		case 4:
			VenderUI.ViewAllBidsofaTender(sc);
			break;
		case 5:
			try {
				TenderUI.AssignTenditoVendi(sc);
			} catch (SomethingWentWrongException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			break;
		default : System.out.println("Wrong credentials");	
		
		}
	}while(Choice != 0);
	}
	
	static void AdminLogin(Scanner sc){
		
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			System.out.println("Welcome Admin");
			DisplayAdminMenu(sc);
		}else {
			System.out.println("Wrong credentials");
		}
		
	}
	
	static void VendorMenu() {
		
		System.out.println("");
		System.out.println("0. Logout");
		System.out.println("1. Update account details and change password.");
		System.out.println("2. View all the current Tenders.");
		System.out.println("3. Place a Bid against a Tender.");
		System.out.println("4. View his own Bid History with bid status");
		System.out.println("5. Search for a tender by tender id or date range.");
		System.out.println("");
	}
	
	static void DisplayVendorMenu(Scanner sc) {
		int Choice;
		do {
		VendorMenu();
		System.out.println("Enter Selection");
		Choice = sc.nextInt();
		System.out.println("");
		switch(Choice) {
		
		case 0:
//			VendorUI.logout()  Temporary purpose
			System.out.println("Logged out");
			break;
		case 1:
			try {
				VenderUI.UpdateAccDetails(sc);
			} catch (SomethingWentWrongException e) {
				// TODO Auto-generated catch blockXj
				e.printStackTrace();
			} catch (NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			TenderUI.ViewTenders();
			break;
		case 3:
//			TenderUI.PlaceBid();
			break;
		case 4:
			try {
				VenderUI.ViewBidHistory(sc);
			} catch (SomethingWentWrongException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			TenderUI.ViewtenderByid(sc);
			break;
		default : System.out.println("Wrong choice");	
		
		}
		
	
	}while(Choice != 0);
	}
	
	static void VendorLogin(Scanner sc){
		
		System.out.println("Enter Username");
		String Username = sc.next();
		System.out.println("Enter password");
		String Password = sc.next();
		VendorDAO Vendor = new VendorDAOimpl();
		try {
			try {
				if(Vendor.VerifyVendercredentials(Username,Password)) {
					DisplayVendorMenu(sc);
				}else {
					System.out.println("Wrong credentials");
				}
			} catch (NoRecordFoundException e) {
				System.out.println("Wrong credentials");

			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
   public static void main(String[] args) {
	   System.out.println("-------------------------------------------------------------");
	   System.out.println("");
	   System.out.println("           Welcome to Tender Management System");
	   System.out.println("");

	   System.out.println("-------------------------------------------------------------");
	   System.out.println("");
	   
	   
	   Scanner sc = new Scanner(System.in);
	   System.out.println("1. Admin Login");
	   System.out.println("2. Vendor Login");
	   int Choice = sc.nextInt();
	   
	   switch(Choice) {
	   
	   case 1:
		   AdminLogin(sc);
		   break;
	   case 2:
		   VendorLogin(sc);
		   break;
	   
	   default : System.out.println("Choose appropriate option");	   
	   }
	   
}
	
}
