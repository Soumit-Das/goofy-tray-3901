package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.VendorDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface VendorDAO {

	public List<VendorDTO> ViewVendors()throws SomethingWentWrongException,NoRecordFoundException;
	public List<VendorDTO> ViewAllBidsofaTender(String Tender_id)throws SomethingWentWrongException,NoRecordFoundException;
	public boolean VerifyVendercredentials(String username,String password)throws SomethingWentWrongException,NoRecordFoundException;
	
}
