# EmployeeManagementPortal
This repository contains an Employee Management Portal using JSP and Servlets with CRUD functionality is a great project to learn web development with Java. 
-Database of Employee Management Portal.
    -create database employeemanagementportal;
    -use employeemanagementportal;
    -create table employee(
        employeeId VARCHAR(10) primary key,
        employeeName VARCHAR(50) not null,
        employeeDesignation VARCHAR(50) not null,
        employeePhoneNumber Varchar(15),
        employeeSalary Integer,
        employeeDepartmentId Integer not null
    );

-Creates Dynamic web project
    -Created a package for Java files.
        -com.ignek.employeeportle.bean
            -Create an EmployeeBean class to get and set the value of the employee table.
        -com.ignek.employeeportle.dao
            -Create an EmployeeDAO class to connect the database and set Create read update and delete query.
        -com.ignek.employeeportle.servlet
            -Create Servlet files for create, read, update and delete operations.
        -Create JSP pages for the user interface
            -Created css.jsp which includes Bootstrap 5’s css and JS links.
            -Created navbar.jsp which contains the navbar code of bootstrap is created for reusability.
            -insertemployee.jsp to insert employee details.
            -editemployee.jsp to edit employee details.
            -index.jsp is home page.

