package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.db.utils.ModDataBaseConnection;


public class ModEmployeeServiceImpl {

	public void inputValidation(EmployeeBean bean, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(bean.getFirstName()!="") {
			if(bean.getLastName()!="") {
				if(bean.getEmail()!="") {
					if(bean.getID()!="") {
						ModDataBaseConnection data = new ModDataBaseConnection();
						data.connection(bean,response);
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
