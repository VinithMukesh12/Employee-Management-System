package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.project.beans.TimeSheetBean;
import org.project.db.utils.AddTimeSheetDatabase;

public class AddTimeSheetServiceImpl {
	public void validation(TimeSheetBean bean,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(bean.getId()!="") {
			if(bean.getDate()!="") {
				if(bean.getTimein()!="") {
					if(bean.getTimeout()!="") {
						AddTimeSheetDatabase data = new AddTimeSheetDatabase();
						data.connection(bean, response);
					}else {
						request.setAttribute("errorATSTimeout","TimeOut cannot be empty");
						RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
						rs.include(request,response);
					}
				}else {
					request.setAttribute("errorATSTimein","TimeIn cannot be empty");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.include(request,response);
				}
			}else {
				request.setAttribute("errorATSDate","Date cannot be empty");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request,response);
			}
		}else {
			request.setAttribute("errorATSID","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
	}
}

