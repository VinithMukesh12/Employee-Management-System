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
import org.project.db.utils.GenPaySlipEmpDataBase;

public class GenPaySlipEmpServiceImpl {

	public void validation(SalaryBean bean, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement st = null;

		if (bean.getId() != "") {
			GenPaySlipEmpDataBase data = new GenPaySlipEmpDataBase();
			data.connection(response, conn, st, bean);
		} else {
			request.setAttribute("errorgGPSEID", "ID cannot be empty");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.include(request, response);

		}
	}

	public void result(SalaryBean bean, Connection conn, Statement st, HttpServletResponse response)
			throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		String ID = bean.getId();
		ResultSet rs = st.executeQuery("SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE ID=" + ID + "");
		if (rs.next()) {
			String FirstName = rs.getString(1);
			String LastName = rs.getString(2);
			out.println("Name of the Employee:" + FirstName + "" + LastName);
			ResultSet rt = st.executeQuery("SELECT DESIGNATION,SALARY,INHAND FROM EMPLOYEESALARY WHERE ID=" + ID + "");
			if (rt.next()) {
				String Des = rt.getString(1);
				double salary = rt.getDouble(2);
				double inhand = rt.getDouble(3);
				double det = (salary - inhand);

				out.println("Designation of Employee:" + Des);
				out.println("Salary of Employee:" + salary);
				out.println("Total Deduction:" + det);
				out.println("Net Amount:" + inhand);
			}

		}
	}

}
