package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.db.utils.DisDataBaseConnection;

public class DisEmployeeServiceImpl {

	public void dataValidation(EmployeeBean employeebean, DisEmployeeServiceImpl disemployee,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
		
		if(employeebean.getID()!="") {
			DisDataBaseConnection data = new DisDataBaseConnection();
			data.connection(employeebean, response);
		}
		else {
			request.setAttribute("errorERID","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
	}

}
