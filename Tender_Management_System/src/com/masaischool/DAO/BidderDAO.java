package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.BidderDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface BidderDAO {

	public List<BidderDTO> ViewAllBidsofaTender(String Tenderid)throws SomethingWentWrongException,NoRecordFoundException;
	public List<BidderDTO> ViewAllBidsOfaVendor(String VendorId)throws SomethingWentWrongException,NoRecordFoundException;
	
}
