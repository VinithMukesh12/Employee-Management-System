package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.TimeSheetBean;
import org.project.db.utils.GetTimeStampDatabase;

public class GetTimeSheetServiceImpl {

	public void validation(TimeSheetBean bean,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(bean.getId()!="") {
			GetTimeStampDatabase data = new GetTimeStampDatabase();
			data.connection(bean, response);
		}
		else {
			request.setAttribute("errorGTSID","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
	}

}
