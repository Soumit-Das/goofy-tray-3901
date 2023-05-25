package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.VendorDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface VendorDAO {

	public List<VendorDTO> ViewVendors()throws SomethingWentWrongException,NoRecordFoundException;
	public List<VendorDTO> ViewAllBidsofaTender(String TenderId)throws SomethingWentWrongException,NoRecordFoundException;
	public boolean VerifyVendercredentials(String UserName,String Password)throws SomethingWentWrongException,NoRecordFoundException;
	public void Updatecredentials(String Name,String Password,String VendorId)throws SomethingWentWrongException;
	public boolean VerifyVendercredentialsforUpdate(String VendorId) throws SomethingWentWrongException, NoRecordFoundException;
}
