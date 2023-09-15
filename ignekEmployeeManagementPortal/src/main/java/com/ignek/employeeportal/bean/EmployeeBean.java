package com.ignek.employeeportal.bean;

public class EmployeeBean {
	private String employeeId;
	private String employeeName;
	private String employeeDesignation;
	private String employeePhoneNumber;
	private String employeeSalary;
	private String employeeDepartmentId;
	
	
	public EmployeeBean(String employeeId, String employeeName, String employeeDesignation, String employeePhoneNumber,
			String employeeSalary, String employeeDepartmentId) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeePhoneNumber = employeePhoneNumber;
		this.employeeSalary = employeeSalary;
		this.employeeDepartmentId = employeeDepartmentId;
	}
	
	
	public EmployeeBean(String employeeName, String employeeDesignation, String employeePhoneNumber,
			String employeeSalary, String employeeDepartmentId) {
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeePhoneNumber = employeePhoneNumber;
		this.employeeSalary = employeeSalary;
		this.employeeDepartmentId = employeeDepartmentId;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}
	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}
	public String getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}
	public void setEmployeeDepartmentId(String employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}
	
}
