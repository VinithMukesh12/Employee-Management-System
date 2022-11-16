package org.project.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.TimeSheetBean;
import org.project.serviceImpl.GetTimeSheetServiceImpl;

/**
 * Servlet implementation class GetTimeSheetcontroller
 */
@WebServlet("/GetTimeSheetcontroller")
public class GetTimeSheetcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTimeSheetcontroller() {
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
		GetTimeSheetServiceImpl service = new GetTimeSheetServiceImpl();
		TimeSheetBean bean = new TimeSheetBean();
		String ID = request.getParameter("ID");
		bean.setId(ID);
		service.validation(bean, request, response);
	}

}
