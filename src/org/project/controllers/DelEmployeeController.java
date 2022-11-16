package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.serviceImpl.DelEmployeeServiceImpl;

/**
 * Servlet implementation class DelEmployeeController
 */
@WebServlet("/DelEmployeeController")
public class DelEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelEmployeeController() {
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
		EmployeeBean employeebean = new EmployeeBean();
		String ID = request.getParameter("ID");
		employeebean.setID(ID);
		DelEmployeeServiceImpl delemployee = new DelEmployeeServiceImpl();
		delemployee.dataValidation(employeebean, delemployee, response, request);
	}

}
