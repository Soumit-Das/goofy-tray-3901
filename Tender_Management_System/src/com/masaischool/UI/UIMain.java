package com.masaischool.UI;

import java.util.Scanner;

import com.masaischool.DAO.VendorDAO;
import com.masaischool.DAO.VendorDAOimpl;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class UIMain {

	static void adminMenu() {
		
		System.out.println("0. Logout");
		System.out.println("1. View all the vendors.");
		System.out.println("2. Create new tenders.");
		System.out.println("3. View All the Tenders.");
		System.out.println("4. View All the Bids of a tender.");
		System.out.println("6. Assign tender to a vendor.");
		
	}
	
	
	static void Displayadminmenu(Scanner sc) {
		int choice;
		do {
		adminMenu();
		System.out.println("Enter Selection");
		choice = sc.nextInt();
		
		switch(choice) {
		
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
//			AdminUI.AssignTenditoVendi();
			break;
		default : System.out.println("Sahi option select krna nhi ata BDSK");	
		
		}
		
	
	}while(choice != 0);
	}
	
	static void adminLogin(Scanner sc){
		
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			Displayadminmenu(sc);
		}else {
			System.out.println("Wrong credentials , Fuck off u bitch");
		}
		
	}
	
	static void VendorMenu() {
		
		System.out.println("0. Logout");
		System.out.println("1. Update account details and change password.");
		System.out.println("2. View all the current Tenders.");
		System.out.println("3. Place a Bid against a Tender.");
		System.out.println("4. View his own Bid History with bid status");
		System.out.println("5. Search for a tender by tender id or date range.");
		
	}
	
	static void DisplayVendormenu(Scanner sc) {
		int choice;
		do {
		VendorMenu();
		System.out.println("Enter Selection");
		choice = sc.nextInt();
		
		switch(choice) {
		
		case 0:
//			VendorUI.logout()  Temporary purpose
			System.out.println("Logged out");
			break;
		case 1:
//			VenderUI.UpdateAccDetails(); Update account details pending
			break;
		case 2:
			TenderUI.ViewTenders();
			break;
		case 3:
//			TenderUI.PlaceBid();
			break;
		case 4:
//			Vendor.viewbidhistory();
			break;
		case 5:
			TenderUI.ViewtenderByid(sc);
			break;
		default : System.out.println("Sahi option select krna nhi ata BDSK");	
		
		}
		
	
	}while(choice != 0);
	}
	
	static void vendorLogin(Scanner sc){
		
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		VendorDAO ven = new VendorDAOimpl();
		try {
			try {
				if(ven.VerifyVendercredentials(username,password)) {
					DisplayVendormenu(sc);
				}else {
					System.out.println("Wrong credentials , Fuck off u bitch");
				}
			} catch (NoRecordFoundException e) {
				System.out.println("Wrong credentials , Fuck off u bitch");

			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
   public static void main(String[] args) {
	
	   Scanner sc = new Scanner(System.in);
	   System.out.println("1. Admin Login");
	   System.out.println("2. Vendor Login");
	   int choice = sc.nextInt();
	   
	   switch(choice) {
	   
	   case 1:
		   adminLogin(sc);
		   break;
	   case 2:
		   vendorLogin(sc);
		   break;
	   
	   default : System.out.println("Choose appropriate option");	   
	   }
	   
}
	
}
