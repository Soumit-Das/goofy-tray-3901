package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.TenderDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface TenderDAO {

	public void addTender(TenderDTO tenddto)throws SomethingWentWrongException;
	public List<TenderDTO> ViewTenders()throws SomethingWentWrongException,NoRecordFoundException;
	public List<TenderDTO> ViewTenderByTenderId(String tend_id)throws SomethingWentWrongException,NoRecordFoundException;
	
}
