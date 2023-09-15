<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.ignek.employeeportal.dao.EmployeeDAO" %>
<%@page import="com.ignek.employeeportal.bean.EmployeeBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
<%@include file="css.jsp" %>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                	<br>
                	<br>
                    <h3 class="text-center">List of Employee</h3>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                  			<tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Designation</th>
                                <th>Phone number</th>
                                <th>Salary</th>
                                <th>Department id</th>
                                <th>Actions</th>
                            </tr>
                         
                        </thead>
                        <tbody>
                            <%
                            	EmployeeDAO dao= new EmployeeDAO();
                            	List<EmployeeBean> emp= dao.readAllEmployeeDetails();
                            	for(EmployeeBean e:emp){
                                
		                    %>
								<tr>
									<td scope="row"><%= e.getEmployeeId() %></td>
									<td><%= e.getEmployeeName() %></td>
									<td><%= e.getEmployeeDesignation() %></td>
									<td><%= e.getEmployeePhoneNumber() %></td>
									<td><%= e.getEmployeeSalary() %></td>
									<td><%= e.getEmployeeDepartmentId() %></td>
									<td><a href="editemployee.jsp?id=<%=e.getEmployeeId()%>">edit</a> 
										<a href="DeleteEmployee?id=<%= e.getEmployeeId()%>">Delete</a></td>
								</tr>
							<%
                            	}
                            %>
                        </tbody>

                    </table>
                </div>
            </div>
</body>
</html>