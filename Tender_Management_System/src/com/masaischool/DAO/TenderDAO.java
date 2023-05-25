package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.TenderDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface TenderDAO {

	public void AddTender(TenderDTO TenderDto)throws SomethingWentWrongException;
	public List<TenderDTO> ViewTenders()throws SomethingWentWrongException,NoRecordFoundException;
	public List<TenderDTO> ViewTenderByTenderId(String TenderId)throws SomethingWentWrongException,NoRecordFoundException;
	public void AssignTendertoVender(String TenderName,String VendorName)throws SomethingWentWrongException;
	public boolean VerifyTenderName(String TenderName) throws SomethingWentWrongException, NoRecordFoundException;
	public boolean VerifyVenderid(String VendorId) throws SomethingWentWrongException, NoRecordFoundException;
}
