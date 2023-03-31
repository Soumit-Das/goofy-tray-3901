package com.masaischool.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.VendorDAO;
import com.masaischool.DAO.VendorDAOimpl;
import com.masaischool.DTO.VendorDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class VenderUI {

	static void ViewVendors() {
		
		List<VendorDTO> list = new ArrayList<>();
		VendorDAO ven = new VendorDAOimpl();
		try {
			list = ven.ViewVendors();
			System.out.println(list);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
static void ViewAllBidsofaTender(Scanner sc) {
		
		System.out.println("Enter Tender_id whose bids will be displayed");
		String tender_id = sc.next();
		VendorDAO ven = new VendorDAOimpl();
        try {
			ven.ViewAllBidsofaTender(tender_id);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

static void UpdateAccDetails(Scanner sc) {
	
	System.out.println("Enter new vender name");
	String name = sc.next();
	System.out.println("Enter new vender password");
	String password = sc.next();
	
}


}
