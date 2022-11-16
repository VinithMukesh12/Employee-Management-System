package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.db.utils.NewDataBaseConnection;



public class NewEmployeeServiceImpl {
	public void inputValidation(EmployeeBean employeebean,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String FirstName=employeebean.getFirstName();
		String LastName=employeebean.getLastName();
		String Email = employeebean.getEmail();
		String ID = employeebean.getID();
		if(employeebean.getFirstName()!="") {
			if(employeebean.getLastName()!="") {
				if(employeebean.getEmail()!="") {
					if(employeebean.getID()!="") {
						System.out.println(FirstName);
						System.out.println(LastName);
						System.out.println(Email);
						System.out.println(ID);
						NewDataBaseConnection data = new NewDataBaseConnection();
						data.connection(employeebean,response);
					}else {
						request.setAttribute("errorID","ID cannot be empty");
						RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
						rs.include(request,response);
					}
				}else {
					request.setAttribute("errorEmail","Email cannot be empty");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.include(request,response);
				}
			}else {
				request.setAttribute("errorLName","Lastname cannot be empty");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request,response);
			}
		}else {
			request.setAttribute("errorFName","Firstname cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
	}

}
