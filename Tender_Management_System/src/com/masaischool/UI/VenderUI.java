package com.masaischool.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.BidderDAO;
import com.masaischool.DAO.BidderDAOimpl;
import com.masaischool.DAO.VendorDAO;
import com.masaischool.DAO.VendorDAOimpl;
import com.masaischool.DTO.BidderDTO;
import com.masaischool.DTO.VendorDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class VenderUI {

	static void ViewVendors() {
		
		List<VendorDTO> list = new ArrayList<>();
		VendorDAO Vendor = new VendorDAOimpl();
		try {
			list = Vendor.ViewVendors();
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
	    List<BidderDTO> list = new ArrayList<>();
		System.out.println("Enter Tender_id whose bids will be displayed");
		String TenderId = sc.next();
		BidderDAO Vendor = new BidderDAOimpl();
        try {
        	list = Vendor.ViewAllBidsofaTender(TenderId);
        	System.out.println(list);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

static void UpdateAccDetails(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
	VendorDAO Vendor = new VendorDAOimpl();
	System.out.println("Enter vender id whose credentials you want to update");
	String VendorId = sc.next();
	
	if(Vendor.VerifyVendercredentialsforUpdate(VendorId)) {
		System.out.println("Enter new vender name");
		String Name = sc.next();
		System.out.println("Enter new vender password");
		String Password = sc.next();
		
		try {
			Vendor.Updatecredentials(Name, Password, VendorId);
		    System.out.println("Updated successfully");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot update details");
			e.printStackTrace();
		}
	}else {
		System.out.println("Wrong vender id");
	}

}


static void ViewBidHistory(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
	BidderDAO Vendor = new BidderDAOimpl();
	System.out.println("Enter Vendor_id whose bids you want to view");
	String VendorId = sc.next();
	List<BidderDTO> list = new ArrayList<>();
	list = Vendor.ViewAllBidsofaTender(VendorId);
	System.out.println(list);
}


}
