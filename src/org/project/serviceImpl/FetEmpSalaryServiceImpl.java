package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;
import org.project.db.utils.FetEmpSalaryDatabase;

public class FetEmpSalaryServiceImpl {

	public void validation(SalaryBean bean, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (bean.getId() != "") {
			if (bean.getDesignation() != "") {
				if (bean.getSalary() != "") {
					FetEmpSalaryDatabase data = new FetEmpSalaryDatabase();
					data.connection(bean, response);
				} else {
					request.setAttribute("errorFESID", "TimeOut cannot be empty");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.include(request, response);
				}
			} else {
				request.setAttribute("errorFESdes", "TimeIn cannot be empty");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request, response);
			}
		} else {
			request.setAttribute("errorFESsal", "Date cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request, response);
		}
	}

}
