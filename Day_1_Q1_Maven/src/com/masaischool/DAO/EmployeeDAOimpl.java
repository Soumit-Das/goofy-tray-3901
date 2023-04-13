package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.EmployeeDTO;
import com.masaischool.DTO.EmployeeDTOimpl;
import com.masaischool.Exception.EmployeeException;

public class EmployeeDAOimpl implements EmployeeDAO{

	@Override
	public String registerEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		String str = null;   
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String INSERT_QUERY = "INSERT INTO EMPLOYEE VALUES(?,?,?,?)";
			  
			  PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			  
			  ps.setInt(1, employee.getEmpId());
			  ps.setString(2, employee.getName());
			  ps.setString(3, employee.getAddress());
			  ps.setInt(4, employee.getSalary());
			  
			  str = employee.toString();
			  System.out.println(str);
			  
			  ps.executeUpdate();
			System.out.println("Registered Successfully");
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
		return str;

	}

	@Override
	public EmployeeDTO getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		EmployeeDTO ed = null; 
		try {
			connection = DBUtils.ConnectToDatabse();
			String SELECT_QUERY = "SELECT * FROM EMPLOYEE WHERE empId = ?";
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ed = new EmployeeDTOimpl();
				ed.setEmpId(rs.getInt("empId"));
				ed.setName(rs.getString("name"));
				ed.setAddress(rs.getString("address"));
				ed.setSalary(rs.getInt("salary"));
			}
		}catch(SQLException e) {
			  throw new EmployeeException(e.getMessage());
		  }finally {
			  try {
				DBUtils.closeConnection(connection);
			  } catch (SQLException e) {
				  throw new EmployeeException(e.getMessage());
			  }
		  }
		return ed;

	}

	
private boolean isResultsetEmpty(ResultSet rs)throws SQLException{
		
		return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;
		
	}
	
	
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<EmployeeDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				System.out.println("No Record Found");
			}
			
			while(rs.next()) {	
				list.add(new EmployeeDTOimpl(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
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
	public String deleteEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		String str = null;   
		EmployeeDTO employee = new EmployeeDTOimpl();
		  try {
			  

			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE empId = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
			  
			  ps.setInt(1, empId);
			  
			  str = employee.toString();
			  System.out.println(str);
			  
			  ps.executeUpdate();
			System.out.println("Deleted Successfully");
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
		return str;
	}

	@Override
	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		String str = null;   
		EmployeeDTO employee = new EmployeeDTOimpl();
		  try {
			  connection = DBUtils.ConnectToDatabse();
//			  try (Connection conn = dataSource.getConnection();
//		         PreparedStatement ps = conn.prepareStatement("UPDATE employee SET salary = salary + ? WHERE id = ?")) {
//		        ps.setDouble(1, bonus);
//		        ps.setInt(2, employeeId);
//		        ps.executeUpdate();
//		    } catch (SQLException e) {
//		        throw new RuntimeException(e);
//		    }
			  String UPDATE_QUERY = "UPDATE employee SET salary = salary + ? WHERE empId = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			  
			  ps.setInt(1, amount);
			  ps.setInt(2, empId);
			  
			  str = employee.toString();
			  System.out.println(str);
			  
			  ps.executeUpdate();
			System.out.println("Bonus added Successfully");
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
		return str;
	}

}
