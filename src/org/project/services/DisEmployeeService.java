package org.project.services;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.serviceImpl.DisEmployeeServiceImpl;

public interface DisEmployeeService {
	public void dataValidation(EmployeeBean employeebean, DisEmployeeServiceImpl disemployee,HttpServletResponse response);
}
