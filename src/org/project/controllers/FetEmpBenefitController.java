package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.BenefitBean;
import org.project.serviceImpl.FetEmpBenefitServiceImpl;

/**
 * Servlet implementation class FetEmpBenefitController
 */
@WebServlet("/FetEmpBenefitController")
public class FetEmpBenefitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetEmpBenefitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ID = request.getParameter("ID");
		BenefitBean bean = new BenefitBean();
		FetEmpBenefitServiceImpl service = new FetEmpBenefitServiceImpl();
		bean.setID(ID);
		service.validation(bean, request, response);
	}

}
