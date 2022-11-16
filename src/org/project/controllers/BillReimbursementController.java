package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.BenefitBean;
import org.project.serviceImpl.BillReimbursementServiceImpl;

/**
 * Servlet implementation class BillReimbursementController
 */
@WebServlet("/BillReimbursementController")
public class BillReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillReimbursementController() {
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
		String ID = request.getParameter("ID");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		BillReimbursementServiceImpl service = new BillReimbursementServiceImpl();
		BenefitBean bean = new BenefitBean();
		bean.setID(ID);
		bean.setAmount(amount);
		service.validation(bean, request, response);
	}

}
