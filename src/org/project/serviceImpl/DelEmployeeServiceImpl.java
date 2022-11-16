package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.db.utils.DelDataBaseConnection;

public class DelEmployeeServiceImpl {

	public void dataValidation(EmployeeBean employeebean, DelEmployeeServiceImpl delemployee,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
		String ID = employeebean.getID();
		if(ID.length()!=0) {
			
			DelDataBaseConnection deldata = new DelDataBaseConnection();
			deldata.connection(response, employeebean);
	    }
		else {
			request.setAttribute("errorIDdel","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}

	}
}
