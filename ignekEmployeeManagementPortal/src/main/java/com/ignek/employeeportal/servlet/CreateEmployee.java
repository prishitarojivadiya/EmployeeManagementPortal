package com.ignek.employeeportal.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.employeeportal.bean.EmployeeBean;
import com.ignek.employeeportal.dao.EmployeeDAO;



@WebServlet("/CreateEmployee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		employeeDAO = new EmployeeDAO();
		super.init();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String employeeId=request.getParameter("employeeid");
			String employeeName=request.getParameter("employeename");
			String employeeDesignation=request.getParameter("employeedesignation");
			String employeePhoneNumber=request.getParameter("employeephonenumber");
			String employeeSalary=request.getParameter("employeesalary");
			String employeeDepartmentId=request.getParameter("employeedepartmentid");
			EmployeeBean newemp = new EmployeeBean(employeeId, 
					employeeName, 
					employeeDesignation, 
					employeePhoneNumber,
					employeeSalary,
					employeeDepartmentId);
			employeeDAO.insertEmployeeDetail(newemp);
			response.sendRedirect("index.jsp");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	

}
