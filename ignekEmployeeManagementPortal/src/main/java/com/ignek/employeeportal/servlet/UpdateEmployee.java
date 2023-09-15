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
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		employeeDAO = new EmployeeDAO();
		super.init();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String employeeId=request.getParameter("employeeid");
		String employeeName=request.getParameter("employeename");
		String employeeDesignation=request.getParameter("employeedesignation");
		String employeePhoneNumber=request.getParameter("employeephonenumber");
		String employeeSalary=request.getParameter("employeesalary");
		String employeeDepartmentId=request.getParameter("employeedepartmentid");
		try {
			EmployeeBean emp = new EmployeeBean(employeeId, employeeName, employeeDesignation, employeePhoneNumber, employeeSalary, employeeDepartmentId);
			boolean result = employeeDAO.updateEmployeeDetail(emp);
			if(result == true) {
				response.sendRedirect("index.jsp");
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}
	}
}
