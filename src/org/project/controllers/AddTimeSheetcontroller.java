package org.project.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.project.beans.TimeSheetBean;
import org.project.serviceImpl.AddTimeSheetServiceImpl;

/**
 * Servlet implementation class AddTimeSheetcontroller
 */
@WebServlet("/AddTimeSheetcontroller")
public class AddTimeSheetcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTimeSheetcontroller() {
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
		String DATE = request.getParameter("date");
		String TIMEIN = request.getParameter("timein");
		String TIMEOUT = request.getParameter("timeout");
		TimeSheetBean bean = new TimeSheetBean();
		bean.setId(ID);
		bean.setDate(DATE);
		bean.setTimein(TIMEIN);
		bean.setTimeout(TIMEOUT);
		AddTimeSheetServiceImpl service = new AddTimeSheetServiceImpl();
		service.validation(bean, request, response);
	}

}
