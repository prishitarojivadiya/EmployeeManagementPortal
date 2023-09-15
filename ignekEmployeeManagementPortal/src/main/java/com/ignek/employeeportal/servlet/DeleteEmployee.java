package com.ignek.employeeportal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.ignek.employeeportal.bean.EmployeeBean;
import com.ignek.employeeportal.dao.EmployeeDAO;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		employeeDAO = new EmployeeDAO();
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		employeeDAO.deleteEmployeeDetail(id);
        resp.sendRedirect("index.jsp");
	}

}
