package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.TimeSheetBean;
import org.project.db.utils.RemTimeSheetDataBase;

public class RemTimeSheetServiceImpl {

	public void validation(TimeSheetBean bean,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(bean.getMMMYYYY()!="") {
			RemTimeSheetDataBase data = new RemTimeSheetDataBase();
			data.connection(bean, response);
		}
		else {
			request.setAttribute("errorRTSMY","Month&Year cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
		
	}

}
