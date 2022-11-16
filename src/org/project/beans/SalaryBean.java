package org.project.beans;

public class SalaryBean {
	private String id ;
	private String designation;
	private String salary;
	private String MMMYYYY;
	public String getMMMYYYY() {
		return MMMYYYY;
	}
	public void setMMMYYYY(String mMMYYYY) {
		MMMYYYY = mMMYYYY;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}
