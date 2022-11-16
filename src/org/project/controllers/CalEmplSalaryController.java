package org.project.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;
import org.project.serviceImpl.CalEmplSalaryServiceImpl;

/**
 * Servlet implementation class CalEmplSalaryController
 */
@WebServlet("/CalEmplSalaryController")
public class CalEmplSalaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalEmplSalaryController() {
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
		String Id = request.getParameter("ID");
		SalaryBean bean = new SalaryBean();
		Connection conn = null;
		Statement st = null;
		CalEmplSalaryServiceImpl service = new CalEmplSalaryServiceImpl();
		bean.setId(Id);
		service.validation(bean, request, response, conn, st);
	}

}
