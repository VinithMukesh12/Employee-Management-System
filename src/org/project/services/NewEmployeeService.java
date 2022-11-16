package org.project.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;

public interface NewEmployeeService {
	public void inputValidation(EmployeeBean employeebean,HttpServletRequest request,HttpServletResponse response);
}
