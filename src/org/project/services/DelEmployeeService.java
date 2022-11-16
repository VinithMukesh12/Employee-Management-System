package org.project.services;

import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.serviceImpl.DelEmployeeServiceImpl;

public interface DelEmployeeService {
	public void dataValidation(EmployeeBean employeebean, DelEmployeeServiceImpl delemployee,HttpServletResponse response);
}
