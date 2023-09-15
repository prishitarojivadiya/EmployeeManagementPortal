package com.ignek.employeeportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.ignek.employeeportal.bean.EmployeeBean;

public class EmployeeDAO {
	private String url="jdbc:mysql://localhost:3306/employeemanagementportal";
	private String userName="root";
	private String password="";
	private static final String INSERT_EMPLOYEE_DETAILS = 
			"INSERT INTO employee (employeeId, employeeName, employeeDesignation, employeePhoneNumber, employeeSalary, employeeDepartmentId) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_EMPLOYEE_BY_ID = "SELECT employeeId, employeeName, employeeDesignation, employeePhoneNumber, employeeSalary, employeeDepartmentId FROM employee WHERE employeeId=?";
	private static final String SELECT_ALL_EMPLOYEE ="SELECT * FROM employee";
	private static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee SET employeeName=?, employeeDesignation=?, employeePhoneNumber=?, employeeSalary=?, employeeDepartmentId=? WHERE employeeId=?";
	private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee where employeeId=?";
	
	protected Connection getConnection() {
		Connection connection =null;
		try {
			//load driver classes
			Class.forName("com.mysql.jdbc.Driver");
			//making connection with database
			connection = DriverManager.getConnection(url,userName,password);
		}catch(SQLException e) {
			e.getStackTrace();
		}catch(ClassNotFoundException e) {
			e.getStackTrace();
		}
		return connection;		
	}
	
	public void insertEmployeeDetail(EmployeeBean emp) throws SQLException{
		try (Connection connection=getConnection();PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_DETAILS);){
			preparedStatement.setString(1,emp.getEmployeeId());
			preparedStatement.setString(2,emp.getEmployeeName());
			preparedStatement.setString(3,emp.getEmployeeDesignation());
			preparedStatement.setString(4,emp.getEmployeePhoneNumber());
			preparedStatement.setString(5,emp.getEmployeeSalary());
			preparedStatement.setString(6,emp.getEmployeeDepartmentId());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public EmployeeBean readEmployeeDetailsById(String employeeId) {
		EmployeeBean emp = null;
		try (Connection connection=getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
			preparedStatement.setString(1, employeeId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String employeeName=rs.getString("employeeName");
				String employeeDesignation=rs.getString("employeeDesignation");
				String employeePhoneNumber=rs.getString("employeePhoneNumber");
				String employeeSalary=rs.getString("employeeSalary");
				String employeeDepartmentId=rs.getString("employeeDepartmentId");
				emp = new EmployeeBean(employeeId, 
									   employeeName, 
									   employeeDesignation, 
									   employeePhoneNumber,
									   employeeSalary,
									   employeeDepartmentId
									   );
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
		
	}
	
	public List<EmployeeBean> readAllEmployeeDetails(){
		List<EmployeeBean> listofemployee = new ArrayList<>();
		try (Connection connection=getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);){
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String employeeId=rs.getString("employeeId");
				String employeeName=rs.getString("employeeName");
				String employeeDesignation=rs.getString("employeeDesignation");
				String employeePhoneNumber=rs.getString("employeePhoneNumber");
				String employeeSalary=rs.getString("employeeSalary");
				String employeeDepartmentId=rs.getString("employeeDepartmentId");
				listofemployee.add( new EmployeeBean(employeeId, 
									   employeeName, 
									   employeeDesignation, 
									   employeePhoneNumber,
									   employeeSalary,
									   employeeDepartmentId
									   ));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listofemployee;
	}
	
	public boolean updateEmployeeDetail(EmployeeBean emp) throws SQLException{
		boolean rowupdated = false;
		try (Connection connection=getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);)
		{
				preparedStatement.setString(1, emp.getEmployeeName());
				preparedStatement.setString(2, emp.getEmployeeDesignation());
				preparedStatement.setString(3, emp.getEmployeePhoneNumber());
				preparedStatement.setString(4, emp.getEmployeeSalary());
				preparedStatement.setString(5, emp.getEmployeeDepartmentId());
				preparedStatement.setString(6, emp.getEmployeeId());
				rowupdated = preparedStatement.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowupdated;
		
	}
	
	public void deleteEmployeeDetail(String employeeId) {
//		boolean rowdeleted = false;
		try (Connection connection=getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);)
		{
				preparedStatement.setString(1, employeeId);
//				rowdeleted = preparedStatement.executeUpdate() > 0;
				preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		return rowdeleted;
	}
}
