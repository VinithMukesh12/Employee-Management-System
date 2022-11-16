package org.project.serviceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.BenefitBean;
import org.project.db.utils.BillReimbursementDatabase;

public class BillReimbursementServiceImpl {

	public void validation(BenefitBean bean,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(bean.getID()!="") {
			if(bean.getAmount()!=0.00) {
				BillReimbursementDatabase data = new BillReimbursementDatabase();
				data.connection(response, bean);
			}else {
				request.setAttribute("errorBRCamount","Amount cannot be empty");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.include(request,response);
			}
		}else {
			request.setAttribute("errorBRCID","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
		}
	}
