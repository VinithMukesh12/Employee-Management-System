package org.project.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.beans.SalaryBean;
import org.project.db.utils.CalEmplSalaryDataBase;

public class CalEmplSalaryServiceImpl {

	public void validation(SalaryBean bean,HttpServletRequest request,HttpServletResponse response,Connection conn,Statement st) throws ServletException, IOException {
		if(bean.getId()!="") {
			CalEmplSalaryDataBase data = new CalEmplSalaryDataBase();
			data.connection(bean, response,conn,st);
		}
		else {
			request.setAttribute("errorCESID","ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request,response);
		}
		
	}

	public void salResult(SalaryBean bean,HttpServletResponse response,Statement st ) throws IOException, SQLException {
		PrintWriter out = response.getWriter();
		String ID = bean.getId();
		ResultSet rs= st.executeQuery("SELECT SUM(WORKHOURS)FROM EMPLOYEETIMESHEET WHERE ID="+ID+"");
		if(rs.next()) {
		int hours = rs.getInt(1);
		ResultSet rt = st.executeQuery("SELECT PERHOUR FROM EMPLOYEESALARY WHERE ID="+ID+"");
		if(rt.next()) {
		double perhour = rt.getDouble(1);
		double salary = (hours*perhour);
		out.println("Employee ID:"+ID);
		out.println("Total number of hours worked by Employee:"+hours);
		out.println("Total salary of employee to be given:"+salary);
		}
		}
	}

}
