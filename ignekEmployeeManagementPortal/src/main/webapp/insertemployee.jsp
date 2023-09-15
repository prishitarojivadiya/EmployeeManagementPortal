<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Employee Page</title>
<%@include file="css.jsp" %>
</head>
<body>
	<%@include file="navbar.jsp" %>	
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<p class="fs-3 text-center">Add New Employee</p>
					<form action="CreateEmployee" method="post">
						<div class="mb-3">
							<label class="form-label">Employee Id</label> 
							<input type="text" name="employeeid" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee Name</label> 
							<input type="text" name="employeename" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee Designation</label> 
							<input type="text" name="employeedesignation" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee PhoneNumber</label> 
							<input type="text" name="employeephonenumber" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee Salary</label> 
							<input type="text" name="employeesalary" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Employee DepartmentId</label> 
							<input type="text" name="employeedepartmentid" class="form-control">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>