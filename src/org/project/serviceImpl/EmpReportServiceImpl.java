package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.EmployeeBean;
import org.project.db.utils.EmpReportDataBase;

public class EmpReportServiceImpl {

	public void validation(EmployeeBean bean,HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
		if(bean.getID()!="") {
			EmpReportDataBase data = new EmpReportDataBase();
			data.connection(bean, response);
		}else {
			request.setAttribute("errorIDdis","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
	}

}
