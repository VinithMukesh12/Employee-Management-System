package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;
import org.project.serviceImpl.FetEmpSalaryServiceImpl;

/**
 * Servlet implementation class FetEmpSalarycontroller
 */
@WebServlet("/FetEmpSalarycontroller")
public class FetEmpSalarycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetEmpSalarycontroller() {
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
		String id = request.getParameter("ID");
		String designation = request.getParameter("des");
		String salary = request.getParameter("sal");
		String MMMYYYY= request.getParameter("MMMYYYY");
		SalaryBean bean = new SalaryBean();
		FetEmpSalaryServiceImpl service = new FetEmpSalaryServiceImpl();
		bean.setId(id);
		bean.setDesignation(designation);
		bean.setSalary(salary);
		
		bean.setMMMYYYY(MMMYYYY);
		service.validation(bean, request, response);
	}

}
