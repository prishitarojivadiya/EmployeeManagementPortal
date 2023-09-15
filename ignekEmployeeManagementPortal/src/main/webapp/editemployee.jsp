<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ignek.employeeportal.dao.EmployeeDAO" %>
<%@page import="com.ignek.employeeportal.bean.EmployeeBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee Page</title>
<%@include file="css.jsp" %>
</head>
<body>
	<%@include file="navbar.jsp" %>	
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<p class="fs-3 text-center">Edit Details</p>
					<%
						String employeeid=request.getParameter("id");
						EmployeeDAO empdao = new EmployeeDAO();
						EmployeeBean emp = empdao.readEmployeeDetailsById(employeeid);
					%>
					<form action="UpdateEmployee" method="post">
						<div class="mb-3">
							<label class="form-label">Employee Name</label> 
							<input type="text" name="employeename" value="<%=emp.getEmployeeName()%>" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee Designation</label> 
							<input type="text" name="employeedesignation"  value="<%= emp.getEmployeeDesignation() %>" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee PhoneNumber</label> 
							<input type="text" name="employeephonenumber" value="<%=emp.getEmployeePhoneNumber()%>" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee Salary</label> 
							<input type="text" name="employeesalary" value="<%=emp.getEmployeeSalary()%>" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee DepartmentId</label> 
							<input type="text" name="employeedepartmentid" value="<%=emp.getEmployeeDepartmentId()%>" class="form-control">
						</div>
						<input type="hidden" name="employeeid" value="<%= emp.getEmployeeId() %>">
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>