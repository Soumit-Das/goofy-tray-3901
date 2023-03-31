package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.TenderDTO;
import com.masaischool.DTO.TenderDTOimpl;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;



public class TenderDAOimpl implements TenderDAO{

	@Override
	public void addTender(TenderDTO tenddto) throws SomethingWentWrongException {
		// 
	  Connection connection = null;
	  
	  try {
		  
		  connection = DBUtils.ConnectToDatabse();
		  
		  String INSERT_QUERY = "INSERT INTO TENDER VALUES(?,?)";
		  
		  PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
		  
		  ps.setString(1, tenddto.getTender_id());
		  ps.setString(2, tenddto.getTender_Name());
		  
		  ps.executeUpdate();
		  
	  }catch(SQLException e) {
		  System.out.println(e);
	  }finally {
		  try {
			DBUtils.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
		
	}
	
private boolean isResultsetEmpty(ResultSet rs)throws SQLException{
		
		return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;
		
	}
	

	@Override
	public List<TenderDTO> ViewTenders() throws SomethingWentWrongException, NoRecordFoundException {
		// View all Tenders
		
		Connection connection = null;
		List<TenderDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT * FROM TENDER";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found");
			}
			
			while(rs.next()) {
				
				list.add(new TenderDTOimpl(rs.getString("Tender_id"),rs.getString("Tender_Name")));
				
			}
			
			
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<TenderDTO> ViewTenderByTenderId(String tend_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<TenderDTO> list = new ArrayList<>(); 
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String INSERT_QUERY = "SELECT * FROM TENDER WHERE Tender_id = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			  
			  ps.setString(1, tend_id);
			  
			  ResultSet rs = ps.executeQuery();
				
				if(isResultsetEmpty(rs)) {
					throw new NoRecordFoundException("No Record Found");
				}
				
				while(rs.next()) {
					list.add(new TenderDTOimpl(rs.getString("Tender_id"),rs.getString("Tender_Name")));
				}
			  
		  }catch(SQLException e) {
			  System.out.println(e);
		  }finally {
			  try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		return list;
		
	}
		

	

}
