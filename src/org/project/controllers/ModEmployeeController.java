package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.serviceImpl.ModEmployeeServiceImpl;

/**
 * Servlet implementation class ModEmployeeController
 */
@WebServlet("/ModEmployeeController")
public class ModEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModEmployeeServiceImpl service = new ModEmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Email =request.getParameter("email");
		String ID = request.getParameter("ID");
		
		bean.setFirstName(FirstName);
		bean.setLastName(LastName);
		bean.setEmail(Email);
		bean.setID(ID);
		service.inputValidation(bean,request, response);
		
	}

}
