package org.project.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.project.beans.EmployeeBean;

import org.project.serviceImpl.EmpReportServiceImpl;

/**
 * Servlet implementation class EmpReportController
 */
@WebServlet("/EmpReportController")
public class EmpReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		EmployeeBean bean = new EmployeeBean();
		bean.setID(id);
		EmpReportServiceImpl service = new EmpReportServiceImpl();
		service.validation(bean, response, request);
		
		//response.setContentType("application/pdf");
	}

}
