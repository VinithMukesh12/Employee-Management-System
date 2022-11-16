package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.serviceImpl.NewEmployeeServiceImpl;

/**
 * Servlet implementation class NewEmployeeController
 */
@WebServlet("/NewEmployeeController")
public class NewEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewEmployeeServiceImpl emp = new NewEmployeeServiceImpl();
		EmployeeBean employeebean = new EmployeeBean();
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Email =request.getParameter("email");
		String ID = request.getParameter("ID");
		
		employeebean.setFirstName(FirstName);
		employeebean.setLastName(LastName);
		employeebean.setEmail(Email);
		employeebean.setID(ID);
		emp.inputValidation(employeebean,request, response);
	}

}
